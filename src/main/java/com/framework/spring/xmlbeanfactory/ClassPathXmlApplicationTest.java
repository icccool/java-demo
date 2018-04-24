package com.framework.spring.xmlbeanfactory;

import com.framework.spring.aop.aspect.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framework.spring.xmlbeanfactory.bean.Student;

public class ClassPathXmlApplicationTest {
	public static void main(String[] args) {

		String path = ClassPathXmlApplicationTest.class.getResource("beans.xml").toString();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		Student st = ctx.getBean("zhangsan", Student.class);
		st.setAge(1);
		st.setName("aa");
		System.out.println(st);
	}
}
