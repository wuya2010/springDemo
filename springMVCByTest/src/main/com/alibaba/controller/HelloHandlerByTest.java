package main.com.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author kylinWang
 * @data 2021/5/23 17:41
 */

@Controller
public class HelloHandlerByTest {

    @RequestMapping(value = "/hello") //会自动在前面添加 /spring
    public String handle1() {
        System.out.println("处理了hello请求！");
        return "success";
    }


    @RequestMapping(value = "/testRequestParam")
    public String handle2(@RequestParam(value = "name2", required = false, defaultValue = "mike")
                                  String name,
                          int age,
                          @RequestParam(value = "Connection") String value,
                          @CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("name:" + name);
        System.out.println("age:" + age);

        System.out.println(value);
        System.out.println(cookieValue);

        return "success";
    }


    @RequestMapping(value = "/testRequestParam1")
    public void handle3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ServletContext servletContext = request.getServletContext();

        String name1 = request.getParameter("name1");

        System.out.println("name1:" + name1);
        response.getWriter().print(true);

    }


    // 转发和重定向
    /*
     * 5. 转发和重定向
     * 			转发：    处理方法的返回值，必须是string.
     * 					return "forward:xxx"
     *
     * 					注意：  forward:/index.jsp
     * 						格式：  /不能丢，必须是绝对路径，使用 forward:，不会再调用
     * 							配置的视图解析器拼接地址。
     *
     * 			重定向：      处理方法的返回值，必须是string.
     * 					return "redirect:xxx"
     *
     * 					注意： "redirect:/hello1"
     * 							格式： /不能丢，必须是绝对路径，使用 redirect:，不会再调用
     * 							配置的视图解析器拼接地址。
     * 								不需要加项目名，系统会自动加上！
     */
    @RequestMapping(value="/hello1")
    public String handle4() {

        System.out.println("处理了hello1请求！");

        return "forward:/index.jsp";
    }

    //转发
    @RequestMapping(value="/hello2")
    public String handle5() {

        System.out.println("处理了hello2请求！");

        return "redirect:/hello1";
    }



    // @PathVariable只能获取单层路径
    @RequestMapping(value = "hello/{name}/{age}")
    public String handle5(
          @PathVariable(value = "name") String name,
          @PathVariable(value = "age") String age
    ){
        System.out.println(name);
        System.out.println(age);

        return "success";
    }

}
