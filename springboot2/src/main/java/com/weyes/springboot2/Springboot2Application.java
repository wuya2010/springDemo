package com.weyes.springboot2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 程序入口，启动这个就类似于启动tomcat了，表示项目启动了
@SpringBootApplication
public class Springboot2Application {

    //    展开项目，里面有一个以 项目名+Application
//    命名的java类，里面有main方法，这个是 程序入口，启动这个就类似于启动tomcat了，表示项目启动了，同时在resource目录下有个application.properties,这里放配置文件，
//    存放配置内容，spring-boot启动的时候会来加载这个文件。


    //2. 可能是controller类的位置不对，spring-boot默认加载与自己启动类同包下或者子包下的内容，如果在这之外写的代码，是不会 被加载进来，所以 会找不到。这个切记，
    // 所以 一般把启动类拖到最外层，这样都可以 加载到了。


    //标识工程的主入口
    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

}
