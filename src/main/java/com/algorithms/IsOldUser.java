package com.algorithms;

import java.util.HashSet;

/**
 * 只出现一次的集合
 */
public class IsOldUser {

    public static void main(String[] args) {
        String[] strs = new String[]{"116569",
                "116569",
                "116573",
                "116573",
                "116573",
                "116573",
                "116573",
                "116574"};
        HashSet<String> oneSet = new HashSet<String>();
        HashSet<String> mutiSet = new HashSet<String>();
        int cnt = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!oneSet.remove(strs[i]) && !mutiSet.contains(strs[i])) {
                cnt += 1;
                oneSet.add(strs[i]);
            } else {
                if (!mutiSet.contains(strs[i])) {
                    cnt -= 1;
                    mutiSet.add(strs[i]);
                }
            }
        }
        System.out.println(cnt);
        System.out.println("只出现一次的集合====>" + oneSet);
        System.out.println("出现多次的集合====>" + mutiSet);
    }
}
