package com.code.random;

import java.util.Arrays;
import java.util.Random;

/**
 * 洗牌算法
 * 
 * @author John
 *
 */
public class ShullfeCards {
	public static void main(String[] args) {
		int[] arr = shullfe(new int[] { 2, 1, 3 });
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		System.out.println(Arrays.toString(array));
	}

	private static int[] shullfe(int[] arrary) {
		Random rand = new Random();
		for (int i = arrary.length; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = arrary[index];
			arrary[index] = arrary[i - 1];
			arrary[i - 1] = tmp;
		}
		return arrary;
	}
}
