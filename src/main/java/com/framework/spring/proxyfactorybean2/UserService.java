package com.framework.spring.proxyfactorybean2;

public class UserService implements IUserService {

	public void addUser(String name, int age) {
		// 省略诸如操作数据库等复杂的逻辑操作
		System.out.println("add user " + name + " successfully");
	}

	public void deleteUser(String name) {
		// 省略诸如操作数据库等复杂的逻辑操作
		System.out.println("deleted one user named " + name);
		//throw new RuntimeException("这是特意抛出的异常信息！");
	}
}