package com.algorithms.sort;

//http://blog.csdn.net/morewindows/article/details/6668714

//先将整个待排元素序列分割成若干个子序列 (由相隔某个“增量”的元素组成的)
//分别进行直接插入排序
//然后依次缩减增量再进行排序
//整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序

//因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 9, 3, 5, 7, 6, 3, 7, 9, 5, 4 };
		shellSort2(arr,arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void shellSort(int a[],int n) {
		int i, j, gap;
		for (gap = n / 2; gap > 0; gap /= 2) {
			for (i = gap; i < n; i++) {
				for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
					swap(a, j, j + gap);
				}
			}
		}
	}
	
	public static void shellSort2(int a[],int n){
		// Sort a[] into increasing order.
		int h = 1;
		while (h < n / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < n; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= h && a[j] > a[j - h]; j -= h)
					swap(a, j, j - h);
			}
			h = h / 3;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
