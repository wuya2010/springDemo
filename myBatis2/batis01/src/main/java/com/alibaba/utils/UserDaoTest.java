package com.alibaba.utils;

import com.alibaba.dao.UserDao;
import com.alibaba.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author kylinWang
 * @data 2021/5/12 22:50
 */
public class UserDaoTest {

    @Test
    public void test() {
        //静态方法的调用
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //使用getMapper 执行 sql 语句
        UserDao userdao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userdao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
