package com.code.interview;

public class Hex2Int {
	public static void main(String[] args) {
		String str = "fff";
		int len = str.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(len - 1 - i);
			int n = Character.digit(c, 16);
			sum += n * (1 << (4 * i));
		}
		System.out.println(sum);
	}

}
