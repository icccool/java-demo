package com.code.concurrency;

public class ThreadTest {
	private static volatile int count = 0;
	private static Object obj = new Object();

	public static void main(String[] args) {
		// 最多2078个线程
		for (int i = 0; true; i++) {
			new Thread(new Runnable() {
				public void run() {
					synchronized (obj) {
						count += 1;
						System.err.println("New thread #" + count);
					}
					for (;;) {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							System.err.println(e);
						}
					}
				}
			}).start();
		}
	}

}
