package com.code.jvm;

import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

/**
 *
 *
 * -XX:MaxMetaspaceSize=10m -verbose:class -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/mac/Documents/bak/jvm_dump
 *
 * -verbose:class 查看类加载情况
 *
 * 通过cglib创建class, 导致Metaspace内存溢出
 *
 * @Author WANG JI BO
 * @Date 2019/5/26 下午5:09
 * @Description
 **/
public class MetaspaceOOM {

    public static void main(String[] args) {
        ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaspaceOOM.class);
            enhancer.setCallbackTypes(new Class[]{Dispatcher.class, MethodInterceptor.class});
            enhancer.setCallbackFilter(new CallbackFilter() {
                @Override
                public int accept(Method method) {
                    return 1;
                }
                @Override
                public boolean equals(Object obj) {
                    return super.equals(obj);
                }
            });

            Class clazz = enhancer.createClass();
            System.out.println(clazz.getName());
            //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
            System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
            System.out.println("active: " + loadingBean.getLoadedClassCount());
            System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
        }
    }

}
