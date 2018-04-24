package com.code.concurrency.onevalcache;


public class Test {
	private volatile OneValueCache cache = new OneValueCache(null);

	public static void main(String[] args) {
		Test t = new Test();
		t.cache = new OneValueCache(1);
	}
}
