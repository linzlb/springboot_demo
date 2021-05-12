package com.linzlb.controller;

import com.linzlb.dto.ResponseDto;
import com.linzlb.event.SendSmsEvent;
import com.linzlb.utils.ResponseResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: linzhengli
 * @Tel: 13570921913
 * @Date: 2021/5/12 11:42
 * @Function: 使用观察者模式异步调用service demo
 */
@Api(value="测试异步调用servie的Controller")
@RestController
public class AsyncCallServiceController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/asynCallService" , method= {RequestMethod.GET} )
    public ResponseDto asynCallService(){
        applicationEventPublisher.publishEvent(new SendSmsEvent("test controller asyn call smsService"));
        return ResponseResultUtil.generateSuccessResult(null);
    }
}
