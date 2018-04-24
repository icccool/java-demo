package com.code.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;

public class Test {
	// 按字节读
	static void test1() {
		try {
			long begin = System.currentTimeMillis();
			InputStream in = new FileInputStream(new File("E:\\DB\\xzblob.dmp"));
			int b = 0;
			while ((b = in.read()) != -1) {
				// System.out.print((char)b);
			}
			long duration = System.currentTimeMillis() - begin;
			System.out.println("test1 = " + duration); // >> 10000
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 使用缓存数组
	static void test2() {
		try {
			long begin = System.currentTimeMillis();
			InputStream in = new FileInputStream(new File("G:\\Downloads\\EBOD-475.HD\\EBOD-475.HD.mp4"));
			byte[] buf = new byte[1024 * 4];
			int len = -1;
			while ((len = in.read(buf)) != -1) {
				// System.out.println(new String(buf, 0, len));
			}
			long duration = System.currentTimeMillis() - begin;
			System.out.println("test2 = " + duration); // 16
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 使用buffered
	static void test3() {
		try {
			long begin = System.currentTimeMillis();
			BufferedInputStream input = new BufferedInputStream(new FileInputStream("G:\\Downloads\\EBOD-475.HD\\EBOD-475.HD.mp4"));
			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = input.read(buf)) != -1) {
				// System.out.println(new String(buf, 0, len));
			}
			long duration = System.currentTimeMillis() - begin;
			System.out.println("test3 = " + duration); //
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Executors.newCachedThreadPool();
		test3();
		test2();
	}
}
