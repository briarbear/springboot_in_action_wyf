package com.xzp.spring_boot_starter_hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-24-16:02
 */

@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    /**
     * 默认的msg是world 可以通过在application.properties中hello.msg= 来设置
     */
    private static final String MSG = "world";
    private String msg = MSG;

    public static String getMSG() {
        return MSG;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
