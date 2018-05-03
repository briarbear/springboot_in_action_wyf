package com.xzp.ch1_2_3.ch2.profile;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * 使用不同的profile的方式有3中
     * 1. 通过设定Environment的ActiveProfile的方式
     * 2. 设定jvm的spring.profiles.active
     * 3. Web项目中设置在Servlet的context parameter
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev"); //1
        context.register(ProfileConfig.class);//2
        context.refresh(); //3

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println(demoBean.getContent());

        context.close();
    }
}

