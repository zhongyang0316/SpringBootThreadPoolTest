package com.zy.threadpool.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolContextClosedHandler implements ApplicationListener<ContextClosedEvent> {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired(required = false)
	@Qualifier("batchThreadPoolTaskExecutor")
	private ThreadPoolTaskExecutor batchThreadPoolTaskExecutor;

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		if (this.batchThreadPoolTaskExecutor != null) {
			this.logger.info("ContextClosedEvent:{}", event);
			//在spring上下文环境注销之前手动对batchThreadPoolTaskExecutor关闭，保证优雅关闭过程中执行任务有运行环境
			this.batchThreadPoolTaskExecutor.shutdown();
		}
	}

}
