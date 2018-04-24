package com.framework.spring.defaultlazyinit;

import java.io.FileNotFoundException;

import com.framework.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

/**
 *
 * 延迟加载
 * @author John
 *
 */
public class Test {

	private static Logger logger = LoggerFactory.getLogger(Test.class);

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
//		default-lazy-init="false"
		System.out.println("===============================================================================");
		System.out.println("如果default-lazy-init=\"true\"  在获得bean的时候生成实例.     [lazy 初始无参构造....]会在此注释之后显示.");
		System.out.println("如果default-lazy-init=\"false\" 初始context容器的时候生成实例. [lazy 初始无参构造....]会在此注释之前显示.");
		System.out.println("===============================================================================");
		System.out.println("获得Lazy ==> " + ctx.getBean(Lazy.class));

	}
}
