package com.jdk18;

/**
 * Created by john on 18/1/5.
 */
public class LambdaTest {

    public static void main(String[] args) {
        MyString reverse = (str)-> {

            return "";
        };
        String s = reverse.myStringFunction("abc");
        System.out.println(s);
    }

}


interface MyString{
    public  String myStringFunction(String str);
}

