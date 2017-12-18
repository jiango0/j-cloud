package com.jzc.spring.cloud.comment;

import com.jzc.spring.cloud.api.ICommentApi;
import com.jzc.spring.cloud.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    ICommentApi commentApi;

    @RequestMapping(value = "/{kid}", method = RequestMethod.GET)
    public Comment detail(@PathVariable Long kid) {
        return commentApi.detail(kid);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Comment> list() {
        List list = commentApi.list();
        return list;
    }

}
