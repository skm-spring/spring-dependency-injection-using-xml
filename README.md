1) Create a New Java Project
2) Download Spring Dependencies from
3) Add them to lib folder
4) Add the jars to the build path
5) Create Shape Interface
```
package org.skm.spring;

public interface Shape {

	public String getShapeName();
	
	public int getArea(int a, int b);
}
```
6) Create RectangleAreaCalculatorService
```
package org.skm.spring;

public class RectangleAreaCalculatorService {

	public int calculateArea(int a, int b) {
		return a * b;
	}
}

```
7) Create Rectangle class and implement the Shape interface
8) Add RectangleAreaCalculatorService as a variable inside Rectangle class
9) Create constructor inside Rectangle class RectangleAreaCalculatorService as a parameter
```
package org.skm.spring;

public class Rectangle implements Shape {

	private RectangleAreaCalculatorService areaCalculatorService;

	public Rectangle(RectangleAreaCalculatorService areaCalculatorService) {
		this.areaCalculatorService = areaCalculatorService;
	}

	@Override
	public String getShapeName() {
		return "Rectangle";
	}

	@Override
	public int getArea(int a, int b) {
		return areaCalculatorService.calculateArea(a, b);
	}

}

```
10) Create applicationContext.xml like below
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Define your beans here -->
    <bean id="rectangleAreaCalculatorService" class="org.skm.spring.RectangleAreaCalculatorService"></bean>
    <bean id="rectangle" class="org.skm.spring.Rectangle">
    	<constructor-arg ref="rectangleAreaCalculatorService"></constructor-arg>
    </bean>
</beans>
```
11) create a class with main method like below
```
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
```
