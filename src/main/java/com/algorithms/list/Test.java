package com.algorithms.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();

		List<String> linked = new LinkedList<String>();
		linked.add("AA");
		linked.add(1,"aaaaaaa");

		List<String> aList = new ArrayList<>();
		aList.add("aa");

		int a = 9 >> 1;
		System.out.println(a);
	}
}
