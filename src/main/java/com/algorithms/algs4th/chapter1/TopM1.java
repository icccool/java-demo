package com.algorithms.algs4th.chapter1;


public class TopM1 {

	private static int M = 3;

	public static void main(String[] args) {
		char[] arr = {'7', '5', '1', '2', '6', '8', '2', '5', '9', '0','9','3'};
		MaxPQ1<Character> pq = new MaxPQ1<Character>(M + 1);
		for (int i = 0; i < arr.length; i++) {
			pq.insert(arr[i]);
			if(pq.size() > M){
				pq.delMax();
			}
		}
		pq.print();
	}
}
