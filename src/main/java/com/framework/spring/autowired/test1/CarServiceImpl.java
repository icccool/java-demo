package com.framework.spring.autowired.test1;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl {
	
	public void repair() {
		System.out.println("repair");
	}
}
