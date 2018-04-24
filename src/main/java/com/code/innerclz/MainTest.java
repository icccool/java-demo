package com.code.innerclz;

import com.code.innerclz.OuterClass.InnerClz;

public class MainTest {
	public static void main(String[] args) {

		OuterClass out = new OuterClass(9);
		InnerClz inner = out.new InnerClz();
		int head = inner.getHeadNum();
		System.out.println(head);

	}
}
