package com.code.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * @Author WANG JI BO
 * @Date 2019/5/29 下午4:14
 * @Description
 **/
public class SoftReferenceDemo {
    public static void main(String[] args) {
        String obj = new String("hello");
        SoftReference<String> sr = new SoftReference<String>(obj);
        System.out.println(sr.get());
    }
}
