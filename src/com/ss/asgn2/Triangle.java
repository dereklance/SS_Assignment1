package com.ss.asgn2;

public class Triangle implements Shape {
	private double base, height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		return 0.5 * base * height;
	}

	@Override
	public void display() {
		System.out.println("Displaying triangle");

	}

}
