package com.code.concurrency;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		Thread.interrupted();
		// TODO Auto-generated method stub
		return "result of TeakWhithResult " + id;
	}

}
