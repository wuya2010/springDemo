package com.alibaba.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kylinWang
 * @data 2021/2/23 22:31
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String helloSpringBoot(){
     return "hello spring boot";
    }
}
