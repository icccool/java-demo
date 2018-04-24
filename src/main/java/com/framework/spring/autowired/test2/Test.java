package com.framework.spring.autowired.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 *  父类不托管spring也可以注入属性.
 * @author 2017-11-01 17:28:21 WANG
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
		CarController car = ctx.getBean(CarController.class);
		car.repair();
	}
}
