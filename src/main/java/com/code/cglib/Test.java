package com.code.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Test {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(MyClass.class);
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before.......");
				proxy.invokeSuper(obj, args);
				System.out.println("after........");
				return null;
			}

		});
		MyClass my = (MyClass) enhancer.create();
		my.method();

	}
}

