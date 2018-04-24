package com.algorithms.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 4, 6, 1, 3 };
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	//每一步选择一个对象, 插入到前面已经排序好的序列中
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];
			// 如果大于key就往后移
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			// 插入key到正确的位置
			arr[j + 1] = key;
		}
	}
}
