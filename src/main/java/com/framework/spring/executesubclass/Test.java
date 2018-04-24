package com.framework.spring.executesubclass;

import java.io.FileNotFoundException;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.framework.spring.SpringUtil;

/**
 *
 * 获得某个接口的所有实现类
 * @author John
 *
 */
public class Test {
	// 初始log4j
	static {
		try {
			Log4jConfigurer.initLogging("classpath:log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				SpringUtil.SPRING_BASE_CLASSPATH + "/executesubclass/beans.xml");
		Map<String, Car> map = ctx.getBeansOfType(Car.class);
		for (Map.Entry<String,Car> es : map.entrySet()) {
			System.out.println(es.getKey());
			es.getValue().didi();
		}
		ctx.close();
	}
}
