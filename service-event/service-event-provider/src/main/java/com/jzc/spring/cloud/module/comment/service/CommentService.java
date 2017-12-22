package com.jzc.spring.cloud.module.comment.service;

import com.jzc.spring.cloud.module.comment.entity.Comment;

public interface CommentService {

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    Comment doComment(Comment comment);

}
