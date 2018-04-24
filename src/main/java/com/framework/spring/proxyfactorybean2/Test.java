package com.framework.spring.proxyfactorybean2;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.framework.spring.SpringUtil;

/**
 * ProxyFactoryBean 的简单使用
 * 
 * @author John
 */ 
public class Test {
	// 初始log4j
	static {
		try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(SpringUtil.SPRING_BASE_CLASSPATH +"/proxyfactorybean2/beans.xml");
		IUserService userService = (IUserService) context.getBean("myProxy");
		userService.addUser("ton", 56);
		userService.deleteUser("ton");
	}
}
