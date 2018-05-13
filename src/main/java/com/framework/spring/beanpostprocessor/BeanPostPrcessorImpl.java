package com.framework.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.framework.spring.xmlbeanfactory.bean.Student;

public class BeanPostPrcessorImpl implements BeanPostProcessor {

	// Bean 实例化之前进行的处理
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student) {
			System.out.println("BeanPostPrcessorImpl - 对象" + beanName + "开始实例化");
		}
		return bean;
	}

	// Bean 实例化之后进行的处理
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student) {
			System.out.println("BeanPostPrcessorImpl - 对象" + beanName + "实例化完成");
		}
		return bean;
	}
}