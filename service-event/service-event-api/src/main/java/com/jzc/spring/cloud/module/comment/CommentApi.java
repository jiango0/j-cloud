package com.jzc.spring.cloud.module.comment;

import com.jzc.spring.cloud.entity.PageList;
import com.jzc.spring.cloud.module.comment.dto.CommentDto;
import com.jzc.spring.cloud.module.comment.entity.Comment;
import com.jzc.spring.cloud.module.comment.vo.CommentVo;
import com.jzc.spring.cloud.web.ResultEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-event-provider")
public interface CommentApi {

    /**
     * 评论列表
     * @param   commentDto
     * @return
     * */
    @RequestMapping(value = "comment/list", method = RequestMethod.GET)
    ResultEntity<PageList<CommentVo>> list(CommentDto commentDto);

    /**
     * 评论详情
     * @param   kid
     * @return
     * */
    @RequestMapping(value = "comment/{kid}", method = RequestMethod.GET)
    ResultEntity<CommentVo> single(@PathVariable(value = "kid") Long kid);

    /**
     * 发布评论
     * @param   comment
     * @return
     * */
    @RequestMapping(value = "comment/single", method = RequestMethod.POST)
    ResultEntity<Comment> single(@RequestBody Comment comment);

    /**
     * 查询是否保存此评论
     * @param   kid
     * @param   type
     * @return
     * */
    @RequestMapping(value = "comment/exists", method = RequestMethod.GET)
    ResultEntity<Boolean> exists(Long kid, Integer type);

    /**
     * 删除评论
     * @param   kid
     * @param   type
     * @return
     * */
    @RequestMapping(value = "comment/del", method = RequestMethod.POST)
    ResultEntity<Integer> del(Long kid, Integer type);

}
