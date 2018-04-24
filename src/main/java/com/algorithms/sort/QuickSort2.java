package com.algorithms.sort;

// introduction to algorithms 
//
public class QuickSort2 {
	// 分解操作 : 选择基准key key左边的都比key小, key右边的比key大
	// 解决: 通过递归,对左边的 和 右边的进行排序
	// 合并: 数组都是原址操作,不需要合并操作,数组已经有序了.
	public static void main(String[] args) {
		// int a2[] = { 6, 1, 8 };
		// int p = parition(a2, 0, a2.length);
		// for (int i = 0; i < a2.length; i++) {
		// System.out.println(a2[i]);
		// }
		int a[] = { 6, 1, 8, 2, 3, 9, 10 };
		qsort(a, 0, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void qsort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int p = parition(arr, lo, hi);
			qsort(arr, lo, p - 1);
			qsort(arr, p + 1, hi);
		}
	}

	// 选择一个key, 使key左边的都小于key, key右边的都大于key
	public static int parition(int[] arr, int lo, int hi) {
		int key = arr[lo];
		int p = lo;
		for (int i = lo + 1; i < hi; i++) {
			if (arr[i] < key) {
				swap(arr, ++p, i);
			}
		}
		swap(arr, lo, p);
		return p;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
