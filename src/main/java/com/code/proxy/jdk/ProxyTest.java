package com.code.proxy.jdk;

import com.code.proxy.SayHello;
import com.code.proxy.SayHelloImpl;

public class ProxyTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //被代理
        SayHello say = new SayHelloImpl();
        //代理
        SayHelloProxy proxy = new SayHelloProxy();
        SayHello proxySay = (SayHello) proxy.bind(say);
        //执行代理方法
        proxySay.say();
    }
}
