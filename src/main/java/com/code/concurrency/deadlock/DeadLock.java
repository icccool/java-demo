package com.code.concurrency.deadlock;


/**
 * 一个简单的死锁类
 * 
* 当类的对象flag=1时（T1），先锁定O1,睡眠500毫秒，然后锁定O2；>?<br>
* 而T1在睡眠的时候另一个flag=0的对象（T2）线程启动，先锁定O2,睡眠500毫秒，等待T1释放O1；<br>
* T1睡眠结束后需要锁定O2才能继续执行，而此时O2已被T2锁定；<br>
* T2睡眠结束后需要锁定O1才能继续执行，而此时O1已被T1锁定；<br>
* T1、T2相互等待，都需要对方锁定的资源才能继续执行，从而死锁。<br>
* 
*/
class DeadLock implements Runnable {
	
	public int flag = 1;
	static Object o1 = new Object(),o2 = new Object();
	
	public void run() {
		System.out.println("flag=" + flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");
				}
			}
		}
		if (flag == 0) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}

	public static void main(String[] args) {
		DeadLock td1 = new DeadLock();
		DeadLock td2 = new DeadLock();
		td1.flag = 1;
		td2.flag = 0;
		Thread t1 = new Thread(td1);
		t1.setName("线程1");
		t1.start();
		Thread t2 = new Thread(td2);
		t2.setName("线程2");
		t2.start();

	}
}