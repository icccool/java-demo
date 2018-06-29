package com.algorithms.sort;

/**
 *  <br>First, find the smallest item in the array and exchange it with the first entry (itself if the first entry is already the smallest)
 *  <br>Then, find the next smallest item and exchange it with the second entry.
 *  <br>Continue in this way until the entire array is sorted
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 8, 9, 5 };
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	// 从未排序的序列中, 选择一个最小的, 放入已经排序好的队列中
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
