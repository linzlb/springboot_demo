package com.linzlb.service.impl;

import com.linzlb.service.SendSMS;
import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/4/19 10:57
 * @Function:
 */
@Service
public class SendSMSImpl implements SendSMS{

    private Logger log=Logger.getLogger(SendSMSImpl.class);

    @Async("taskExecutor")
    @Override
    public void send() {
        log.info("--------send SMS -service start------------");
        try {
            Thread.sleep(3000); // 模拟耗时
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("--------send SMS service end------------");
    }
}
