package com.algorithms.algs4th.chapter1;

public class MinPQTest {
	
	private static int M = 5;
	
	public static void main(String[] args) {
		Character[] c = { '3', '5', '6', '3', '2', '9' };
		MinPQ<Character> pq = new MinPQ<Character>(M);
		for (int i = 0; i < c.length; i++) {
			pq.insert(c[i]);
			if(pq.szie() > M) {
			}
		}
		pq.print();
	}
	
}
