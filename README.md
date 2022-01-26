1) Create a New Java Project
2) Download Spring Dependencies from [Spring Repo](https://repo.spring.io/ui/repos/tree/General/libs-release%2Forg%2Fspringframework%2Fspring%2F5.3.8%2Fspring-5.3.8-dist.zip)
3) Extract the zipped folder and copy the jars present inside spring-5.3.8-dist\spring-framework-5.3.8\libs and paste them inside lib folder
4) Add the spring jars to the build path
5) Create Shape Interface
```java
package org.skm.spring;

public interface Shape {

	public String getShapeName();
	
	public int getArea(int a, int b);
	
	public int getNumberOfSides();
	
	public int getInteriorAngle();
}

```
6) Create RectangleAreaCalculatorService
```java
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
```java
package org.skm.spring;

public class Rectangle implements Shape {

	private String shapeName;
	private int interiorAngle;
	/**
	 * Initialized using constructor injection
	 */
	private RectangleAreaCalculatorService areaCalculatorService;

	/**
	 * Initialized using setter injection
	 */
	private NumberOfSides numberOfSides;

	/**
	 * Added for constructor injection
	 * 
	 * @param areaCalculatorService
	 */
	public Rectangle(RectangleAreaCalculatorService areaCalculatorService) {
		this.areaCalculatorService = areaCalculatorService;
	}

	/**
	 * Used for Setter injection
	 * @param numberOfSides
	 */
	public void setNumberOfSides(NumberOfSides numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

	@Override
	public String getShapeName() {
		return this.shapeName;
	}

	public void setInteriorAngle(int interiorAngle) {
		this.interiorAngle = interiorAngle;
	}

	@Override
	public int getArea(int a, int b) {
		return areaCalculatorService.calculateArea(a, b);
	}
	
	@Override
	public int getNumberOfSides() {
		return numberOfSides.getNumberOfSides();
	}
	
	@Override
	public int getInteriorAngle() {
		return this.interiorAngle;
	}

}

```
10) Create applicationContext.xml like below
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- property file loader -->
	<context:property-placeholder
		location="classpath:shape.properties" />

	<!-- Define your beans here -->
	<bean id="rectangleAreaCalculatorService"
		class="org.skm.spring.RectangleAreaCalculatorService"></bean>
		
	<bean id="numberOfSides"
		class="org.skm.spring.RectangleSideService"></bean>
		
	<bean id="rectangle" class="org.skm.spring.Rectangle">
		<!-- Below is used for constructor injection -->
		<constructor-arg ref="rectangleAreaCalculatorService"></constructor-arg>
		<!-- Setter Injection is done by using property tag and we should pass 
			name and ref name property below should match with the property name defined 
			in the org.skm.spring.Rectangle -->
		<property name="numberOfSides" ref="numberOfSides"></property>
		<!-- Injecting Literal Values -->
		<property name="shapeName" value="Rectangle"></property>
		<property name="interiorAngle"
			value="${rectangle.interiorAngle}"></property>
	</bean>
</beans>
```
11) create a class with main method like below
```java
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
		System.out.println("Number of Sides:" + shape.getNumberOfSides());
		System.out.println("Interior Angle:" + shape.getInteriorAngle());
	}

}

```
