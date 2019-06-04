package com.ch2;

public class VariableTest2 {
	void methodC(double pi) {
		System.out.println("pi: "+pi);
	}
	public static void main(String[] args) {
		VariableTest2 vt2 = new VariableTest2(); //지역변수->메소드 안에서 선언하는것은 다 지역변수
		vt2.methodC(3.14);

	}

}
