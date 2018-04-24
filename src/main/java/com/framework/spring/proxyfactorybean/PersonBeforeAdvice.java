package com.framework.spring.proxyfactorybean;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class PersonBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(method.getName() + " beforeAdvice.");
	}

}
