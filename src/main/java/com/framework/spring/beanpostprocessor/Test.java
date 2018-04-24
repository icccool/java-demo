package com.framework.spring.beanpostprocessor;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.framework.spring.xmlbeanfactory.bean.Student;

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
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/code/spring/beanpostprocessor/beans.xml");
		Student st = ctx.getBean("zhangsan", Student.class);
		System.out.println(st);
	}
}
