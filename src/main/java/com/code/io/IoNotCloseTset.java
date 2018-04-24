package com.code.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoNotCloseTset {

	private static Charset charSet = Charset.forName("UTF-8");

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 1; i++) {
			exec.execute(new Runnable() {
				public void run() {
					try {
						FileChannel channel = new FileInputStream("E:\\DB\\死锁处理.txt").getChannel();
						ByteBuffer bf = ByteBuffer.allocate(1024);
						while (channel.read(bf) != -1) {
							bf.flip();
							System.out.println(charSet.decode(bf));
							bf.clear();
						}
						// channel.close(); //dose not close
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("-");
				}
			});
		}
		System.out.println("test has finished.");
	}

}
