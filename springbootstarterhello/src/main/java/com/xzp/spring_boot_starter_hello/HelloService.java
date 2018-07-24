package com.xzp.spring_boot_starter_hello;

/**
 * 判断依据类
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-24-16:04
 */
public class HelloService {
    private String msg;

    public String sayHello(){
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
