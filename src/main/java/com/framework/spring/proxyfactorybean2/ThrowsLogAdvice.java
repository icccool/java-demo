package com.framework.spring.proxyfactorybean2;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class ThrowsLogAdvice implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(ThrowsLogAdvice.class);

	public void afterThrowing(Method method, Object[] args, Object target, Throwable exeptionClass) {
		// 获取被调用的类名
		String targetClassName = target.getClass().getName();
		// 获取被调用的方法名
		String targetMethodName = method.getName();
		// 日志格式字符串
		String logInfoText = "异常通知：执行" + targetClassName + "类的" + targetMethodName + "方法时发生异常";
		// 将日志信息写入配置的文件中
		logger.info(logInfoText);
	}
	/*
	 * public void afterThrowing(IllegalArgumentException e){
	 * System.out.println(e.getMessage()); }
	 */
}