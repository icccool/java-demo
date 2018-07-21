package com.algorithms.algs4th.chapter1;

import com.graphviz.GraphUtil;

public class MinPQ<E extends Comparable<E>> {
	
	//0位置未使用
	private E[] arr;
	private int N = 0;

	public MinPQ() {
	}

	public MinPQ(int size) {
		//[Ljava.lang.Object; cannot be cast to [Ljava.lang.Comparable;
		//E的上限是Comparable,所以这里不能用Object
		//arr = (E[]) new Object[size + 1];
		arr = (E[]) new Comparable[size + 1];
	}
	
	public boolean isEmpty() {
		return N < 1;
	}
	
	//小的往上浮
	private void swim(int k) {
		while (k / 2 >= 1) {
			if (less(k, k / 2)) {
				exch(k, k/2);
			}
			k /= 2;
		}
	}
	
	//大的往下沉
	private void sink(int k) {
		while (k * 2 < N) {
			//左节点
			int j = k * 2;
			//和右节点对比
			if (less(j + 1, j)) {
				j++;
			}
			//如果k小于j,停止下沉
			if (less(k,j)) {
				break;
			}
			exch(k, j);
			k *= 2;
		}
	}
	
	//删除最小的,剩下大的
	public E delMin() {
		E min = arr[1];
		arr[1] = arr[N];
		arr[N] = null;
		N--;
		sink(1);
		return min;
	}
	
	public int szie() {
		return N;
	}
	
	public void insert(E e) {
		arr[++N] = e;
		swim(N);
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
		//生成label
		int j = 1;
		while (j <= N) {
			E p = arr[j];
			String lab_p = j + "[label=" + p + "" + (int) ((char) p) + ",shape=circle];\n";
			sb.append(lab_p);
			j++;
		}
		//生成关系图
		int i = 1;
		while (i <= N) {
			// 是否有左节点
			if (2 * i <= N) {
				sb.append(i + "->" + (2 * i) + ";\n");
			}
			// 是否有右节点
			if (2 * i + 1 <= N) {
				sb.append(i + "->" + (2 * i + 1) + ";\n");
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
