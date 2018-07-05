package com.algorithms;

/***
 *
 * @author wang
 *
 */
public class SortUtils {

	public static void exch(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void print(int[] arr){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(" ");
			}
			sb.append("[" + arr[i] + "]");
		}
		System.out.println(sb);
	}
}
