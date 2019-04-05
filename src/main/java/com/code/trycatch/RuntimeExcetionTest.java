package com.code.trycatch;

/**
 * @Author WANG JI BO
 * @Date 2019/1/8 下午7:47
 * @Description
 **/
public class RuntimeExcetionTest {

    public static void main(String[] args) {
        System.out.println(numberFormat("2224sd"));
        System.out.println("---------------------------");
    }

    public static int numberFormat(String num){
        return Integer.valueOf(num);
    }
}


