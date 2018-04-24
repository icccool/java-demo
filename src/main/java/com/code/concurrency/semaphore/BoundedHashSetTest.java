package com.code.concurrency.semaphore;

public class BoundedHashSetTest {
	public static void main(String[] args) {
		try {
			BoundedHashSet<String> set = new BoundedHashSet<String>(3);
			set.add("aa");
			set.add("bb");
			set.add("cc");
			set.add("cc");
			System.out.println(set.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
