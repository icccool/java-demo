package com.code.interview.concurrency;

//1)现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
class ThreadTest extends Thread {

	private Thread th;

	public ThreadTest(Thread th) {
		this.th = th;
	}

	public void run() {
		try {
			synchronized (this) {
				if (th != null) {
					th.join();
				}
			}
			System.out.println(Thread.currentThread().getName() + " has been executed.");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class JoinTest {
	public static void main(String[] args) {
		try {
			
			ThreadTest t1 = new ThreadTest(null);
			ThreadTest t2 = new ThreadTest(t1);
			ThreadTest t3 = new ThreadTest(t2);
			
			t1.start();
			t2.start();
			t3.start();
			t3.join();
			System.out.println("main has been executed.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
