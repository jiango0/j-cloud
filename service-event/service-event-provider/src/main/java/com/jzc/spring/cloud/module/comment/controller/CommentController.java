package com.jzc.spring.cloud.module.comment.controller;

import com.jzc.spring.cloud.entity.PageList;
import com.jzc.spring.cloud.module.comment.CommentApi;
import com.jzc.spring.cloud.module.comment.dto.CommentDto;
import com.jzc.spring.cloud.module.comment.entity.Comment;
import com.jzc.spring.cloud.module.comment.service.CommentService;
import com.jzc.spring.cloud.module.comment.vo.CommentVo;
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
    public PageList<CommentVo> list(CommentDto commentDto) {
        return null;
    }

    /**
     * 评论详情
     * @param   kid
     * @return
     * */
    @Override
    public CommentVo single(@PathVariable Long kid) {
        return null;
    }

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    @Override
    public Comment single(@RequestBody Comment comment) {
        return commentService.doComment(comment);
    }

    /**
     * 删除评论
     * @param   comment
     * @return
     * */
    @Override
    public Integer del(@RequestBody Comment comment) {
        return null;
    }

}
