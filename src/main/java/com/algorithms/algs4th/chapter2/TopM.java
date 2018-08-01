package com.algorithms.algs4th.chapter2;

/**
 * TopM 算法
 * 从数组中找出最大的M个数 
 * <br>P196
 * 
 * @author wang 2018-07-21 10:31:04
 *
 */
public class TopM {

	private static int M = 3;

	public static void main(String[] args) {
		Character[] c = { '0', '5', '6', '5', '2', '9', '1' };
		MinPQ<Character> pq = new MinPQ<Character>(M + 1);
		for (int i = 0; i < c.length; i++) {
			pq.insert(c[i]);
			// 超出M个 删除最小的
			if (pq.szie() > M) {
				pq.delMin();
			}
		}
		while (!pq.isEmpty()) {
			System.out.println(pq.delMin());
		}
	}

}
