package com.xzp.ch1_2_3.ch2.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xzp.ch1_2_3.ch2.prepost")
public class PrePostConfig {

    @Bean(initMethod="init",destroyMethod="destroy") //1 initMethod destroyMethod 分别制定该类的init方法，destroy方法在构造方法前执行，Bean销毁后执行
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }

}