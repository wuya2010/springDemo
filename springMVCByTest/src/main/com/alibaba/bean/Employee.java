package main.com.alibaba.bean;

/**
 * @author kylinWang
 * @data 2021/5/23 15:18
 */
public class Employee {
    private Integer id;
    private String lastName;
    private String gender;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //样例类
    //带参构造器
    public Employee(Integer id, String lastNmae, String gender, String email){
        super();
        this.id = id;
        this.lastName = lastNmae;
        this.gender = gender;
        this.email = gender;
    }

    public Employee(){
        super();
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + "]";
    }
}
