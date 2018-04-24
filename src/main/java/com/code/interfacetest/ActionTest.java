package com.code.interfacetest;

public class ActionTest {
	public static void main(String[] args) {
		Action a2 = new ActionImpl2();
		a2.walk();
		a2.eat();
		Action a1 = new ActionImpl1();
		a1.walk();
		a1.eat();
	}
}
