package com.framework.spring.xmlbeanfactory;

import com.framework.spring.xmlbeanfactory.bean.Student;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlBeanFactoryTest {
	public static void main(String[] args) {

//        String path = XmlBeanFactoryTest.class.getResource("beans.xml").toString();
        ClassPathResource res = new ClassPathResource("/com/code/spring/xmlbeanfactory/beans.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);

		// 编程式bean注入
		 RootBeanDefinition stu = new RootBeanDefinition(Student.class);
		 stu.setScope(BeanDefinition.SCOPE_SINGLETON);
         //
		 factory.registerBeanDefinition("wang", stu);

		 MutablePropertyValues personProps = new MutablePropertyValues();
		 personProps.add("name", "wang").add("age", "20");
		 stu.setPropertyValues(personProps);

		 Student we = (Student) factory.getBean("wang");
		 System.out.println(we);

		Student we2 = (Student) factory.getBean("zhangsan");
		 System.out.println(we2);

	}
}
