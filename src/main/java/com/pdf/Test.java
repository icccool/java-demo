package com.pdf;

public class Test {

    public static void main(String[] args) {
        String word = "aaa-bb(*(&";
        word = word.replaceAll("-", "");
        String reg = "[^a-zA-Z]";
        word = word.replaceAll(reg, "");
        System.out.println(word);
    }

}
