package com.code.concurrency.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for (Future<String> fs : results) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}

	}
}

class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int i) {
		this.id = i;
	}

	public String call() throws Exception {
		Thread.currentThread().setName("[name = " + ((int) ((Math.random() + 1) * 10000)) + "]");
		int sleepTime = 0;
		if (id % 2 == 0) {
			TimeUnit.MILLISECONDS.sleep(5000);
			sleepTime = 5000;
			Thread.yield();
		}
		return Thread.currentThread().getName() + "result of TaskWithResult time = " + sleepTime + "(" + Thread.currentThread().getPriority() + ")";
	}
}
