package com.code.innerclz;

public class OuterClass {

	int headNum;
	int lastNum;

	public OuterClass(int headNum) {
		this.headNum = headNum;
	}

	public class InnerClz {
		public int getHeadNum() {
			return OuterClass.this.headNum;
		}
	}
}
