package com.framework.spring.aop.proxyfactory;

/**
 * Created by john on 17/11/22.
 */

public class NaiveWaiter implements Waiter {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public void greetTo(String name) {
        System.out.println("greetTo ==> " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serveTo ==> " + name);
    }
}