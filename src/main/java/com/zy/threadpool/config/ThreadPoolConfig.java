package com.zy.threadpool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {
	
	@Bean(name = "batchThreadPoolTaskExecutor")
	public ThreadPoolTaskExecutor batchThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(2); //线程池大小
		taskExecutor.setThreadNamePrefix("octopus-batch-task-"); //执行线程前缀
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		taskExecutor.setAwaitTerminationSeconds(30);
		return taskExecutor;
	}

}
