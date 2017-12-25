package com.jzc.spring.cloud.module.comment.service;

import com.jzc.spring.cloud.entity.PageList;
import com.jzc.spring.cloud.module.comment.dto.CommentDto;
import com.jzc.spring.cloud.module.comment.entity.Comment;
import com.jzc.spring.cloud.module.comment.vo.CommentVo;

public interface CommentService {

    /**
     * 评论列表
     * @param   commentDto
     * @return
     * */
    PageList<CommentVo> list(CommentDto commentDto);

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    Comment doComment(Comment comment);

}
