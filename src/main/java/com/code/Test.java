package com.code;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class Test<A, V> {
	private static int counter = 0;
	private final int id = counter++;
	private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

	@Override
	public String toString() {
		
		return id + "-->";
	}

	public V ccompute(final A arg) {
		return null;
	}

	public static void main(String[] args) {
		int count = Runtime.getRuntime().availableProcessors();
		System.out.println(Thread.currentThread().getName());
		System.out.println(count);
		System.out.println((int)(1/2));
	}
}
