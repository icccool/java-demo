package com.framework.spring.defaultlazyinit;

import org.springframework.stereotype.Component;

@Component
public class Lazy {

	String name;
	String describe;

	public Lazy() {
		super();
		System.out.println("lazy 初始无参构造....");
	}

	public Lazy(String name, String describe) {
		super();
		System.out.println("lazy 带参数 ...");
		this.name = name;
		this.describe = describe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
