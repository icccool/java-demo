package com.framework.spring.executesubclass;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Log4jConfigurer;

@Component
public class Benz implements Car{

	public void didi() {
		System.out.println("Benz didi.");
	}

}
