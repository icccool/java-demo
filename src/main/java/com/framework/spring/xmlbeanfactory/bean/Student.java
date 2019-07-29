package com.framework.spring.xmlbeanfactory.bean;

public class Student {

    int age;

	String name;

	Teacher teacher;

//	public Student() {
//		System.out.println("Student has been initialized");
//	}

	public Student(String name) {
		System.out.println("Student has been initialized");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}

}
