package com.xzp.ch1_2_3.ch3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
        //创建bean的时候，计划任务就会执行

    }

}
