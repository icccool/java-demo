package com.code.base;

//		a1.show(b));Class A 中没有show（B obj），B转向B的父类A，执行A show（A obj）--->return "A and A"
//
//		a1.show(c));Class A 中没有show（C obj），C转向C的父类B,Class A 中没有show（B obj），再转向父类A，执行A show（A obj）--->return "A and A"
//
//		a1.show(d));Class A 中有show（D obj）执行A show（D obj）--->return "A and D"
//		这个比较特殊：A a2 = new B();父类声明，子类实例，你应该把a2当作子类重写完后的父类看，注意只有父类的方法。
//
//		a2.show(b));Class A 中没有show（B obj），B转向B的父类A，执行A show（A obj）,A的show 方法被重写,执行B show（A obj）--->return "B and A"
//
//		a2.show(c));Class A 中没有show（C obj）,C转向C的父类B,Class A 中没有show（B obj）,B转向父类A，执行A show（A obj）,A的show 方法被重写,执行B show（A obj）--->return "B and A"
//
//		a2.show(d));Class A 中有show（D obj）执行A show（D obj）--->return "A and D"
//		b.show(b)); Class B 中有show（B obj）--->return "B and B"
//
//		b.show(c)); Class B 中没有show（C obj），C转向C的父类B，执行B show（B obj）--->return "B and B"
//
//		b.show(d)); Class B 中有继承了Class A 的show（D obj）,执行A show（D obj）--->return "A and D"

//java 多态理解
public class Dynamic {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();

		B b = new B();
		C c = new C();
		D d = new D();

		System.out.println(a1.show(b));
		System.out.println(a1.show(c));
		System.out.println(a1.show(d));
		System.out.println(a2.show(b)); //B AND A
		System.out.println(a2.show(c));
		System.out.println(a2.show(d));
		System.out.println(b.show(b));
		System.out.println(b.show(c));
		System.out.println(b.show(d));
	}
}

class A {
	public String show(D obj) {
		return ("A and D");
	}

	public String show(A obj) {
		return ("A and A");
	}
}

class B extends A {
	public String show(B obj) {
		return ("B and B");
	}

	public String show(A obj) {
		return ("B and A");
	}
}

class C extends B {
}

class D extends B {
}
