package main.com.alibaba.controller;

import main.com.alibaba.bean.Employee;
import main.com.alibaba.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author kylinWang
 * @data 2021/5/23 16:53
 */

@Controller
public class RepsonseHandler {

    @Autowired
    private UserDao userDao;

    //服务器端

    /**
     *  * 3. @RequestMapping的produces属性，代表响应页面时，页面的内容类型
     *  * 			类似：  repsonse.setContextType(xxx);
     */
    @RequestMapping(value = "/response/handle1",produces="text/html;charset=utf-8")
    @ResponseBody //fixme: 将方法的返回值，直接作为响应体的内容，响应浏览器
    public String hadnle1(){
        System.out.println("处理了handle1请求！");

        return "成功！";
    }



    /*
     * 4. 在转发中，向域中保存数据
     * 		请求域：
     * 					①在方法位置声明一个Map类型/Model类型/ModelMap类型的形参
     * 					②将需要保存的数据放入到这个参数中即可
     *
     * 			无论使用Map/Model/ModelMap，都最终使用一个
     * 			org.springframework.validation.support.BindingAwareModelMap的同一个对象，
     * 			这个对象，称之为隐含模型。
     *
     * 			每次请求，框架都会创建一个BindingAwareModelMap的对象，这个对象称之为隐含模型，
     * 			作用就是在一次请求期间，保存数据。
     */
    //  如果页面是jsp页面，需要转发到jsp页面，传递数据
    @RequestMapping(value = "/response/handle2")
    public String handle2(Map map, Model model, ModelMap modelMap){

        System.out.println(map == model);

        System.out.println(map == modelMap);

        map.put("map",map.getClass().getName());
        model.addAttribute("model",model.getClass().getName());
        modelMap.addAttribute("modelMap",modelMap.getClass().getName());

        System.out.println("处理了handle2请求!");

        return "success";
    }


    /**
     *  * 5. 使用ModelAndView保存数据
     *  * 			ModelAndView是springmvc提供的一个类。
     *  * 				这个类即包含要去往的视图页面地址，还包含了一个模型，这个模型可以存放数据。
     * @return
     */
    @RequestMapping(value = "/response/handle3")
    public ModelAndView handle3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sucess");

        // 向此对象中保存数据
        mv.addObject("mv", "modelAndView");
        return mv;
    }


    @RequestMapping(value = "/response/handle4")
    public String hadnle4(HttpSession session){
        session.setAttribute("session","session");
        session.getServletContext().setAttribute("application", "application");
        return "success";
    }



    // 使用@ResponseBody，将方法的返回值，作为响应体，springmvc自动将对象转为jsonstr，添加到响应体
    @RequestMapping(value = "/response/sendAjax")
    @ResponseBody
    public Object hadle5() throws Exception {
        List<Employee> emps = userDao.getEmps();
        return emps;
    }


}
