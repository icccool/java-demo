package com.code.base.typematch;

import com.framework.spring.aop.aspect.entity.User;

public class TypeMatch {


    public static void main(String[] args) {

        Object o1 = new User();
        System.out.println(o1.getClass().toString());


    }


    public static void type1(String[] args) {

    }

    public static void type2(String[] args) {

    }

}
