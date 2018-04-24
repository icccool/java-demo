package com.code.collections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("1 ");
		l1.add("2");
		l1.add("3");
		for (String string : l1) {
			System.out.println(string.trim());
		}
		
		List<String> l2 = new ArrayList<String>();
		l2.add("4");
		l2.add("5");
		l2.add("6");
		
		System.out.println(l1);
	}
}
