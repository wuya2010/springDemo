package com.alibaba.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author kylinWang
 * @data 2021/5/22 22:45
 */
public class DaoUtil {

    private static ThreadLocal<Connection> tl;

    private static String url;
    private static String driverClass;
    private static String password;
    private static String username;

    //属性
    private static Properties properties;

    //静态代码块
    static{
         tl = new ThreadLocal<>();

//        InputStream is = DaoUtil.class.getClassLoader().getResourceAsStream("db.properties");

         properties = new Properties();


        try{
            InputStream is = new FileInputStream(new File("E:\\01_myselfProject\\Base\\springDemo\\JavaWeb\\resources\\db.properties"));
            properties.load(is);
            url = properties.getProperty("jdbcUrl");
            driverClass = properties.getProperty("driverClass");
            password = properties.getProperty("password");
            username = properties.getProperty("user");

            Class.forName(driverClass);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 建立连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = tl.get();

        if(connection == null){
            connection = DriverManager.getConnection(url,username, password);

            tl.set(connection);
        }

        return connection;
    }

    /**
     * 关闭连接
     */
    public static void closeConnection() throws SQLException {
        Connection connection = tl.get();
        if(connection != null){
            connection.close();

            //移除当前线程保存的对象
            tl.remove();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DaoUtil.getConnection();

    }

}
