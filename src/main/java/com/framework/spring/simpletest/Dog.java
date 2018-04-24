package com.framework.spring.simpletest;

import org.springframework.stereotype.Component;

/**
 * Created by john on 18/3/30.
 */
@Component
public class Dog {

    private String name = "anbei";
    private String color  = "black";

    public Dog() {
        System.out.println("dog 初始化 ....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
