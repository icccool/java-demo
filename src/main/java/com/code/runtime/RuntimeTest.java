package com.code.runtime;

public class RuntimeTest {
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);
	}
}
