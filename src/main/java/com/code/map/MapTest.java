package com.code.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("1","a");
		map.put("2","b");
		map.put("3","c");
		map.put("4","d");
//		for (String key : map.keySet()){
//			if(key.equals("1")){
//				map.remove(key);
//			}
//		}
//		System.out.println(map);


		Iterator<String> itr = map.keySet().iterator();
		while (itr.hasNext()){
			String key = itr.next();
			if(key.equals("1")){
				itr.remove();
			}
		}
		System.out.println(map);

	}
}
