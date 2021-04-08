package com.linzlb.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class AppCoreTask {

    @Scheduled(cron = "0 59 14 * * ? ")
    public void tesk() {
        System.out.print("开启定时任务" + new Date());
    }
}