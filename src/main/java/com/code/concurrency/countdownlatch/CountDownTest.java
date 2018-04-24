package com.code.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

//public void await() throws InterruptedException { };   //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
//public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
//public void countDown() { };  //将count值减1

public class CountDownTest {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);
		//Thread 1
		new Thread() {
			public void run() {
				try {
					System.out.println("[子]线程" + Thread.currentThread().getName() + "正在执行");
					Thread.sleep(3000);
					System.out.println("[子]线程" + Thread.currentThread().getName() + "执行完毕");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		//Thread 2
		new Thread() {
			public void run() {
				try {
					System.out.println("[子]线程" + Thread.currentThread().getName() + "正在执行");
					Thread.sleep(3000);
					System.out.println("[子]线程" + Thread.currentThread().getName() + "执行完毕");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		try {
			System.out.println("[主]等待2个子线程执行完毕>>>>>>>>>>>>>>>>>>>>>>>");
			latch.await(); //调用await()方法的线程会被挂起，去执行子线程 , 它会等待直到count值为0才继续执行
			System.out.println("[主]2个子线程已经执行完毕>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("[主]继续执行主线程");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}