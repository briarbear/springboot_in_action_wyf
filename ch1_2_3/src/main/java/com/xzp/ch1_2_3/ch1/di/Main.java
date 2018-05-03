package com.xzp.ch1_2_3.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1使用AnnotationConfigApplicationContext作为Spring的容器，接受输入一个配置类作为参数
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class);

        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class); //2获得bean

        System.out.println(useFunctionService.SayHello("world"));

        context.close();
    }
}
