package com.code.concurrency.consumerset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.code.random.GenerateCoupon;

public class ConsumerSet2 {

	public static ExecutorService exc = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {

		Set<String> set = GenerateCoupon.generate(100, 10);
		
		int count = set.size();
		int loopsize = set.size();
		if (loopsize > 100000) {
			loopsize = loopsize / 100;
		} else if (loopsize >= 100) {
			loopsize = loopsize / 10;
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter("C:\\Users\\John\\Desktop\\codes.txt");
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-----------");
	}
}
