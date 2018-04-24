package com.code.jvm;

/**
 * 
 *  JVM最多能启动的线程数参照公式： (MaxProcessMemory - JVMMemory – ReservedOsMemory) / (ThreadStackSize) = Number of threads<br>
 * 
 *  MaxProcessMemory : 进程的最大寻址空间<br>
 *  JVMMemory : JVM内存<br>
 *  ReservedOsMemory : 保留的操作系统内存，如Native heap，JNI之类，一般100多M<br>
 *  ThreadStackSize : 线程栈的大小，jvm启动时由Xss指定<br>
 *  创建线程太多导致栈溢出, 解决办法 减小栈的大小<br>
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
