package com.framework.spring.innerclz;

import org.springframework.stereotype.Service;

@Service
public class BeanClz {

	public int UpdateOp() {
		System.out.println("BeanClz.UpdateOp()");
		return 1;
	}
}
