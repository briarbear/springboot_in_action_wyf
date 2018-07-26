package com.xzp.spring_boot_starter_hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-24-16:05
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)  // 1. 开启属性注入 该注解给出了该配置类所需要的配置信息类，这样spring容器会去读取配置信息到该类对象中
@ConditionalOnClass(HelloService.class)   // 2. 当HelloService在类路径下,才会去解析对应的配置文件
@ConditionalOnProperty(prefix = "hello",value = "enabled",matchIfMissing = true)  //3. 配置的前缀: hello 当设置hello=enabled的情况下，如果没有设置，则默认true，即条件符合
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean  // 4. 使用Java config配置
    @ConditionalOnMissingBean(HelloService.class)   //判断HelloService这个类在类路径中是否存在，且当容器中没有这个Bean的情况下自动配置这个Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        helloService.setMsg(helloServiceProperties.getMsg());
        return helloService;
    }
}
