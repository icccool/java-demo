package com.algorithms.sort;

import com.algorithms.SortUtils;

// 分解操作 : 选择基准key key左边的都比key小, key右边的比key大
// 解决: 通过递归,对左边的 和 右边的进行排序
// 合并: 数组都是原址操作,不需要合并操作,数组已经有序了.

// 最好情况:N * logN
// 是否稳定:Not Stable
public class QuickSort {

	public static void main(String[] args) {
		int a[] = { 6, 1, 8, 2, 3, 9, 10 };
		SortUtils.print(a);
		qsort(a, 0, a.length - 1);
		SortUtils.print(a);
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
		int key = lo;
		int p = lo;
		for (int i = lo + 1; i <= hi; i++) {
			if (arr[i] < arr[key]) {
				swap(arr, ++p, i);
			}
		}
		swap(arr, key, p);
		return p;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
