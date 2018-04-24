package com.framework.spring.beannameautoproxycreator;

import java.io.FileNotFoundException;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.framework.spring.proxyfactorybean2.IUserService;

/**
 * BeanNameAutoProxyCreator <br>
 * beanNames可以指定被代理的Bean名字列表，支持“*”通配符，例如“*DAO”表示所有名字以 “DAO”结尾的Bean
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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/code/spring/beannameautoproxycreator/beans.xml");
		try {
			IUserService userService = (IUserService) context.getBean("myUserService");
			userService.addUser("ton", 56);
			userService.deleteUser("ton");
		} catch (BeansException e) {
			e.printStackTrace();
		}

		// String str[] = context.getBeanDefinitionNames();
		// for (int i = 0; i < str.length; i++) {
		// System.out.println(str[i]);
		// }

	}
}
