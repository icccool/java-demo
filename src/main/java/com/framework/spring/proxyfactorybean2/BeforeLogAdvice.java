package com.framework.spring.proxyfactorybean2;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice {

	private Logger logger = Logger.getLogger(BeforeLogAdvice.class);

	public void before(Method method, Object[] args, Object target) throws Throwable {
		String targetClassName = target.getClass().getName();
		String targetMethodName = method.getName();
		// args[0] = "Juve";//可以改变参数
		String logInfoText = "前置通知：" + targetClassName + "类的" + targetMethodName + "方法开始执行";
		logger.info(logInfoText);
	}
}