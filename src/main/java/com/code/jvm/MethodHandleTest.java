package com.code.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/***
 * MethodHandle <br>
 * 它是可对直接执行的方法（或域、构造方法等）的类型的引用，或者说，它是一个有能力安全调用方法的对象。换个方法来说，
 * 通过句柄我们可以直接调用该句柄所引用的底层方法。从作用上来看，方法句柄类似于反射中的Method类，但是方法句柄的功能更加强大、使用更加灵活、性能也更好
 * 
 * @author wang
 *
 */
public class MethodHandleTest {
	
	static class ClassA{
		public void println(String s) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable {
		Object obj = System.out;
//		Object obj = new ClassA();
		getPrintMethodHandle(obj).invokeExact("12234");
	}
	
	
	private static MethodHandle getPrintMethodHandle(Object receiver) throws NoSuchMethodException, IllegalAccessException {
		MethodType mt = MethodType.methodType(void.class, String.class);
		return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
	}
	
}
