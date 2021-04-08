package com.linzlb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner 接口的 Component 会在所有 Spring Beans 都初始化之后，
 * SpringApplication.run() 之前执行，非常适合在应用程序启动之初进行一些数据初始化的工作。
 */
@Order(1)
@Component
public class OrderRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("The OrderRunner start to initialize ...");
    }
}
