package com.code.interview;


/***
 *  属性可以被继承，但是不能被覆盖
 * @author wang
 */
public class FieldExtend{
	public static void main(String[] args) {
		A xx = new B();
		System.out.println(xx.i);
	}
}

class A {
	 int i = 12;
}

class B extends A {
	int i = -6;
}

