package com.code.concurrency.test2;

public class MyThread2 implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "-->" + i);
		}
	}

}
