package com.framework.spring.proxyfactorybean;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public void run() {
		System.out.println("running ..");
	}

	@Override
	public void say() {
		System.out.println("saying ..");
	}

}
