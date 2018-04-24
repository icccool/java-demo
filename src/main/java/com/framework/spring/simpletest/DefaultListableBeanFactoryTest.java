package com.framework.spring.simpletest;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Created by john on 18/3/29.
 */
public class DefaultListableBeanFactoryTest {

    // 初始log4j
    static {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------START----------------------");
        ClassPathResource res = new ClassPathResource("com/framework/spring/simpletest/beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        Person p1 = factory.getBean("p1", Person.class);
        System.out.println("p1====>" + p1);

        System.out.println("-------------------------注册一个bean-----------------");
        factory.registerBeanDefinition("test", new RootBeanDefinition(DefaultListableBeanFactoryTest.class));//注册一个FactoryBean类型的BeanDefinition
        System.out.println(factory.getBean("test"));//获取Bean，也就是调用了FactoryBean的getObject
        System.out.println(factory.getBean("&test"));//& 获取FactoryBean

        System.out.println("-------------------------END-------------------------");
    }

}
