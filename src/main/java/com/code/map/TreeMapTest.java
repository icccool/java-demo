package com.code.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		Person p1 = new Person("1", "a");
		Person p2 = new Person("2", "a");
		Person p3 = new Person("11", "a");
		Person p4 = new Person("6", "a");

		TreeMap<String, Person> map = new TreeMap<String, Person>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1) - Integer.valueOf(o2);  
			}
		});
		map.put("1", p1);
		map.put("11", p2);
		map.put("3", p3);
		for (String key : map.keySet()) {
			System.out.println(key);
		}
	}
}
