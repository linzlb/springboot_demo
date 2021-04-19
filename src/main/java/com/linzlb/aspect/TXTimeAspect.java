package com.linzlb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.jboss.logging.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Order(1)
@Aspect
@Component
public class TXTimeAspect {
  
    private Logger logger=Logger.getLogger(TXTimeAspect.class);

    //统计请求的处理时间
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.linzlb.controller.*.*(..))") //对 com.linzlb.controller包下的任意类，任意方法，任意参数，任意返回值的方法都进行切入
    public void log(){
    }
     
    @Before("log()")
    public void deoBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning="result",pointcut="log()")
    public void doAfterReturning(Object result){
        logger.info("方法执行时间:"+ (System.currentTimeMillis() - startTime.get())+"ms");
    }

}
