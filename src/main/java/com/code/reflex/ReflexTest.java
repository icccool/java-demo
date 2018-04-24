package com.code.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflexTest {
	public static void main(String[] args) {
		try {
			Class<?> clz = Class.forName("com.code.reflex.Student");
			Constructor<?>[] cons = clz.getConstructors();
			Student stu = (Student) cons[0].newInstance(null);
			System.out.println(stu);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
