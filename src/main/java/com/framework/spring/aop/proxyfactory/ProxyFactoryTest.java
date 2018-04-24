package com.framework.spring.aop.proxyfactory;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by john on 17/11/22.
 */
public class ProxyFactoryTest {

    public static void main(String[] args) {
        Waiter waiter = (Waiter) jdkProxyMethod();
        waiter.greetTo("John");
        waiter.serveTo("Tom");
    }

    public static Object jdkProxyMethod() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);
        return proxyFactory.getProxy();
    }

    public static Object cglibProxyMethod() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        //强制使用cglib
        proxyFactory.setOptimize(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);
        return proxyFactory.getProxy();
    }
}
