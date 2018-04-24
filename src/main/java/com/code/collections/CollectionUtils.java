package com.code.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("A");
		ls.add("B");
		ls.add("C");
		ls.add("D");
		ls.add("E");
		ls.add("D");
		int i = Collections.binarySearch(ls, "D");
		System.out.println("D index = " + i);
	}
}
