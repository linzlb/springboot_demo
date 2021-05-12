package com.linzlb.service.listener;

import com.linzlb.event.SendSmsEvent;
import com.linzlb.service.SendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/5/12 13:46
 * @Function: 观察者模式
 */
@Component
public class AsyncCallServiceListener {

    @Autowired
    private SendSMS sendSMS;

    @RequestMapping(value = "/asynCallService" , method= {RequestMethod.GET} )
    @Async("taskExecutor")
    @EventListener
    public void send(SendSmsEvent event){
        String msg = (String)event.getSource();
        sendSMS.synSend(msg);
    }
}
