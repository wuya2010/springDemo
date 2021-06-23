package com.alibaba;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kylinWang
 * @data 2021/3/22 23:04
 */
public class Main {

    public static void main(String[] args) {

   //常规方法，创建对象并赋值
//        bean user = new bean();
//        user.setName("jim");
//        user.sayHello();


        /**
         * 1) 创建一个Spring的IOC容器对象
         * 2）从IOC容器中获取Bean实例
         * 3）调用sayHello()方法
         */

        //采用 spring 的方式
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("applicationContext .xml");
        //获取对象
        bean user = (bean) application.getBean("user");

        user.sayHello();
    }
}
