package com.ss.asgn2;

public class Circle implements Shape {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public void display() {
		System.out.println("Displaying circle");

	}
}
