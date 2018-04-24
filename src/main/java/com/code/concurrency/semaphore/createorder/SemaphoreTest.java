package com.code.concurrency.semaphore.createorder;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {

		final OrderService orderService = new OrderService();
		final Semaphore sem = new Semaphore(5);
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						sem.acquire();
						orderService.createOrder();
						sem.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}
}
