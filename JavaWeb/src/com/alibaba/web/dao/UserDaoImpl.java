package com.alibaba.web.dao;

import com.alibaba.web.bean.User;
import com.alibaba.web.utils.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kylinWang
 * @data 2021/5/22 22:44
 */
public class UserDaoImpl implements UserDao {

    //实现接口方法
    @Override
    public User findUserByNameAndPassword(String Username, String password) throws Exception {

        User user1 = null;
        Connection connection = DaoUtil.getConnection();

        String sql = "select * from tbl_user where username= ? and password = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        //sql 中传入参数
        ps.setString(1,Username);
        ps.setString(2,password);

        ResultSet resultSet = ps.executeQuery();

        //遍历结果集
        while(resultSet.next()){
            user1 = new User();
            //
            user1.setId(resultSet.getInt("id"));
            user1.setPassword(resultSet.getString("username"));
            user1.setUsername(resultSet.getString("password"));
        }
        //返回user1对象
        return user1;
    }
}