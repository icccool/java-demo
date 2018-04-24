package com.framework.spring.executesubclass.withabstractclass.service;

import org.springframework.stereotype.Component;

@Component
public class CarInfoPrinterServiceImpl implements CarInfoPrinterService {
	
	public void print(String str) {
		System.out.println(str);
	}
}
