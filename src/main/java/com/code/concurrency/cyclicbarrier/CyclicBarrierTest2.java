package com.code.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * 点击5次获得一元
 * 
 * @author John
 *
 */
class Worker implements Runnable {

	CyclicBarrier barrier;

	public Worker(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		try {
			System.out.println("点一下");
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}

class Barrier {
	private static int amount = 0;
	ExecutorService executor = Executors.newCachedThreadPool();

	public Barrier(final int n) {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
			public void run() {
				System.out.println("已经赚了" + (++amount) + "元");
				if (amount * 5 >= n) {
					executor.shutdownNow();
				}
			}
		});

		for (int i = 0; i < 20; i++) {
			executor.execute(new Worker(cyclicBarrier));
		}
	}
}

public class CyclicBarrierTest2 {

	public static void main(String[] args) {
		new Barrier(5);
	}
}