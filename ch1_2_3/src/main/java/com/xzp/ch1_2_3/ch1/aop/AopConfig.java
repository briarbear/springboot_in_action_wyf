package com.xzp.ch1_2_3.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.xzp.ch1_2_3.ch1.aop")
@EnableAspectJAutoProxy //1
public class AopConfig {

}