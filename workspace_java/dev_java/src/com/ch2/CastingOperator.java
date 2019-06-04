package com.ch2;

public class CastingOperator {
	int i = 10;
	void methodA(double d) {
		i = (int)d;
		System.out.println("변수는 i는 "+ i + "입니다.");
	}
	public static void main(String[] args) {
		double d=3.14;
		CastingOperator co = new CastingOperator();
		co.methodA(d);
	}

}
