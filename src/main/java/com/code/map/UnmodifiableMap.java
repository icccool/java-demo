package com.code.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMap {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "111111");
		Map<String, String> map2 = Collections.unmodifiableMap(map);
		map2.put("key2", "2222");
	}
}
