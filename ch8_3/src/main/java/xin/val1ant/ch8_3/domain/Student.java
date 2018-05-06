package xin.val1ant.ch8_3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 学生类
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-06-18:08
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    private String address;



    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}