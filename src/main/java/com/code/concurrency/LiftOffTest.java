package com.code.concurrency;

public class LiftOffTest {
	public static void main(String[] args) {
		// LiftOff lo = new LiftOff();
		// LiftOff lo2 = new LiftOff();
		// lo.run();
		// lo2.run();

//		Thread t = new Thread(new LiftOff());
//		t.start();
		
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff!");
	}

}
