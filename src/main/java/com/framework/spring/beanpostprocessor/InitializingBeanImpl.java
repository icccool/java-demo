package com.framework.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanImpl implements InitializingBean, BeanPostProcessor {

	public InitializingBeanImpl() {
		System.out.println("InitializingBeanImpl has bean initialized.");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean - afterPropertiesSet");
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InitializingBean - postProcessBeforeInitialization");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InitializingBean - postProcessAfterInitialization");
		return bean;
	}

}