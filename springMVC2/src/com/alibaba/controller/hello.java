//package com.alibaba.controller;
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
//
///**
// * @author kylinWang
// * @data 2021/5/12 23:15
// */
//public class hello implements Controller {
//
//    private static Log logger = LogFactory.getLog(hello.class);
//
//    @Override
//    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
//       logger.info("handleReques 被调");
//
//       //创建准备返回的 ModelAndView 对象， 包含乐返回视图名， 模型的名称, 模型对象
//        ModelAndView modelAndView = new ModelAndView();
//
//        //添加模型数据，可以是任意的对象
//        modelAndView.addObject("message","hello world");
//
//        //设置逻辑视图名，视图解析器根据该名字解析具体的视图页面
//        modelAndView.setViewName("/WEB-INF/content/welcome.jsp");
//
//        return modelAndView;
//    }
//
//}
