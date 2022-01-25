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
