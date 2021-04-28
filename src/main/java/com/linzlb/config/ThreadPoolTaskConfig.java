package com.linzlb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/*我们在使用多线程的时候，往往需要创建Thread类，或者实现Runnable接口，
如果要使用到线程池，我们还需要来创建Executors，在使用spring中，已经给我们做了很好的支持。
只要要@EnableAsync就可以使用多线程。使用@Async就可以定义一个线程任务。
通过spring给我们提供的ThreadPoolTaskExecutor就可以使用线程池。
默认情况下，Spring将搜索相关的线程池定义：
		要么在上下文中搜索唯一的TaskExecutor bean，要么搜索名为“taskExecutor”的Executor bean。
		如果两者都无法解析，则将使用SimpleAsyncTaskExecutor来处理异步方法调用。
		*/
@Configuration
@EnableAsync
public class ThreadPoolTaskConfig {

    private static final int COREPOOLSIZE = 10;       		// 核心线程数（默认线程数）
	private static final int MAXPOOLSIZE = 100;			    // 最大线程数
	private static final int KEEPALIVETIME = 10;			// 允许线程空闲时间（单位：默认为秒）
	private static final int QUEUECAPACITY = 200;			// 缓冲队列数
	private static final String THREADNAMEPREFIX = "Async-Service-"; // 线程池名前缀
	
	@Bean("taskExecutor") // bean的名称，默认为首字母小写的方法名
	public ThreadPoolTaskExecutor getAsyncExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(COREPOOLSIZE);
		executor.setMaxPoolSize(MAXPOOLSIZE);
		executor.setQueueCapacity(QUEUECAPACITY);
		executor.setKeepAliveSeconds(KEEPALIVETIME);
		executor.setThreadNamePrefix(THREADNAMEPREFIX);
		
		// 线程池对拒绝任务的处理策略
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		// 初始化
		executor.initialize();
		return executor;
	}
}