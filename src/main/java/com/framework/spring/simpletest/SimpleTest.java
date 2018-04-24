package com.framework.spring.simpletest;

import com.framework.spring.autowiredannotationbeanpostprocessor.Student;
import com.framework.spring.autowiredannotationbeanpostprocessor.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Created by john on 18/3/29.
 */
public class SimpleTest {

    // 初始log4j
    static {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("-------------------------START-------------------------");

//        ClassPathResource res=new ClassPathResource("beans.xml");
//        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(res);

        String path = SimpleTest.class.getResource("beans.xml").toString();
        ApplicationContext ctx = new FileSystemXmlApplicationContext(path);
//        Person p1 = ctx.getBean(Person.class);
//        System.out.println("p1.name:" + Dp1.getName());
//        Dog dog = ctx.getBean("dog",Dog.class);
        Person p1 = ctx.getBean("person",Person.class);
//        System.out.println("dog.name:" + dog.getName());
//        System.out.println("p1.name:" + p1.getName());


        System.out.println("getBeanDefinitionCount:" + ctx.getBeanDefinitionCount());
        System.out.println("getApplicationName:" + ctx.getApplicationName());
        System.out.println("getDisplayName:" + ctx.getDisplayName());
        System.out.println("getId:" + ctx.getId());
        System.out.println("getParent:" + ctx.getParent());
        System.out.println("getStartupDate:" + ctx.getStartupDate());
        System.out.println("================ctx.getBeanDefinitionNames()=============== cnt = " + ctx.getBeanDefinitionCount());
        for(String name : ctx.getBeanDefinitionNames()){
            System.out.println(name);
        }

        System.out.println("-------------------------END-------------------------");
    }

}
