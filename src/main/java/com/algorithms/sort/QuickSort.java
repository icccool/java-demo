package com.algorithms.sort;

// the c programming language 
public class QuickSort {

	public static void main(String[] args) {
		int a[] = { 6, 1, 8, 2, 3, 9, 10 };
		qsort(a, 0, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void qsort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int last = lo;
		for (int i = lo + 1; i < hi; i++) {
			if (arr[i] < arr[lo]) {
				exch(arr, ++last, i);
			}
		}
		exch(arr, lo, last);
		qsort(arr, lo, last - 1);
		qsort(arr, last + 1, hi);
	}

	public static void exch(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
