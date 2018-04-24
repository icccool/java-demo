package com.code.interview;

public class MyPermutation {
	public static void main(String[] args) {
		String str = "123";
		permutation(str.toCharArray(), 0);

	}

	public static void permutation(char[] ch, int i) {
		if (i > ch.length) {
			return;
		}
		if (i == ch.length) {
			System.out.println(ch);
		} else {
			for (int j = i; j < ch.length; j++) {
				swap(ch, j, i);
				permutation(ch, i + 1);
				swap(ch, i, j);
			}
		}
	}

	public static void swap(char[] ch, int i, int j) {
		char t = ch[i];
		ch[i] = ch[j];
		ch[j] = t;
	}
}
