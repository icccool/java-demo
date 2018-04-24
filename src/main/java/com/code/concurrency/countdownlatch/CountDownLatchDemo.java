package com.code.concurrency.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 一个计划需要多个领导都签字后才能继续向下实施
 * @author W
 *
 */
class TaskPortion implements Runnable {

	private static int counter = 0;
	private final int id = counter++;
	private static Random rand = new Random(47);
	CountDownLatch latch = null;

	public TaskPortion(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doWork() throws InterruptedException {
		Thread.sleep(rand.nextInt(2000));
		System.out.println(this + "completed.");
	}

	public String toString() {
		return String.format("%1$-3d", id);
	}
}

class WaitingTask implements Runnable {
	private static int counter = 0;
	private final int id = counter++;

	private final CountDownLatch latch;

	public void run() {
		try {
			// 递减锁存器的计数，如果计数到达零，则释放所有等待的线程。   
			latch.await();
			System.out.println("latch barrier passed for " + this);
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
	}

	public WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}

	public String toString() {
		return String.format(" WaitingTask %1$-3d", id);
	}

}

public class CountDownLatchDemo {
	static final int SIZE = 100;

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(SIZE);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new WaitingTask(latch));
		}
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new TaskPortion(latch));
		}
		System.out.println("Launched all tasks.");
		exec.shutdown();
	}
}
