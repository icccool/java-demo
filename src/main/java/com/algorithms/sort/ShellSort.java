package com.algorithms.sort;

//http://blog.csdn.net/morewindows/article/details/6668714

//先将整个待排元素序列分割成若干个子序列 (由相隔某个“增量”的元素组成的)
//分别进行直接插入排序
//然后依次缩减增量再进行排序
//整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序

//因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 49, 38, 65, 97, 26, 13, 27, 49, 55, 4 };
		shellSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void shellSort(int a[], int n) {
		int i, j, gap;
		for (gap = n / 2; gap > 0; gap /= 2) {
			for (i = gap; i < n; i++) {
				for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
					swap(a, j, j + gap);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
