package com.framework.spring.autowiredannotationbeanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * BeanNameAutoProxyCreator <br>
 * Autowired 通过 BeanPostProcessor实现
 * 具体实现
 * 
 * @author John
 *
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
		Student st = ctx.getBean("student", Student.class);
		System.out.println(st.getTeacher());
	}
}
