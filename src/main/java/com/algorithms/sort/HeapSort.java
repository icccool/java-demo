package com.algorithms.sort;

import com.algorithms.SortUtils;

/**
 *
 * 先用下沉的方法构造了一个堆后，堆有一个特点啊，那就是它的第一个元素永远是最大（或最小）的，如果你想从小到大排，那就把首元素和最后一个元素交换，肯定没毛病，这样最大的就归位了。
 * 下一步再把前n-1个元素利用下沉恢复堆的结构，这样倒数第二大的有跑到最前面了，那就让它再和倒数第二个交换就行了，依次类推
 * Created by WANG on 2018/7/25.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0, 10, 9, 8, 5, 6};
        SortUtils.print(arr);
        sort(arr);
        SortUtils.print(arr);
    }

    public static void sort(int[] arr) {
        int n = arr.length - 1;
        //构建大根造堆
        for (int i = n / 2; i >= 1; i--) {
            sink(arr, i, n);
        }
        //堆排序
        while (n > 1) {
            SortUtils.exch(arr, 1, n--);
            sink(arr, 1, n);
        }
    }

    //小的节点下沉
    public static void sink(int[] arr, int i, int len) {
        while (i * 2 <= len) {
            //左节点
            int k = i * 2;
            //右节点是否小于左节点
            if (k < len && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果当前节点小于子节点停止下沉
            if (arr[i] > arr[k]) {
                break;
            }
            SortUtils.exch(arr, i, k);
            i = k;
        }
    }

}
