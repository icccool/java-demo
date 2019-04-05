package com.code.trycatch;

/**
 * @Author WANG JI BO
 * @Date 2019/4/3 上午11:08
 * @Description
 **/
public class TryCatchTest {
    public static void main(String[] args) {
        test(null);

    }


    public static int test(String str) {
        try {

            if (str == null) {
                throw new Exception("str is null");
            }

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
}
