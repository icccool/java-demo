package com.algorithms.algs4th.chapter1;

public class MinPQTest {

	private static int M = 3;

	public static void main(String[] args) {
		Character[] c = { '0', '5', '6', '5', '2', '9','1' };
		MinPQ<Character> pq = new MinPQ<Character>(M + 1);
		for (int i = 0; i < c.length; i++) {
			pq.insert(c[i]);
			if (pq.szie() > M) {
				pq.delMin();
			}
		}
		pq.print();
	}

}
