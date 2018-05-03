package com.xzp.ch1_2_3.ch3.taskscheduler;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@ComponentScan("com.xzp.ch1_2_3.ch3.taskscheduler")
@EnableScheduling //1 开启对计划任务的支持
public class TaskSchedulerConfig {

  @Bean
  public TaskScheduler scheduledExecutorService() {
      ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
      scheduler.setPoolSize(8);
      scheduler.setThreadNamePrefix("scheduled-thread-");
      return scheduler;
  }
}
