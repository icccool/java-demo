package com.framework.spring.simpletest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by john on 18/4/7.
 */
@Component
public class SimplePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("dog")) {
            System.out.println("SimplePostProcessor.postProcessBeforeInitialization ==>  "+bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("SimplePostProcessor.postProcessAfterInitialization ==>  "+bean);
        return null;
    }
}
