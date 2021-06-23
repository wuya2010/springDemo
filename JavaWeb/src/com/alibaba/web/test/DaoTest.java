package com.alibaba.web.test;

import com.alibaba.web.bean.User;
import com.alibaba.web.dao.UserDaoImpl;
import org.junit.Test;

/**
 * @author kylinWang
 * @data 2021/5/22 23:33
 */
public class DaoTest {

    @Test
    public void test() throws Exception {
        User user = new UserDaoImpl().findUserByNameAndPassword("jack", "123456");
        System.out.println(user);
    }
}
