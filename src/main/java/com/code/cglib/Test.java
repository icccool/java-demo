package com.code.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Test {

    //一般的命名规则：
    //被代理class name + "$$" + 使用cglib处理的class name + "ByCGLIB" + "$$" + key的hashcode
    //示例：FastSource$$FastClassByCGLIB$$e1a36bab.class

    //  如何强制使用CGLIB实现AOP？
    // （1）添加CGLIB库，SPRING_HOME/cglib/*.jar
    // （2）在spring配置文件中加入<aop:aspectj-autoproxy proxy-target-class="true"/>

    //JDK动态代理和CGLIB字节码生成的区别？
    // （1）JDK动态代理只能对实现了接口的类生成代理，而不能针对类
    // （2）CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法
    //   因为是继承，所以该类或方法最好不要声明成final

    public static void main(String[] args) {
        //
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "com.sun.proxy");

        Enhancer enhancer = new Enhancer();
        //
        enhancer.setSuperclass(MyClass.class);
        //
        enhancer.setCallback(new MethodInterceptorImpl());
        //
        MyClass my = (MyClass) enhancer.create();
        my.method();

    }
}

