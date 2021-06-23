package main.com.alibaba.dao;

import main.com.alibaba.bean.Employee;

import java.util.List;

/**
 * @author kylinWang
 * @data 2021/5/23 15:23
 */
public interface UserDao {
    List<Employee> getEmps()  throws Exception;
}
