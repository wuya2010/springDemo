package com.alibaba.utils;

import com.alibaba.dao.UserDao;
import com.alibaba.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author kylinWang
 * @data 2021/2/24 22:43
 */
public class UserDaoTestMain {

    //这里导入 Test 无法生成
    public static void main(String[] args) {
        //第一步：获取 sqlSession 对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //使用 getMapper 执行 sql 语句
        UserDao userdao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userdao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭 sqlSession
        sqlSession.close();
    }
}
