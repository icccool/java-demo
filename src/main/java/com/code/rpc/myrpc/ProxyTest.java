package com.code.rpc.myrpc;

public class ProxyTest {

    public static void main(String[] args) {
        IUserDao invoker=(IUserDao)new Invoker().getInstance(IUserDao.class);
        System.out.println(invoker.getClass().getName());
        System.out.println(invoker.getUserName());
    }

}
