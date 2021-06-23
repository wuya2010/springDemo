package com.alibaba.web.dao;

import com.alibaba.web.bean.User;

/**
 * @author kylinWang
 * @data 2021/5/22 22:42
 */
public interface UserDao {
    User findUserByNameAndPassword(String Username , String password) throws Exception;
}
