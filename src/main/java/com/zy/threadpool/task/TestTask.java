package com.zy.threadpool.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTask implements Runnable{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void run() {
		this.logger.info("线程名:{} is testing,time:{}", Thread.currentThread().getName(), new Date());
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			this.logger.info("线程名:{} sleep error :{}", Thread.currentThread().getName(), e);
		}
		this.logger.info("线程名:{} sleep Finished", Thread.currentThread().getName());
	}

}
