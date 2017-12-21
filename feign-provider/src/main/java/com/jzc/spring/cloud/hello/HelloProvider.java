package com.jzc.spring.cloud.hello;

import com.jzc.spring.cloud.api.IHelloApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloProvider implements IHelloApi {

    @Override
    public String detail(@PathVariable Long kid) {
        return "hello kid "+kid;
    }

}
