package com.jzc.spring.cloud.module.comment;

import com.jzc.spring.cloud.entity.PageList;
import com.jzc.spring.cloud.module.comment.dto.CommentDto;
import com.jzc.spring.cloud.module.comment.entity.Comment;
import com.jzc.spring.cloud.module.comment.vo.CommentVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-event-provider")
@RequestMapping(value = "comment")
public interface CommentApi {

    /**
     * 评论列表
     * @param   commentDto
     * @return
     * */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    PageList<CommentVo> list(CommentDto commentDto);

    /**
     * 评论详情
     * @param   kid
     * @return
     * */
    @RequestMapping(value = "{kid}", method = RequestMethod.GET)
    CommentVo single(@PathVariable(value = "kid") Long kid);

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    @RequestMapping(value = "single", method = RequestMethod.POST)
    Comment single(@RequestBody Comment comment);

    /**
     * 删除评论
     * @param   comment
     * @return
     * */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    Integer del(@RequestBody Comment comment);

}
