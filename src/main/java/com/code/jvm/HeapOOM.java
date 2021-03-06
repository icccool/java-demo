package com.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx40m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\Java\dump
 * -XX:+HeapDumpOnOutOfMemoryError 参数输出dump文件 
 *
 * @Exception Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 堆内存异常
 * 
 * @author WANG
 */
public class HeapOOM {

	static class OOMObject {
		private int[] arr = new int[1024];
	}

	public static void main(String[] args) {
		List<OOMObject> ls = new ArrayList<OOMObject>();
		while (true) {
			ls.add(new OOMObject());
		}
	}
}
