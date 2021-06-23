package main.com.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kylinWang
 * @data 2021/5/19 22:40
 */

//spingmvc 只识别这个
@Controller
public class HelloHandler {

    /**
     * 启动不了，可以查看一下 project strucet 结构修复一下
     *
     * @return
     */

    //处理请求，指定处理请求的方法是哪一个 ==> fixme: 实现跳转
    @RequestMapping(value="/wang") //指定的请求对应配置文件中的 hr

    //指定返回值类型，String, 获取pages文件下的返回值
    public String handle1(){
        System.out.println("处理了hello请求！");
        //获取转发的路径 : E:\01_myselfProject\Base\springDemo\springMVCByTest\web\WEB-INF\pages\success.jsp
//        return "/WEB-INF/pages/succcss.jsp";
        return "succcss.jsp";
    }

    //访问路径： http://localhost:8080/springMVC/index.jsp

}
