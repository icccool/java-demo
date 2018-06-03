package com.code.concurrency.reentrantlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread implements Runnable {

	Lock lock = new ReentrantLock();

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " --> lock前 ..");
		try {
			lock.lock();
			for (int i = 0; i < 100000000; i++) {}
			System.out.println(Thread.currentThread().getName() + " --> lock后 ..");	
		} finally { 
			lock.unlock();
			
		}

	}

	public static void main(String[] args) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();  
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		  
		}  
		
		ReentrantLockThread reentrantLockThread = new ReentrantLockThread();
		Thread[] threads = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(reentrantLockThread);
			threads[i].start();
		}

	}

}
