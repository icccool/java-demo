package com.framework.spring.executesubclass.withabstractclass;

import java.io.FileNotFoundException;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.framework.spring.SpringUtil;

/**
 *
 * 子类返回车品牌信息, 具体实现由AbstracCar实现
 * 
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
				SpringUtil.SPRING_BASE_CLASSPATH + "/executesubclass/withabstractclass/beans.xml");		
		System.out.println(ctx.getBean(Benz.class));
		Map<String, Car> map = ctx.getBeansOfType(Car.class);
		for (Map.Entry<String,Car> es : map.entrySet()) {
			System.out.println(es.getKey());
			Car car = es.getValue();
			car.didi();
		}
		//ctx.close();
	}
}
