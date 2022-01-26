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
