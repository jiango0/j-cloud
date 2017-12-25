package com.jzc.spring.cloud;

import com.jzc.spring.cloud.interceptor.PostFilter;
import com.jzc.spring.cloud.interceptor.PreFilter;
import com.jzc.spring.cloud.interceptor.ResultPostFilter;
import com.jzc.spring.cloud.interceptor.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public PreFilter getPreFilter() {return new PreFilter();}

    @Bean
    public RouteFilter getRouteFilter() {return new RouteFilter();}

    @Bean
    public PostFilter getPostFilter() {return new PostFilter();}

    @Bean
    public ResultPostFilter getResultPostFilter() {return new ResultPostFilter();}

}
