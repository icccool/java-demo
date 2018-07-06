package com.algorithms.algs4th.chapter1;

import com.algorithms.SortUtils;

/**
 * 基于堆实现的优先队列
 */
public class MaxPQ {
    int arr[];
    int size = 0;
    public MaxPQ() {
    }
    public MaxPQ(int size) {
        this.arr = new int[size];
        this.size = size;
    }
    public MaxPQ(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    //如果当前节点比父节点大, 上浮当前节点
    private void swim(int k) {
        while (k > 1 && arr[k / 2] < arr[k]) {
            SortUtils.exch(arr, k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k < size) {
            //左子节点
            int j = 2 * k;
            //左子节点和右子几点对比
            if (j < size && arr[j] < arr[j + 1]) {
                j++;
            }
            //当前节点大于子节点跳出循环
            if (arr[k] > arr[j])
                break;
            SortUtils.exch(arr, j, k);
            k = j;
        }
    }

}
