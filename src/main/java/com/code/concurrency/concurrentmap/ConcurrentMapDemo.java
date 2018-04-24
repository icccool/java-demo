package com.code.concurrency.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapDemo {
	public static void main(String[] args) {
		ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();
		map.putIfAbsent("", "");
	}
}
