package com.framework.spring.proxyfactorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ProxyFactoryBean 简单使用
 * 
 * @author John
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		System.out.println(Test.class.getResource("/"));
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/code/spring/proxyfactorybean/beans.xml");
		// PersonService personService =
		// ctx.getBean("personServiceProxy",PersonService.class);
		// personService.run();
		// personService.say();

		try {
			// 去等factoryBean本身
			FactoryBean factoryBean = (FactoryBean) ctx.getBean("&personServiceProxy");
			// 取得对象
			PersonService s1 = (PersonService) factoryBean.getObject();
			s1.run();
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
