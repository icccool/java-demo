package com.code.concurrency.consumerset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.code.random.GenerateCoupon;

public class ConsumerSet3 {

	public static ExecutorService exc = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {

		Set<String> set = GenerateCoupon.generate(4561, 10);
		List<String> list = new ArrayList<String>();
		list.addAll(set);
		
		int pageSize = 500;
		for (int i = 0; i * pageSize < list.size(); i ++) {
			int lo = pageSize * i;
			int hi = pageSize * (i + 1);
			System.out.println(lo +"--"+(hi > list.size() ? list.size() : hi));
			List subList = list.subList(lo, hi > list.size() ? list.size() : hi);
		}
		List<String> l1 = new ArrayList<String>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		l1.add("d");
		l1.add("e");
		List<String> l2 = l1.subList(0, 2);
		System.out.println(l2);
		List<String> l3 = l1.subList(2, 4);
		System.out.println(l3);
		List<String> l4 = l1.subList(4, 5);
		System.out.println(l4);
	}
}
