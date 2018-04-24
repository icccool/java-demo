package com.code.concurrency.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

/**
 * @author windows 安全锁例子
 */
public class DeadLock2 {
	/**
	 * @author windows 朋友实体类
	 */
	static class Friend {
		// 朋友类，锁（重入锁）
		private final String name;
		private final Lock lock = new ReentrantLock();

		// 朋友构造方法
		public Friend(String name) {
			this.name = name;
		}

		// 获取名字
		public String getName() {
			return this.name;
		}

		// 在鞠躬前的判断
		public boolean impendingBow(Friend bower) {
			// 当前我的状态锁，与朋友的状态锁
			Boolean myLock = false;
			Boolean yourLock = false;
			try {
				// 记录当前类的锁，和鞠躬的朋友的锁的状态
				myLock = lock.tryLock();
				yourLock = bower.lock.tryLock();
			} finally {
				// 如果当前类的锁，与鞠躬朋友的类的状态，其中有一个为false时
				if (!(myLock && yourLock)) {
					// 判断是那个状态为true的，对这个锁进行解锁。
					if (myLock) {
						lock.unlock();
					}
					if (yourLock) {
						bower.lock.unlock();
					}
				}
			}
			// 返回结果
			return myLock && yourLock;
		}

		/**
		 * @param bower
		 *            向朋友鞠躬的方法
		 */
		public void bow(Friend bower) {
			// 判断是否有锁
			if (impendingBow(bower)) {
				// 朋友鞠躬时，我没有鞠躬。打印出信息，并回敬。
				try {
					System.out.format("%s: %s has" + " bowed to me!%n", this.name, bower.getName());
					bower.bowBack(this);
				} finally {
					lock.unlock();
					bower.lock.unlock();
				}
			} else {
				// 朋友鞠躬的同时我也鞠躬。打印出信息。
				System.out.format("%s: %s started" + " to bow to me, but saw that" + " I was already bowing to" + " him.%n", this.name, bower.getName());
			}
		}

		/**
		 * @param bower
		 *            回敬鞠躬的方法。
		 */
		public void bowBack(Friend bower) {
			System.out.format("%s: %s has" + " bowed back to me!%n", this.name, bower.getName());
		}
	}

	/**
	 * @author windows 循环鞠躬的线程
	 */
	static class BowLoop implements Runnable {
		// 相互鞠躬的两个人
		private Friend bower;
		private Friend bowee;

		// 构造方法
		public BowLoop(Friend bower, Friend bowee) {
			this.bower = bower;
			this.bowee = bowee;
		}

		// 线程的执行方法
		public void run() {
			Random random = new Random();
			for (;;) {// 无限循环。
				try {
					// 进程中断
					Thread.sleep(random.nextInt(5));
				} catch (InterruptedException e) {
				}
				// bowee向bower鞠躬
				bowee.bow(bower);
			}
		}
	}

	// 测试
	public static void main(String[] args) {
		final Friend alphonse = new Friend("Alphonse");
		final Friend gaston = new Friend("Gaston");
		new Thread(new BowLoop(alphonse, gaston)).start();
		new Thread(new BowLoop(gaston, alphonse)).start();
	}
}
