package com.algorithms.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int i = binarySearch(a, 5);
		System.out.println(i);
	}

	public static int binarySearch(int[] arr, int a) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (hi + lo) / 2 ; // 注意
			if (arr[mid] == a) {
				return mid;
			} else if (arr[mid] > a) {
				// 左边查找
				hi = mid - 1;
			} else if (arr[mid] < a) {
				// 右边查找
				lo = mid + 1;
			}
		}
		return -1;
	}
}
