package com.framework.spring.autowired.test1;

import org.springframework.stereotype.Service;

@Service
public class CarController  extends BaseController {

	
	public void repair() {
		carServiceImpl.repair();
	}	
	
}
