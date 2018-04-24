package com.code.security;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ServiceCentreMain {

	public static void main(String[] args) {
		ServiceCentreMain service = new ServiceCentreMain();
		service.loadService();
	}

	public void loadService() {
		URL[] urls;
		try {
			urls = new URL[] { new URL("file:D:/EclipseEE/java/lib/test-service.jar") };
			URLClassLoader loader = new URLClassLoader(urls);
			final Class<?> clz = loader.loadClass("com.code.security.TestService");
			Object obj = clz.newInstance();
			Method m = clz.getMethod("doService");
			m.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
