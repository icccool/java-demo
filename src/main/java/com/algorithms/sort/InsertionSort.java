package com.algorithms.sort;

import com.algorithms.SortUtils;

/**
 *  时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 *  空间复杂度：O(1)
 *  稳定性：稳定
 *  内部排序(在排序过程中数据元素完全在内存)
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {5, 6, 3, 1, 8, 7, 2, 4};
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	//每一步选择一个对象, 插入到前面已经排序好的序列中
	public static void insertionSort2(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					SortUtils.exch(arr, j, j - 1);
				}
			}
		}
	}

	//每一步选择一个对象, 插入到前面已经排序好的序列中
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			// 选择一个未排序的key
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
