package com.code.concurrency.synchronize;

/**
 * synchronized 和 synchronized(this) 都是同一个监视器对象的实例
 * 
 * static synchronized 和 synchronized(Object.class) 都是同一个监视器Object.class
 * 
 * @author John
 *
 */
public class SynchronizedDemo {
	Object lock = new Object();

	// public void test1() {
	// int i = 5;
	// System.out.println("test1 持有 this锁... ");
	// while (i-- > 0) {
	// System.out.println(Thread.currentThread().getName() + " : " + i);
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException ie) {
	// }
	// }
	// }
	//
	// public void test2() {
	// int i = 5;
	// System.out.println("test2 持有 this锁... ");
	// while (i-- > 0) {
	// System.out.println(Thread.currentThread().getName() + " : " + i);
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException ie) {
	// }
	// }
	// }

	public void test1() {
		synchronized (lock) {
			int i = 5;
			System.out.println("test1 持有 this锁... ");
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	public void test2() {
		synchronized (lock) {
			int i = 5;
			System.out.println("test2 持有 this锁... ");
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	public static void main(String[] args) {
		final SynchronizedDemo demo = new SynchronizedDemo();
		for (int i = 0; i < 1; i++) {
			new Thread(new Runnable() {
				public void run() {
					demo.test1();
				}
			}, "Thread1 - test1").start();
		}

		for (int i = 0; i < 1; i++) {
			new Thread(new Runnable() {
				public void run() {
					demo.test2();
				}
			}, "Thread2 - test2").start();
		}

		// TestRunnable tr=new TestRunnable();
		// Thread test3=new Thread(tr);
		// test3.start();
	}

}