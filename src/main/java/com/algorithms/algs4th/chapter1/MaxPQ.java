package com.algorithms.algs4th.chapter1;

import com.algorithms.SortUtils;

/**
 * 基于堆实现的优先队列
 */
public class MaxPQ<E extends Comparable<E>> {
	// [0]未使用
	private E arr[];
	private int N = 0;

	public MaxPQ() {
	}

	public MaxPQ(int maxN) {
		this.arr = (E[]) new Comparable[maxN + 1];
	}

	public int size() {
		return N;
	}

	// 大的节点上浮
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k /= 2;
		}
	}

	// 小的节点下沉
	private void sink(int k) {
		//TODO
		while (2 * k < N) {
			// 左子节点
			int j = 2 * k;
			// 左子节点和右子节点对比
			if (j < N && less(j, j + 1)) {
				j++;
			}
			// 当前节点大于子节点跳出循环
			if (!less(k, j)) {
				break;
			}
			exch(j, k);
			k = j;
		}
	}

	public void insert(E key) {
		arr[++N] = key;
		swim(N);
		SortUtils.print(arr);
	}

	// 返回最大值
	public E delMax() {
		E max = arr[N];
		exch(1, N--);
		arr[N + 1] = null;
		sink(1);
		return max;
	}

	private boolean less(int i, int j) {
		return arr[i].compareTo(arr[j]) == -1;
	}

	private void exch(int i, int j) {
		E tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
