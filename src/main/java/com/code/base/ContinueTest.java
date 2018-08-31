package com.code.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WANG on 2018/8/24.
 */
public class ContinueTest {


    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("A");

        int i = 0;
        while(true){
            String s = ls.get(i++);
            System.out.println(s);
            if(s != null){
                if (!s.equals("B")){
                    continue;
                }
                System.out.printf("===============");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
