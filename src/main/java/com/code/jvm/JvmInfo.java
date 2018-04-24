package com.code.jvm;

public class JvmInfo {
	public static void main(String[] args) {

		System.out.println(System.getProperty("file.encoding"));

		long xmx = Runtime.getRuntime().maxMemory(); // 最大可用内存，对应-Xmx
		System.out.println("xmx = " + (xmx / 1024));
		long freeMemory = Runtime.getRuntime().freeMemory(); // 当前JVM空闲内存
		System.out.println("freeMemory = " + (freeMemory / 1024));
		long totalMemory = Runtime.getRuntime().totalMemory(); // 当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
		System.out.println("totalMemory = " + (totalMemory / 1024));
	}

}
