package com.code.map;

import java.util.*;

public class TreeMapTest {
	public static void main(String[] args) {
        sortByKey();
	}

	public static void sortByKey(){
        Map<String,Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    //return 0 如果这里是0则被覆盖
                    return 1;
                }
            }
        });

        String[] wds = {"aa","bb","ccc"};
        for (String wd : wds){
            map.put(wd,0);
        }
        for (String s : map.keySet()){
            System.out.println(s);
        }
    }

}
