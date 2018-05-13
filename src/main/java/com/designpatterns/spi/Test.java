package com.designpatterns.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 有这样的一个应用场景，在某个JAR包内，有一个接口IA，然后有3个IA接口的具体实现类，分别是AIA,BIA,CIA。
 * 那么如果在该JAR包内其他的类中使用接口IA的时候，硬编码IA对象对应的具体实现类，就会导致非常不灵活。这就是SPI机制产生的场景由来。
 * 
 * @author john
 *
 */
public class Test {
	public static void main(String[] args) {
		ServiceLoader<Animal> serviceLoader=ServiceLoader.load(Animal.class);
		for (Animal animal : serviceLoader) {
			System.out.println(animal.getClass());
			animal.run();
		}

	}
}