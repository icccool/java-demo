package com.framework.spring.xmlbeanfactory.bean;

public class Teacher {
	String name;

	public Teacher() {
		System.out.println("Teacher has been initialized");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
