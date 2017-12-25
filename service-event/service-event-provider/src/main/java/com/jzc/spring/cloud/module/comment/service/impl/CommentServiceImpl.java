package com.jzc.spring.cloud.module.comment.service.impl;

import com.jzc.spring.cloud.dao.mongo.MongodbComponent;
import com.jzc.spring.cloud.entity.PageList;
import com.jzc.spring.cloud.module.comment.dto.CommentDto;
import com.jzc.spring.cloud.module.comment.entity.Comment;
import com.jzc.spring.cloud.module.comment.service.CommentService;
import com.jzc.spring.cloud.module.comment.vo.CommentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    MongodbComponent<Comment> mongodbComponent;

    /**
     * 评论列表
     * @param   commentDto
     * @return
     * */
    public PageList<CommentVo> list(CommentDto commentDto) {
        List<CommentVo> resultList = new ArrayList<>();
        Query query = new Query();
        Integer currentPage = commentDto.getCurrentPage() == null ? 1 : commentDto.getCurrentPage();
        Integer pageSize = commentDto.getPageSize() == null ? 10 : commentDto.getPageSize();
        query.addCriteria(Criteria.where("infoId").in(commentDto.getInfoId()));
        long count = mongodbComponent.count(query, Comment.class);
        if(count > 0) {
            List<Comment> list = mongodbComponent.findPage(currentPage, pageSize, query, Comment.class);
            if(!CollectionUtils.isEmpty(list)){
                resultList = list.stream().map(comment -> {
                    CommentVo vo = new CommentVo();
                    BeanUtils.copyProperties(comment, vo);
                    return vo;
                }).collect(Collectors.toList());
            }
        }

        return new PageList<>(currentPage, pageSize, resultList, count);
    }

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    @Override
    public Comment doComment(Comment comment) {
        if(comment.getParentId() == null && comment.getTopId() == null){
            comment.setKid(System.currentTimeMillis());
            comment.setTopId(0L);
            mongodbComponent.insert(comment);
        }else{
            Assert.notNull(comment.getTopId(), "父评论ID不能为空");
            Assert.notNull(comment.getParentId(), "被回复评论ID不能为空");
            //通过parentId获取父评论
            Comment searchComment = mongodbComponent.selectById(Comment.class, comment.getParentId());
            if(searchComment == null){
                logger.error("searchComment is not =============================================");
            }
            //如果TOPID为0时，说明是父评论
            if(Long.valueOf(0).equals(searchComment.getTopId())) {
                //比较KID与TOPID是否相当
                if(!searchComment.getKid().equals(comment.getTopId())) {
                    logger.error("!id equals topid =============================================");
                }
            } else {
                //如果是子评论，直接判断TOPID是否相等
                if(!searchComment.getTopId().equals(comment.getTopId())) {
                    logger.error("!topid equals topid =============================================");
                }
            }
            comment.setTargetUserId(searchComment.getCreateUserId());//目标回复用户ID
            comment.setKid(System.currentTimeMillis());
            Update update = new Update();
            update.push("replyList", comment);

            mongodbComponent.update(new Query(Criteria.where("kid").in(searchComment.getKid())), update, Comment.class);
        }

        return comment;
    }

}
