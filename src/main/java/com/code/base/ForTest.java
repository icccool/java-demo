package com.code.base;

/**
 * @Author WANG JI BO
 * @Date 2019/7/16 下午3:37
 * @Description
 **/
public class ForTest {

    public static void main(String[] args) {
        try {
            for (int i = getNum(); i > 0; ) {
                Thread.sleep(1000L);
                System.out.println("for,,,");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static int getNum() {

        System.out.println("--------------");
        return 1;
    }

}
