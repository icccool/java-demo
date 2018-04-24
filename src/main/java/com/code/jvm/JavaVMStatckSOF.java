package com.code.jvm;

/**
 * -Xss128k
 * 
 * Exception in thread "main" java.lang.StackOverflowError
 * 
 * @author WANG
 *
 */
public class JavaVMStatckSOF {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStatckSOF oom = new JavaVMStatckSOF();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println("stack length : " + oom.stackLength);
			e.printStackTrace();
		}
	}
}
