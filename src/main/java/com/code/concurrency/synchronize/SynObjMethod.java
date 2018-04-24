package com.code.concurrency.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Java语法规定，任何线程执行同步方法(如上例testSyncMethod是同步方法)、同步代码块(如上例testSyncBlock方法中即是同步代码块)之前，必须先获取对应的监视器。
// 
//对于上例而言：
//testSyncBlock方法中同步代码块的监视器是this，即调用该方法的引用对象；
//testSyncMethod方法因为加了static关键字，故它的监视器不是this，而是该类本身。
// 
//所以最初的程序，因为没有使用同一个监视器，也就可以同时并发执行，两个线程各自输出0-99；
//而修改后的程序，因为都是用类的本身做为监视器，所以第一个线程可以对RunnableTest类进行锁定，而第二个线程要开始必须等第一个线程执行结束后才能执行。

class RunnableTest implements Runnable {

	private static volatile boolean flag = true;
	private Object obj = null;

	// ==================static synchronized  和  synchronized (RunnableTest.class) 都是同一个监视器RunnableTest.class, 这里会各自输出=================================

//	/**
//	 * 使用synchronized方法
//	 */
//	private static synchronized void testSyncMethod() { // 注意static
//		for (int i = 0; i < 100; i++) {
//			System.out.println("testSyncMethod:" + i);
//		}
//	}
//
//	/**
//	 * 使用synchronized代码块
//	 */
//	private void testSyncBlock() {
//		synchronized (RunnableTest.class) {
//			for (int i = 0; i < 100; i++) {
//				System.out.println("testSyncBlock:" + i);
//			}
//		}
//	}
	
	// ================== synchronized  和  synchronized (this) 监视器是各自对应的实例 , 这里会交叉输出=================================
//	/**
//	 * 使用synchronized方法
//	 */
//	private synchronized void testSyncMethod() { // 注意static
//		for (int i = 0; i < 100; i++) {
//			System.out.println("testSyncMethod:" + i + "xxxxxxx");
//		}
//	}
//
//	/**
//	 * 使用synchronized代码块
//	 */
//	private void testSyncBlock() {
//		synchronized (this) {
//			for (int i = 0; i < 100; i++) {
//				System.out.println("testSyncBlock:" + i + "-------");
//			}
//		}
//	}
	
	/**
	 * 使用synchronized方法
	 */
	private  void testSyncMethod() { // 注意static
		synchronized (obj) {
			for (int i = 0; i < 100; i++) {
				System.out.println("testSyncMethod:" + i + "xxxxxxx" + obj);
			}
		}
	}

	/**
	 * 使用synchronized代码块
	 */
	private void testSyncBlock() {
		synchronized (obj) {
			for (int i = 0; i < 100; i++) {
				System.out.println("testSyncBlock:" + i + "-------" + obj);
			}
		}
	}


	public void run() {
		// 每个线程执行不同的方法
		if (flag) {
			flag = false;
			testSyncMethod();
		} else {
			flag = true;
			testSyncBlock();
		}
	}
}

public class SynObjMethod {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.execute(new RunnableTest());
		exec.execute(new RunnableTest());
		exec.shutdown();
	}
}
