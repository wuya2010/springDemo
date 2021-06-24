package com.alibaba.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author kylinWang
 * @data 2021/5/12 22:25
 */

/**
 * * 3. 使用
 * * 			①导入jar包
 * * 			②从 mybatis全局的配置文件 中构建 SqlSessionFactory
 * *
 * * 				 SqlSessionFactory负责创建SqlSession；
 * * 				SqlSession类似与JDBC中的connection，代表和数据库的一次对话（链接）。
 * *
 * * 				a）准备全局配置文件，配置数据库的环境
 * * 				b)导入mysql驱动
 * *
 * * 			③通过代码创建一个 SqlSessionFactory
 * * 			④通过SqlSessionFactory，创建一个sqlsession
 * * 			⑤准备POJO，编写sql语句所在的xml文件
 * * 			⑥在mybatis-config.xml中注册之前编写的sql语句所在的xml文件
 * * 			⑦调用sqlsession的api，传入sql语句的id和参数，执行！
 */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块： 用staitc声明，jvm加载类时执行，仅执行一次
    // fixme: 执行顺序 ：静态块,main(),构造块,构造方法
    static {
        try {
            //fixme: 读取sqlSessionFactory 对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
