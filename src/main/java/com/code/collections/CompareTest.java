package com.code.collections;

import java.text.Collator;

/**
 * Created by john on 17/12/10.
 */
public class CompareTest {
    public static final Collator COLLATOR = Collator.getInstance();

    public static void main(String[] args) {
        System.out.println(COLLATOR.compare("2017-12-12","2017-12-11"));
    }
}
