package com.framework.spring.proxyfactoryadvisor;

import java.io.FileNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
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
		String path = Test.class.getResource("beans.xml").toString();
		ApplicationContext ctx = new FileSystemXmlApplicationContext(path);
		IUserService userService = (IUserService) ctx.getBean("myProxy");
		userService.addUser("ton", 56);
		userService.deleteUser("ton");
	}
}
