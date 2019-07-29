package com.code.trycatch;

/**
 * @Author WANG JI BO
 * @Date 2019/7/9 下午4:12
 * @Description
 **/
public class TryCatchTest2 {

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void  test() throws Exception{
        try {

            System.out.println();
            int i = 1/0;
        } catch (Exception e) {
            System.out.println("-------------");
            throw e;
        }

    }
}
