package com.code.concurrency.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingDeque<String>();
		BlockingQueue<String> queue2 = new ArrayBlockingQueue(5);
	}
}
