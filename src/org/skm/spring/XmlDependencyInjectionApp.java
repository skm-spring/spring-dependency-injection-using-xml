package org.skm.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDependencyInjectionApp {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {
			testRectangle(classPathXmlApplicationContext);
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	private static void testRectangle(ClassPathXmlApplicationContext classPathXmlApplicationContext) {
		Shape shape = classPathXmlApplicationContext.getBean("rectangle", Shape.class);
		System.out.println(shape.getShapeName());
		System.out.println(shape.getArea(3, 5));
	}

}
