package com.code.rpc.myrpc;

import java.lang.reflect.Proxy;
/**
 * 创建代理
 * @author clonen.cheng
 *
 */
public class Invoker {


    public Object getInstance(Class<?> cls){
        MethodProxy invocationHandler = new MethodProxy();
        Object newProxyInstance = Proxy.newProxyInstance(
                cls.getClassLoader(),
                new Class[] { cls },
                invocationHandler);
        return (Object)newProxyInstance;
    }
}
