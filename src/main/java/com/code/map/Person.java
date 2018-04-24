package com.code.map;

public class Person implements Comparable<Person>{
	String age;
	String name;
	
	public Person(String age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int compareTo(Person o) {
		return this.age.compareTo(o.getAge());
	}
	
}
