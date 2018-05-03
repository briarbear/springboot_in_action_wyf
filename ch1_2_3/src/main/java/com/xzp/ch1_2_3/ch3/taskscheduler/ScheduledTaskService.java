package com.xzp.ch1_2_3.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计划任务执行类
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) //1 每隔固定时间执行
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 11 21 ? * *"  ) //2 按照固定时间执行，每天11:28执行
    public void fixTimeExecution(){
        System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
    }

}
