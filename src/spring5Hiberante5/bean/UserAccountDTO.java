package spring5Hiberante5.bean;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserAccountDTO {

    @NotEmpty
    @Size(min=10, max=30)
    private String userName;

    @NotEmpty
    @Size(min=8, max=30)
    private String password;

    @NotEmpty
    @Email(message="Email format is not correct.")
    private String email;

    @NotNull
    @Min(18) @Max(100)
    private Integer age;

    @NotNull
    @Past()
    private Date birthday;

    @NotNull
    @Min(1000) @Max(10000)
    private Float salary;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}