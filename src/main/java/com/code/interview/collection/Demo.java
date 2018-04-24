package com.code.interview.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo implements Serializable{
	public static void main(String[] args) {
		// Hashtable<String, String> hTable = new Hashtable<String, String>();
		// Collections.synchronizedMap(null);
		SortedMap<String, String> treeMap = new TreeMap<String, String>();
		SortedSet<String> treeSet = new TreeSet<String>();
		List<String> ls = new ArrayList<String>();
		CopyOnWriteArrayList cowList = new CopyOnWriteArrayList();
		String str1 = "aa";
		String str2 = "aa";
		System.out.println(str1 == str2);
	}
}
