package com.code.string;

public class StringHashCode {

    public static void main(String[] args) {

        String s = "11124323";

        String s1 = "ppppp11124323";
        String s3 = "AAA11124323";

        String sa = "a";
        String sA = "A";

        System.out.println(s.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(sa.hashCode());
        System.out.println(sA.hashCode());
    }
}
