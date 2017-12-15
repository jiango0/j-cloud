package com.jzc.spring.cloud.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "hello")
    public String hello() {
        return "hello, Spring cloud";
    }

}
