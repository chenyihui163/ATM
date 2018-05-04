package com.atm.Async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.atm.Async")
@EnableAsync // 利用@EnableAsync注解开启异步任务支持
public class AsyncTaskConfig implements AsyncConfigurer{
	
	 @Override
	    public Executor getAsyncExecutor() { // 配置类实现AsyncConfigurer接口并重写 getAsyncExecutor 方法,并返回一个 ThreadPoolTaskExecutor,这样我们就获得了一个线程池 taskExecutor
	        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
	        taskExecutor.setCorePoolSize(5);//核心线程数
	        taskExecutor.setKeepAliveSeconds(200);//线程池维护线程所允许的空闲时间 
	        taskExecutor.setMaxPoolSize(20);//线程池维护线程的最大数量 
	        taskExecutor.setQueueCapacity(25);//线程池所使用的缓冲队列 
	        taskExecutor.initialize();
	        return taskExecutor;
	    }

	    @Override
	    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	        return null;
	    }
	
	
	
	
	

}
