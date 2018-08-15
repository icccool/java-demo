package com.jdk18;

import java.util.Arrays;
import java.util.List;

/**
 * jdk1.8  新特性
 */
public class LambdaTest {

    public static void  main(String[] args) {
    	//=======================================================================================
    	// Java 8之前：
    	new Thread(new Runnable() {
    	    @Override
    	    public void run() {
    	    System.out.println("Before Java8, too much code for too little to do");
    	    }
    	}).start();
    	//Java 8方式：
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();


    	//=======================================================================================
    	// Java 8之前：
    	List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
    	for (String feature : features) {
    	    System.out.println(feature);
    	}
    	//Java 8方式：
		List features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features2.forEach(n -> System.out.println(n));

    	//=======================================================================================
    	
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

