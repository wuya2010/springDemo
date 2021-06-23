package com.alibaba.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author kylinWang
 * @data 2021/5/17 22:10
 */

//fixme: 最原始的servlet 接口
public class MyServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("MyServlet init...");
    }

    // 获取ServletConfig对象（配置对象）
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 获取ServletConfig对象（配置对象）
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("MyServlet service...");
    }

    // 返回servlet的信息说明
    @Override
    public String getServletInfo() {
        return null;
    }

    // servlet被销毁时，执行
    @Override
    public void destroy() {

    }
}
