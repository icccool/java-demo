package com.code.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FutureTest {

	/** 信号量 */
	private Semaphore semaphore = new Semaphore(1); // 1

	/** 线程池 */
	private ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));

	/** Future */
	private Future<String> future;

	public void test() {

		future = pool.submit(new Callable<String>() {
			public String call() {
				String result = null;
				try {
					// 同步阻塞获取信号量
					semaphore.acquire();
					result = "ok";
				} catch (InterruptedException e) {
					result = "interrupted";
				}
				return result;
			}
		});

		String result = "timeout";
		try {
			// 等待3s
			result = future.get(3, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("超时异常");
		}

		// 删除线程池中任务
		boolean cancelResult = future.cancel(true);

		System.out.println("result is " + result);
		System.out.println("删除结果：" + cancelResult);
		System.out.println("当前active线程数：" + pool.getActiveCount());

	}

	public static void main(String[] args) {
		FutureTest o = new FutureTest();
		o.test();
	}

}