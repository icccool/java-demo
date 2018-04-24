package com.code.concurrency.scheduledthreadpoolexcutor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExcutorTest {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor sc = new ScheduledThreadPoolExecutor(2);
		sc.schedule(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("2秒执行一次 ...");
			}
		}, 2, TimeUnit.SECONDS);
		
		sc.schedule(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("5秒执行一次 ...");
			}
		}, 5, TimeUnit.SECONDS);

	}

}
