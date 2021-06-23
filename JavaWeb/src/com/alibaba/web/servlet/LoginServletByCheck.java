package com.alibaba.web.servlet;

import com.alibaba.web.bean.User;
import com.alibaba.web.dao.UserDao;
import com.alibaba.web.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kylinWang
 * @data 2021/5/22 19:27
 */
public class LoginServletByCheck extends HttpServlet {

    //构建新的对象不给默认值与给默认值
    private UserDao userDao;

    //构造器
    public LoginServletByCheck(){
        userDao = new UserDaoImpl();
    }


    //fixme: 所有的请求，都会封装为一个 httpserveletRequest 对象
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("接受到了请求");
        req.setCharacterEncoding("UTF-8");

        //验证参数的合法性
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //设置编码级
        resp.setContentType("test/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        try {
            User user = userDao.findUserByNameAndPassword(username, password);

            //如果数据库中没有对应的 id
            if(user == null){

                writer.print("it's wrong");
                //重定向： fixme: 浏览器解析，需要加上项目名/
                resp.sendRedirect("/index_test.html");


                //转发: fixme: 服务器解析
                // 将一个请求，继续转交给另外一个servlet继续处理，称为转发: 转发是由一个servlet转发给另外一个servlet，在服务器内部实现的，由服务器解析路径
                req.getRequestDispatcher("/index.jsp").forward(req,resp);


            }else{
                System.out.println("success");
                writer.print(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("get the quiery");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
