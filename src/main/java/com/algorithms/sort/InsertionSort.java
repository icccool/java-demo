package com.algorithms.sort;

//时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
//空间复杂度：O(1)
//稳定性：稳定
//每一步选择一个对象, 插入到前面已经排序好的序列中
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

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
