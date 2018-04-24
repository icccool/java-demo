package com.code.concurrency.threadsleep;

public class ThreadSleep implements Runnable {
	/*
	 * 让线程睡眠的理由很多，比如(1)认为该线程运行得太快，需要减缓一下，以便和其他线程协调；(2)查询当时的股票价格，每睡5分钟查询一次，可以节省带宽，
	 * 而且即时性要求也不那么高。
	 * 注意：时间的精确性。线程醒来之后不会马上运行，而要等待cpu给其分配时间片。因此sleep()中指定的时间并不是线程不运行的精确时间
	 * ！所以不能依赖sleep()方法提供十分精确的定时。 我们可以看到很多应用程序用sleep()作为定时器，实际是不精确的。
	 * 
	 * 
	 * Thread.sleep(5 * 1000)和Thread.currentThread().sleep(5 *
	 * 1000)没区别：都表示让当前线程sleep 5秒. 一个是通过类获取静态方法,一个是通过实例对象获得静态方法(sleep()为静态方法).
	 * 
	 * 注意：sleep并不是Thread的一个STATE
	 */
	public void execute() {
		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName() + ", sleep()前");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + ", sleep()后");
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + ", 谁把我吵醒了.....");
			}
			// 此处如果使用System.err, 会有很意外的结果。System.out和System.err的区别请见blog
			System.out.println(Thread.currentThread().getName() + ", run()结束..进入TERMINATED状态");
		}
	}

	public void run() {
		execute();
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadSleep threadSleep = new ThreadSleep();
		Thread[] threads = new Thread[5];

		System.out.println(Thread.currentThread().getName() + "线程的状态为：" + Thread.currentThread().getState());

		for (Thread thread : threads) {
			thread = new Thread(threadSleep);
			thread.start();
			if ("Thread-1".equals(thread.getName()) || "Thread-3".equals(thread.getName()))
				thread.interrupt();
		}
	}
}