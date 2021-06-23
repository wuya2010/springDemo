package com.alibaba.controller;//package com.alibaba;
//
////import org.apache.commons.logging.LogFactory;
//
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;
//
///**
// * @author kylinWang
// * @data 2021/2/24 21:48
// */
//
//public class controller  implements Controller {
//
//  //  private static Log logger = LogFactory.getLog()
//
//    @Override
//    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
//        //创建返回对象
//        ModelAndView mv = new ModelAndView();
//        //添加模型数据，可以是任意的POJO对象
//        mv.addObject("message","Hello World");
//        //设置逻辑视图名,可以根据名字具体解析
//        mv.setViewName("/WEB-INF/welcome.jsp");
//        return mv;
//    }
//}
