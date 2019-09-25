package com.code.reflex.test;

/**
 * @Author WANG JI BO
 * @Date 2019/8/7 下午10:04
 * @Description
 **/
public class ClassTest {

    public static void main(String[] args) {

        String packageName = ClassTest.class.getPackage().getName();
        //完整包名
        //com.code.reflex.test
        System.out.println(packageName);
        //test 当前包名
        System.out.println(packageName.substring(packageName.lastIndexOf(".") + 1, packageName.length()));

    }
}
