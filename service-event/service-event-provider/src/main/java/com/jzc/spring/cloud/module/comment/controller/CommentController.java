package com.jzc.spring.cloud.module.comment.controller;

import com.jzc.spring.cloud.entity.PageList;
import com.jzc.spring.cloud.module.comment.CommentApi;
import com.jzc.spring.cloud.module.comment.dto.CommentDto;
import com.jzc.spring.cloud.module.comment.entity.Comment;
import com.jzc.spring.cloud.module.comment.service.CommentService;
import com.jzc.spring.cloud.module.comment.vo.CommentVo;
import com.jzc.spring.cloud.web.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论
 * */
@RestController
public class CommentController implements CommentApi {

    @Autowired
    CommentService commentService;

    /**
     * 评论列表
     * @param   commentDto
     * @return
     * */
    @Override
    public ResultEntity<PageList<CommentVo>> list(CommentDto commentDto) {
        return ResultEntity.returnSuccess(commentService.list(commentDto));
    }

    /**
     * 评论详情
     * @param   kid
     * @return
     * */
    @Override
    public ResultEntity<CommentVo> single(@PathVariable Long kid) {
        return ResultEntity.returnSuccess(commentService.detail(kid));
    }

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    @Override
    public ResultEntity<Comment> single(@RequestBody Comment comment) {
        return ResultEntity.returnSuccess(commentService.doComment(comment));
    }

    /**
     * 查询是否保存此评论
     * @param   kid
     * @param   type
     * @return
     * */
    public ResultEntity<Boolean> exists(Long kid, Integer type) {
        return ResultEntity.returnSuccess(commentService.exists(kid, type));
    }

    /**
     * 删除评论
     * @param   kid
     * @param   type
     * @return
     * */
    public ResultEntity<Integer> del(Long kid, Integer type) {
        return ResultEntity.returnSuccess(commentService.deleteComment(kid, type));
    }

}
