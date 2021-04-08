package com.linzlb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.Arrays;

@EnableScheduling
@SpringBootApplication
@EnableAsync
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(SpringbootDemoApplication.class, args);
		System.out.println("The service has started.");
	}


	//加上下面这段
	//可以看看springboot在启动的时候为我们注入了哪些bean
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("!!!!!!Let's inspect the beans provided by Spring Boot:!!!!!!");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
			System.out.println("OK..........................................................");
		};
	}

}
