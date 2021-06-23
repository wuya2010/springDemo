package com.alibaba;

/**
 * @author kylinWang
 * @data 2021/3/22 23:01
 */
public class bean {
    // springframework/spring-core/5.2.3

    private String name;

    public void setName(String name){
        this.name = name;
    }
    public void sayHello(){
        System.out.println("hello " + name);
    }
}
