package com.xzp.ch1_2_3.ch1.aop;

import java.lang.annotation.*;

/**
 * 拦截规则的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}

