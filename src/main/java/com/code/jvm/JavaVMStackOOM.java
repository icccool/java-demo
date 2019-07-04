package com.code.jvm;

/**
 *  测试jvm参数
 *
 *  创建线程导致内存溢出
 *
 *  1. JVM最多能启动的线程数参照公式： (MaxProcessMemory - JVMMemory – ReservedOsMemory) / (ThreadStackSize) = Number of threads<br>
 *
 *   其中：MaxProcessMemory 指的是一个进程的最大内存
 *        JVMMemory         JVM内存
 *        ReservedOsMemory  保留的操作系统内存
 *        ThreadStackSize      线程栈的大小
 *
 * @author WANG
 *
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while (true) {
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
