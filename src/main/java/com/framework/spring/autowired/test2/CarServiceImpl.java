package com.framework.spring.autowired.test2;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl {
	
	public void repair() {
		System.out.println("repair");
	}
}
