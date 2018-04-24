package com.code.concurrency.threadpoolexecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时、重复运行
 * @author WANG
 *
 */
public class ScheduledThreadPoolExecutorTest {
	public static void main(String[] args) {
		// 获得实例，并且设置它的容量为5个
		ScheduledThreadPoolExecutor sExecutor = new ScheduledThreadPoolExecutor(5);
		MyTask task = new MyTask();
		// 隔2秒后开始执行任务，并且在上一次任务开始后隔一秒再执行一次
		// sExecutor.scheduleWithFixedDelay(task, 2, 1, TimeUnit.SECONDS);
		// 隔6秒后执行一次，但只会执行一次
		ScheduledFuture<String> fts= sExecutor.schedule(task, 6, TimeUnit.SECONDS);
		try {
			String res  = fts.get();
			System.out.println(res + "执行完成!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 和Timer类似，也可以直接在任务的run()方法中调用调度方法停止 这个方法会平滑的关闭调度器，等待所有任务结束
		 */
		sExecutor.shutdown();
	}

	static class MyTask implements Callable<String> {
		public String call() throws Exception {
			System.out.println("当前执行的线程" + Thread.currentThread().getName());
			return Thread.currentThread().getName();
		}

	}
}
