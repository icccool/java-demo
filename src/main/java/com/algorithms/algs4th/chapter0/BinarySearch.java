package com.algorithms.algs4th.chapter0;

/**
 * 二分查找
 * Created by WANG on 2018/6/19.
 */
public class BinarySearch {

    public static void main(String[] args) {
        //数组必须是有序的
        int a[] = {1, 3, 4, 5, 6, 7};
        int val = rank(7, a);
        System.out.println(val);
        System.out.println((int) ((Math.random() * 9 + 1) * 100000));
    }

    public static int rank(int key, int[] a) {
        return recursion_rank(key, 0, a.length - 1, a);
    }

    //循环查找
    public static int rank(int key, int lo, int hi, int[] a) {
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (key == a[mid]) {
                return mid;
            }
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }

    //递归查找
    public static int recursion_rank(int key, int lo, int hi, int[] a) {
        if(lo > hi){
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if(key == a[mid]) {
            return mid;
        }else if(key < a[mid]){
            return recursion_rank(key, lo, mid - 1, a);
        }else {
            return recursion_rank(key, mid + 1, hi, a);
        }
    }

}
