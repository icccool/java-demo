package com.code.rpc.myrpc;

/**
 * 服务器端目标业务类，被代理对象
 */
public class RemoteService implements Service {
    @Override
    public String getService(String name, int number) {
        return name + ":" + number;
    }
}
