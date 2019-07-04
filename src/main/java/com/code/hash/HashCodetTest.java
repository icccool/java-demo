package com.code.hash;

import com.framework.spring.aop.aspect.entity.User;

import java.util.HashSet;
import java.util.Set;

class Person {
	public Person() {
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class HashCodetTest {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		new Person("a", 11);
		new Person("b", 11);

	}
}
