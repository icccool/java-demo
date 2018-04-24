package com.code.concurrency.depayqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class DelayedTask implements Runnable, Delayed {

	private static int counter = 0;
	private final int id = counter++;
	private final long trigger;
	private final int delta;
	private static List<DelayedTask> sequence = new ArrayList<DelayedTask>();

	public DelayedTask(int delayInMillseconds) {
		delta = delayInMillseconds;
		this.trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
		sequence.add(this);
	}

	public int compareTo(Delayed o) {
		DelayedTask that = (DelayedTask) o;
		if (this.trigger > that.trigger) {
			return 1;
		} else if (this.trigger < that.trigger) {
			return -1;
		} else {
			return 0;
		}
	}

	public long getDelay(TimeUnit unit) {
		return unit.convert(this.trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	public void run() {
		System.out.print(this + " ");
	}

	public String summary() {
		return "(" + id + ":" + delta + ")";
	}

	@Override
	public String toString() {
		return String.format("[%1$-4d]", delta) + "Task " + id + ",";
	}

	public static class EndSentinel extends DelayedTask {
		ExecutorService exec = null;

		public EndSentinel(int delayInMillseconds, ExecutorService exec) {
			super(delayInMillseconds);
			this.exec = exec;
		}

		@Override
		public void run() {
			for (Iterator iterator = sequence.iterator(); iterator.hasNext();) {
				DelayedTask dt = (DelayedTask) iterator.next();
				System.out.println(dt.summary() + " ");
			}
			System.out.println();
			System.out.println(this + " Calling shutdown");
			exec.shutdownNow();
		}
	}

}

class DelayedTaskConsumer implements Runnable {

	private DelayQueue<DelayedTask> q;

	public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
		this.q = q;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				if (1 == q.size() - 1) {
					System.out.println("--");
				}
				DelayedTask task = q.take();
				if (task != null) {
					task.run();
				} else {
					System.out.println(" take ----");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finisher DelayTaskConsumer");
	}

}

public class DelayQueueDemo {
	public static void main(String[] args) {
		Random rand = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
		for (int i = 0; i < 20; i++) {
			queue.put(new DelayedTask(rand.nextInt(5000)));
		}
		// 具有最高延迟, 用来停止线程池
		queue.add(new DelayedTask.EndSentinel(5000, exec));
		// 执行DelayQueue
		exec.execute(new DelayedTaskConsumer(queue));
	}
}
