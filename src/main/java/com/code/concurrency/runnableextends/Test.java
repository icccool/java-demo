package com.code.concurrency.runnableextends;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Animal());
		exec.execute(new Horse());
		exec.shutdown();
	}
}
