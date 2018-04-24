package com.code.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newFixedThreadPool(6);
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		
		//newFixedThreadPool //限制线程的数量,避免资源浪费
		ExecutorService exec1 = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			exec1.execute(new LiftOff());
		}
		exec.shutdown();
		
		//如果提交多个任务, 这些任务排队执行
		ExecutorService exec2 = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec2.execute(new LiftOff());
		}
		exec.shutdown();
	}
	
	
}
