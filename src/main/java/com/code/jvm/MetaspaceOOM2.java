package com.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxMetaspaceSize=10m
 *
 * 不断向常量池添加常量,导致Metaspace内存溢出
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 *
 * @Author WANG JI BO
 **/
public class MetaspaceOOM2 {

    static String base = "string";


    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }

}
