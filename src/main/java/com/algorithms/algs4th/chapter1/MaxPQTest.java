package com.algorithms.algs4th.chapter1;

/**
 * 最大优先队列测试
 * <br>模拟P203 图2.4.6
 * @author wang
 */
public class MaxPQTest {

	public static void main(String[] args) {
		MaxPQ<Character> pq = new MaxPQ<Character>(8);
		pq.insert('P');
		pq.insert('Q');
		pq.insert('E');
		pq.delMax();
		pq.insert('X');
		pq.insert('A');
		pq.insert('M');
		pq.delMax();
		pq.insert('P');
		pq.insert('L');
		pq.insert('E');
		pq.delMax();
		pq.print();
		pq.graph();
	}

}
