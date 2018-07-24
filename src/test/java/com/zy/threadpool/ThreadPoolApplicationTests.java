package com.zy.threadpool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import com.zy.threadpool.task.TestTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadPoolApplicationTests {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	@Qualifier("batchThreadPoolTaskExecutor")
	private ThreadPoolTaskExecutor batchThreadPoolTaskExecutor;
	
	@Test
	public void contextLoads() {
		this.logger.info("只是测试。。。。");
		this.batchThreadPoolTaskExecutor.execute(new TestTask());
		this.logger.info("测试完毕。。。。");
	}

}
