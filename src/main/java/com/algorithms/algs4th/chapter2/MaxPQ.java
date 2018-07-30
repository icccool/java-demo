package com.algorithms.algs4th.chapter2;

import com.graphviz.GraphUtil;

/**
 * 基于堆实现的最大优先队列
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
		while (2 * k <= N) {
			// 左子节点
			int j = 2 * k;
			// 左子节点和右子几点对比
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
	}

	public E[] getData() {
		return arr;
	}

	// 返回最大值
	public E delMax() {
		//第一个最大元素
		E max = arr[1];
		//最大和最小交换后,置空删除
		exch(1, N--);
		arr[N + 1] = null;
		//重新调整下沉
		sink(1);
		return max;
	}

	public E get(int i) {
		return arr[i];
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (i > 1) {
				sb.append(" ");
			}
			sb.append("[" + arr[i] + "]");
		}
		System.out.println(sb);
	}

	public void graph() {
		StringBuilder sb = new StringBuilder();
		
		int j = 1;
		while (j <= N) {
			E p = arr[j];
			String lab_p = "  "+j + "[label=" + p  + ",shape=circle];\n";
			sb.append(lab_p);
			j++;
		}
		
		int i = 1;
		while (i <= N) {
			// 是否有左节点
			if (2 * i <= N) {
				sb.append("  "+i + "->" + (2 * i) + ";\n");
			}
			// 是否有右节点
			if (2 * i + 1 <= N) {
				sb.append("  "+i + "->" + (2 * i + 1) + ";\n");
			}
			i++;
		}
		GraphUtil.printDotGraph(sb.toString(), "MaxPQ");
	}

	private boolean less(int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
	}

	private void exch(int i, int j) {
		E tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
