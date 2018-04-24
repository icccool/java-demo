package com.framework.spring.autowired.test2;

import org.springframework.stereotype.Service;

@Service
public class CarController  extends BaseController {

	
	public void repair() {
		carServiceImpl.repair();
	}	
	
}
