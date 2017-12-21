package com.jzc.spring.cloud.api;

import com.jzc.spring.cloud.entity.Comment;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("feign-provider")
public interface ICommentApi {

    @RequestMapping(value = "comment/{kid}", method = RequestMethod.GET)
    Comment detail(@PathVariable(value = "kid") Long kid);

    @RequestMapping(value = "comment/list", method = RequestMethod.GET)
    List<Comment> list();

}
