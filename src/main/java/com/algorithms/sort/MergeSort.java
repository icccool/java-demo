package com.algorithms.sort;

import com.algorithms.SortUtils;

/***
 * A，B组各自再分成二组。依次类推，当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序，然后再合并相邻的二个小组就可以了,
 * 这样通过先递归的分解数列，再合并数列就完成了归并排序。
 * @author wang
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
		int[] arr = { 6, 5, 3, 1, 8, 7, 2, 4 };
		SortUtils.print(arr);
		mergeSort(arr, arr.length);
		SortUtils.print(arr);
	}
	
	//将以m分割的两个序列,按照顺序放入tmp数组中,然后还原到原始数组a
	public static void mergeArray(int a[], int lo, int mid, int hi, int tmp[]) {
		int i = lo, j = mid + 1;
		int k = 0;

		while (i <= mid && j <= hi) {
			if (a[i] <= a[j])
				tmp[k++] = a[i++];
			else
				tmp[k++] = a[j++];
		}

		while (i <= mid)
			tmp[k++] = a[i++];

		while (j <= hi)
			tmp[k++] = a[j++];

		for (i = 0; i < k; i++)
			a[lo + i] = tmp[i];
	}

	public static void mergeSort(int a[], int lo, int hi, int tmp[]) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			mergeSort(a, lo, mid, tmp); 
			mergeSort(a, mid + 1, hi, tmp); 
			mergeArray(a, lo, mid, hi, tmp); // 再将二个有序数列合并
		}
	}

	public static void mergeSort(int a[], int n) {
		int[] tmp = new int[a.length];
		mergeSort(a, 0, n - 1, tmp);
	}
  
}