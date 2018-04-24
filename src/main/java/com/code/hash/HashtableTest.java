package com.code.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.Vector;
class Obj{
	
}
public class HashtableTest {
	
	public static void main(String[] args) {
		Hashtable<String, String> tab = new Hashtable<String, String>();
		LinkedList<String> linkList = new LinkedList<String>();
		Vector vector = new Vector();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		ArrayList<String> list = new ArrayList<String>();
		
		
		List<Obj> ls = new ArrayList<Obj>();
		ls.add(new Obj());
		System.out.println(ls);
		
		System.out.println(ls.get(0));
		for (Obj obj : ls) {
			System.out.println(obj);
		}
		
	}
}
