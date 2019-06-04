package com.ch8;

public class TriangleArea extends Area {
	@Override
	public double area(double weight, double height) {
		double area = weight*height/2;
		return area;
	}

}
