package com.code.proxy.jdk;

import com.code.proxy.SayHello;
import com.code.proxy.SayHelloImpl;

public class Test {
	public static void main(String[] args) {
		SayHello say = new SayHelloImpl();
		JdkProxy proxy = new JdkProxy();
		SayHello proxySay = (SayHello) proxy.bind(say);
		proxySay.say();
	}
}
