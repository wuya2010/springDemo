package main.com.alibaba.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author kylinWang
 * @data 2021/5/23 15:47
 */
public class DaoUtil {
    private static ThreadLocal<Connection> tl;

    private static String url;
    private static String driverClass;
    private static String username;
    private static String password;

    private static Properties properties;

    static{

        tl=new ThreadLocal<>();

        InputStream is = DaoUtil.class.getClassLoader().getResourceAsStream("db.properties");

        properties=new Properties();

        try {
            properties.load(is);

            url=properties.getProperty("jdbcUrl");
            driverClass=properties.getProperty("driverClass");
            username=properties.getProperty("user");
            password=properties.getProperty("password");

            Class.forName(driverClass);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 返回一个连接
    public static Connection getConnection() throws SQLException {

        // 检查当前线程是否已经创建了Connection
        Connection connection = tl.get();

        if (connection==null) {

            connection = DriverManager.getConnection(url, username, password);

            tl.set(connection);

        }

        return connection;
    }

    // 关闭连接
    public static void closeConnection() throws SQLException {

        //
        Connection connection = tl.get();

        if (connection !=null) {

            connection.close();

            // 移除当前线程保存的对象
            tl.remove();

        }

    }
}
