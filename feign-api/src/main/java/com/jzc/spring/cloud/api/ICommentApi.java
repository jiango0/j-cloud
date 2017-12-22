package com.jzc.spring.cloud.api;

import com.jzc.spring.cloud.entity.Comment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("feign-provider")
@RequestMapping(value="comment")
public interface ICommentApi {

    @RequestMapping(value = "{kid}", method = RequestMethod.GET)
    Comment detail(@PathVariable(value = "kid") Long kid);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    List<Comment> list();

}
