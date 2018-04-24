package com.framework.spring.autowired.test2;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * 这个类没有托管spring
 */
public  abstract class BaseController {
	
	@Autowired
    CarServiceImpl carServiceImpl;

}
