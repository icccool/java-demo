package com.framework.spring.innerclz;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;
/**
 *
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
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		SpringOuterClz outerClz = ctx.getBean(SpringOuterClz.class);
		System.out.println(outerClz);
		System.out.println(outerClz.new InnerClz().getHeadNum());
		System.out.println(outerClz.new InnerClz().beanClzUpdate());
		System.out.println(outerClz.new InnerClz().getOuterClz());
	}
}
