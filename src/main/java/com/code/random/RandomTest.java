package com.code.random;

import java.util.HashSet;
import java.util.Set;

public class RandomTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		System.out.println(set.add(new String("aa")));
		System.out.println(set.add(new String("aa")));
		
		System.out.println(set);
//		for (int i = 0; i < 5000; i++) {
//			System.out.println(((int) (Math.random() * 1000) + 9999));
//		}
	}
}
