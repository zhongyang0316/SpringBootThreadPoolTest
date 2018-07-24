package com.zy.threadpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.zy.threadpool.task.TestTask;

@SpringBootApplication(scanBasePackages = {"com.zy.threadpool"})
public class ThreadPoolApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ThreadPoolApplication.class, args);
		System.out.println(ctx.getId() + " started!");
		ThreadPoolTaskExecutor batchThreadPoolTaskExecutor = ctx.getBean(ThreadPoolTaskExecutor.class);
		batchThreadPoolTaskExecutor.execute(new TestTask());
		System.exit(0);
	}

}
