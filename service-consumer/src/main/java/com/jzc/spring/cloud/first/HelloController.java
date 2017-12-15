package com.jzc.spring.cloud.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return restTemplate.getForEntity("http://SERVICE-PROVIDER/hello", String.class).getBody();
    }


}
