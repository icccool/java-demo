package com.code.security;

import java.io.FilePermission;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;

public class TestService {
	public void doService() {
		// doFileOperation();
		AccessController.doPrivileged(new PrivilegedAction() {
			public Object run() {
				doFileOperation();
				return null;
			}
		});

	}

	private void doFileOperation() {
		Permission perm = new FilePermission("C:/text.txt", "read");
		AccessController.checkPermission(perm);
		System.out.println("TestService has permission");
	}

}
