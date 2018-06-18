package com.code.interview.init;


/***
 * 这两种方法有什么区别呢？
 * 首先：这两个方法一个是虚拟机在装载一个类初始化的时候调用的（clinit）。另一个是在类实例化时调用的（init）
 * 
 * (clinit) 搜集  1.所有类变量的赋值动作   2.和静态块  -->按顺序
 * 
 * @author wang
 *
 */
class Clinit {
    public Clinit() {
    	System.out.println("静态变量");
    }
}
 
public class ClinitTest {
	
	//<clinit>()
	static {
    	System.out.println("静态块"); 
	}
	//<clinit>()
	private static  Clinit c = new Clinit();
	
	//====================================================
	//<init>()
	private Clinit c2 = new Clinit();
	
	//<init>()
	{
        System.out.println( "初始化块" );
    }
	
    public static void main(String[] args) {
    	new ClinitTest();
    }
}