package com.framework.spring.aop.proxyfactory;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by john on 17/11/22.
 */
public class GreetingBeforAdvice implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("前置通知 .....");
    }
}
