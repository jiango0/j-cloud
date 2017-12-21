package com.jzc.spring.cloud.hello;

import com.jzc.spring.cloud.api.IHelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    IHelloApi helloApi;

    @RequestMapping(value = "/{kid}", method = RequestMethod.GET)
    public String detail(@PathVariable Long kid){
        return helloApi.detail(kid);
    }

}
