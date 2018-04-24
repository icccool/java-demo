package com.code.concurrency.test2;

public class ThreadTest2 {
	public static void main(String[] args) {
		System.out.println("开始----------");
		//用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。
		Thread t = new Thread(new MyThread2());
		t.start();
		
		//run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行
		//new MyThread2().run();
		System.out.println("结束----------");
	}
}
