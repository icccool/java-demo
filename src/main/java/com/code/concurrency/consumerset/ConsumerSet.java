package com.code.concurrency.consumerset;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 分组处理列表数据
 * 
 * @author WANG
 *
 */
public class ConsumerSet {

	public static int nThreads = 10;
	public static ExecutorService exc = Executors.newFixedThreadPool(nThreads);

	public static void main(String[] args) {

		// Set<String> set = GenerateCoupon.generate(1000, 10);
		//
		int headNum = 1;
		int total = 31;
		for (int i = 0; i < nThreads; i++) {
			final int lo = total / nThreads * i;
			final int hi = total / nThreads * (i + 1);
			System.out.println( (lo) + " - " + (hi));
		}
		
		// List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		// for (int i = 0; i < 3; i++) {
		// final int j = i + 1 ;
		// Future<Integer> f = exc.submit(new Callable<Integer>() {
		// @Override
		// public Integer call() throws Exception {
		// // TODO Auto-generated method stub
		// for (int k = 0; k < j; k++) {
		// System.out.println( Thread.currentThread().getName() + " -> " + k);
		// }
		// return null;
		// }
		// });
		// list.add(f);
		// }
	}
}
