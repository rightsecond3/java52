package com.ch8;

public class CircleArea extends Area {
	@Override
	public double area(double radius, double pi) {
		double area = radius*radius*pi;
		return area;
	}
}
