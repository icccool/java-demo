package com.code.string.copy;

public class StringFormat {
    public static void main(String[] args) {
        test2();
    }

    public static void test2() {
//        ab  :
//        ab  :
//        ab  :aaa
        System.out.println(String.format("%-4s:", "ab"));
        System.out.println(String.format("%-4s:", "ab"));
        System.out.println(String.format("%-4s:%s", "ab","aaa"));
    }

    /**
     * 效率测试
     */
    private void test1() {
        long t = System.currentTimeMillis();
        for (int i = 0; i < 10000 * 2; i++) {
            String.format("%s + %s", "1", "2");
        }
        long d = System.currentTimeMillis() - t;
        System.out.println(d);

        t = System.currentTimeMillis();
        for (int i = 0; i < 10000 * 2; i++) {
            String s = "1" + "+" + "2";
        }
        d = System.currentTimeMillis() - t;
        System.out.println(d);
    }
}
