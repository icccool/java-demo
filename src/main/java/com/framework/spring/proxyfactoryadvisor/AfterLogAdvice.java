package com.framework.spring.proxyfactoryadvisor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogAdvice implements AfterReturningAdvice {

	private Logger logger = Logger.getLogger(AfterLogAdvice.class);

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// 获取被调用的类名
		String targetClassName = target.getClass().getName();
		// 获取被调用的方法名
		String targetMethodName = method.getName();

		// 日志格式字符串
		String logInfoText = "后置通知：" + targetClassName + "类的" + targetMethodName + "方法已经执行";
		// 将日志信息写入配置的文件中
		logger.info(logInfoText);
	}
}