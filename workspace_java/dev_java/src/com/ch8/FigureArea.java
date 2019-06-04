package com.ch8;

public class FigureArea {
	//삼각형의 면적을 구해줄래?
	public double area(int t_width, int t_height) {
		double t_area = (t_width*t_height)/2;
		return t_area;
	}
	//사각형의 면적을 구해볼까?
	//Ctrl+Space를 써도 파라미터의 타입을 확실히 맞춰줘야 해당 메소드로 이동한다.
	public double area(double r_width, double r_height) {
		double r_area = r_width * r_height;
		return r_area;
	}
	//원의 면적은 얼마니?
	public double area(double radius) {
		double c_area = 3.14*(radius*radius);
		return c_area;
	}
}
