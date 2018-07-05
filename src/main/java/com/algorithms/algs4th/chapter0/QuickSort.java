package com.algorithms.algs4th.chapter0;

import com.algorithms.sort.SortUtil;

/**
 * Created by WANG on 2018/7/5.
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {2, 1, 3};

        int p = arr.length / 2;
        partition(arr, 0, p, arr.length - 1);
    }

    public static int partition(int[] arr,int lo,int p,int hi) {
        int key = arr[lo];
        int i = lo, j = hi;
        while(true){
            while (i < p && arr[i] > arr[key]){
                i++;
                break;
            }
            while (j > p && arr[j] < arr[key]){
                j--;
                break;
            }
            if(i >= j){
                break;
            }
            SortUtil.exch(arr, i, j);
        }
        SortUtil.exch(arr, key, i);
        return i;
    }
}
