package main.com.alibaba.dao;

import main.com.alibaba.bean.Employee;
import main.com.alibaba.utils.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kylinWang
 * @data 2021/5/23 15:23
 */
public class UserDaoImpl implements UserDao {


    @Override
    public List<Employee> getEmps() throws SQLException {

        List<Employee> emps = new ArrayList<>();

        Connection conn = DaoUtil.getConnection();

        //执行 sql 语句
        String sql = "select * from tbl_employee";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        while(result.next()){

            Integer id = result.getInt("id");
            String last_name = result.getString("last_name");
            String gender = result.getString("gender");
            String email = result.getString("email");

            Employee employee = new Employee(id, last_name, gender, email);

            emps.add(employee);
        }

        return emps;

    }

}
