package com.algorithms.algs4th.chapter0;

import com.algorithms.SortUtils;

/**
 * Created by WANG on 2018/7/5.
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 8, 15, 0, 8};
        partition(arr, 0, arr.length - 1);
        SortUtils.print(arr);

//        int p = arr.length / 2;
//        partition(arr, 0, p, arr.length - 1);
//        SortUtils.print(arr);
    }

    public static void partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        int key = lo;
        while (true){
        	//扫描左边遇到比key大的停止
            while (arr[++i] > arr[key]) {
                if (i >= hi)
                    break;
            }
            //扫描右边记录比key小的停止
            while (arr[--j] < arr[key]) {
                if (j <= lo)
                    break;
            }
            if(i >= j){
                break;
            }
            SortUtils.exch(arr, i, j);
        }
        SortUtils.exch(arr, j, key);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int key = lo;
            int p = lo;
            for (int i = lo + 1; i <= hi; i++) {
                if (arr[i] < arr[key]) {
                    SortUtils.exch(arr, ++p, i);
                }
            }
            SortUtils.exch(arr, p, key);
            sort(arr, lo, p - 1);
            sort(arr, p + 1, hi);
        }
    }

}
