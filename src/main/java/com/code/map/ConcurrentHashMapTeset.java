package com.code.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by john on 18/4/10.
 */
public class ConcurrentHashMapTeset {

    public static void main(String[] args) {
        Map map = new ConcurrentHashMap(16);

        map.putIfAbsent("1",22);
        map.putIfAbsent("2",22);
        map.putIfAbsent("3",22);
        map.putIfAbsent("4",22);
        map.putIfAbsent("5",22);
        map.putIfAbsent("6",22);
        map.putIfAbsent("7",22);
        map.putIfAbsent("8",22);
        map.putIfAbsent("9",22);
        map.putIfAbsent("10",22);
        map.putIfAbsent("11",22);
        map.putIfAbsent("12",22);
        map.putIfAbsent("13",22);
        map.putIfAbsent("14",22);
        map.putIfAbsent("16",22);
        map.putIfAbsent("17",22);
        map.putIfAbsent("18",22);

        System.out.println(map);
        int i15 = spread("15".hashCode());
        int i18 = spread("18".hashCode());
        for (int i=0;i < 18 ; i++){
            spread("18".hashCode());
        }
        System.out.println(i15);
        System.out.println(i18);
    }

    public static int spread(int h) {
        return (h ^ (h >>> 16)) & 0x7fffffff;
    }
}
