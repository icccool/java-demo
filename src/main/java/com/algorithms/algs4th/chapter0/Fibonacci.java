package com.algorithms.algs4th.chapter0;

/**
 *
 * F(n-1) + F(n-2) if n>1
 * 1               if = 1
 * 0               if = 0
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            int b  = fib(i);
            System.out.println(b);
        }
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
