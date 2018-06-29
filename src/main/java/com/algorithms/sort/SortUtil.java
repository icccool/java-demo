package com.algorithms.sort;

/**
 * Created by WANG on 2018/6/28.
 */
public class SortUtil {

    public static void exch(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
