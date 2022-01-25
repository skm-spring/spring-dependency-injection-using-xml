# Create Java Project
# Add Spring Dependencies to build path
# Create Shape Interface
# Create Rectangle class and implement the Shape interface
# Create RectangleAreaCalculatorService
# Add RectangleAreaCalculatorService as a variable inside Rectangle class
# Create constructor inside Rectangle class RectangleAreaCalculatorService as a parameter
# Create applicationContext.xml like below
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