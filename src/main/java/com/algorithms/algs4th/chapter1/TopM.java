package com.algorithms.algs4th.chapter1;


public class TopM {
	
    public static void main(String[] args) {
        char[] arr = {15, 6, 4, 21};
		MaxPQ<Character> pq = new MaxPQ<Character>(arr.length);
		pq.insert('P');
		pq.insert('Q');
		pq.insert('E');
    }
}
