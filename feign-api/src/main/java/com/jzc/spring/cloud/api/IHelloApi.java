package com.jzc.spring.cloud.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "feign-provider")
public interface IHelloApi {

    @RequestMapping(value = "hello/{kid}", method = RequestMethod.GET)
    String detail(@PathVariable(value = "kid") Long kid);

}
