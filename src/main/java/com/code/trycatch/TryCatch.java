package com.code.trycatch;

public class TryCatch {
	public static void main(String[] args) {
		String[] str = new String[5];
		try {
			for (int i = 0; i < str.length + 1; i++) {
				str[i] = i + "a";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("print ...");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}

	}
}
