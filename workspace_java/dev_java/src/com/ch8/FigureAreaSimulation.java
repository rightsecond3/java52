package com.ch8;

public class FigureAreaSimulation {

	public static void main(String[] args) {
		FigureArea fa = null;
		fa = new FigureArea();
		//원
		double c_area = fa.area(10);
		System.out.println(c_area);
		//삼각형
		double t_area = fa.area(10, 10);
		System.out.println(t_area);
		//사각형
		double r_area = fa.area(10d, 10.0);
		System.out.println(r_area);
	}

}
