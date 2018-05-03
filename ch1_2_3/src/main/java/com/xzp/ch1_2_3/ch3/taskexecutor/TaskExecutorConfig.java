package com.xzp.ch1_2_3.ch3.taskexecutor;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 配置类
 */
@Configuration
@ComponentScan("com.xzp.ch1_2_3.ch3.taskexecutor")
@EnableAsync //1 利用@EnableAsync注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer{//2 实现AsyncConfigurer接口

    @Override
    public Executor getAsyncExecutor() {//2 获得基于线程池的TaskExecutor
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}