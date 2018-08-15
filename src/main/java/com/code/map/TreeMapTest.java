package com.code.map;

import java.util.*;

public class TreeMapTest {
	public static void main(String[] args) {
		SortedMap<String, Object> sortedMap = new TreeMap<String, Object>();
		sortedMap.put("userAccount","6866f3d3695866fd831c5d0fe89ccf3e");
		sortedMap.put("amount","100");
		sortedMap.put("tranSeq", "1000");

		System.out.println(sortedMap);

	}

}
