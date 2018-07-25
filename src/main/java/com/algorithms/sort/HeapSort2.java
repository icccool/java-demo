package com.algorithms.sort;

/**
 * Created by WANG on 2018/7/25.
 */
public class HeapSort2 {

    /**
     * 1.构造大根堆：与上一篇基于堆的优先队列相似，将原始数组重新组织成一个基于堆的拥有重复删除最大元素操作的优先队列；
     * 2.下沉排序：根据构造出来的大根堆，很容易将堆中的最大元素删除，然后放入堆缩小后数组中空出的位置。
     * @param a
     */
    public static void sort(Comparable[] a) {
        int len = a.length - 1;
        //构造大根堆
        //跳过只有一个结点的堆即大小为1的堆，从数组的中间开始扫描，调用sink()方法，层层递减，最后在1位置上调用sink()方法后结束。
        //此次扫描目的是构造一个堆有序的数组并使最大元素位于数组的开头(次大的元素在附近)
        for (int k = len / 2; k >= 1; k--) {
            sink(a, k, len);
            //show(a);
        }
        System.out.println("下沉开始");
        //下沉排序
        //1.每次排序都先将最大的元素与最后一个元素交换位置，接着缩小数组，对除去最后一个元素的堆进行下沉排序
        //2.对缩小后的数组进行下沉排序，若数组长度大于1，则跳转到第一步继续执行
        while (len > 1) {
            exch(a, 1, len--);
            sink(a, 1, len);
            //show(a);
        }
    }

    //下沉排序
    private static void sink(Comparable[] a, int i, int len) {
        while (i * 2 <= len) {
            int j = i * 2;
            if (j < len && less(a[j], a[j + 1])) {
                j++;
            }
            if (!less(a[i], a[j])) {
                break;
            }
            exch(a, i, j);
            i = j;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] v, int i, int j) {
        Comparable temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 4;
        Integer[] a = {0, 10, 9, 8};
        show(a);
        sort(a);
        show(a);
    }

}
