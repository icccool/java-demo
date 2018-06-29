package com.algorithms.sort.test1;

/**
 * Created by WANG on 2018/6/29.
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //插入排序
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            //选择一个key
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
