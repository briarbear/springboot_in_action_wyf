package com.xzp.ch1_2_3.ch3.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        DemoService demoService =  context.getBean(DemoService.class);

        demoService.outputResult();

        context.close();
    }

}
