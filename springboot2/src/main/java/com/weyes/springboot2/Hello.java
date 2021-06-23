package main.java.com.alibaba.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author kylinWang
 * @data 2021/3/22 23:25
 */

//情况1： 如果使用@controller注解，需要写@ResponseBody

@Controller  // 情况2：如果使用@Restcontroller注解,则不用加。因为该注解默认都是以json格式返回的
public class Hello {

    //@RestController +  @RequestMapping("hello")

    //处理什么请求
    @RequestMapping(value="/hello")
    @ResponseBody //向页面直接输出返回值
    public String helloForWeb() {
        System.out.println("处理了 hello 请求");
        return "hello world";
    }
}

//@RestController
//public class HelloController {
//    @RequestMapping("hello")
//    public String helloSpringBoot(){
//        return "hello spring boot";
//    }
//}

