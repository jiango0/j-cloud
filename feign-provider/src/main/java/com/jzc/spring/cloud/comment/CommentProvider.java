package com.jzc.spring.cloud.comment;

import com.jzc.spring.cloud.api.ICommentApi;
import com.jzc.spring.cloud.entity.Comment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentProvider implements ICommentApi {

    public Comment detail(@PathVariable Long kid) {
        return this.getData().stream().filter(comment -> kid.equals(comment.getKid())).findFirst().get();
    }

    public List<Comment> list() {
        return this.getData();
    }

    private List<Comment> getData() {
        return new ArrayList<Comment>() {{
            add(new Comment(1L, 2L, 3L, 4L, "第一条评论"));
            add(new Comment(11L, 12L, 13L, 14L, "第二条评论"));
            add(new Comment(21L, 22L, 23L, 24L, "第三条评论"));
        }};
    }

}
