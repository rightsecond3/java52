package com.baseball;

public class A {
	int a;
	//methodB()를 클래스 A에서 호출할 수 있다.
	//누릴 수 있다. 활용할 수 있다.
	B b = new B(this);
	public A() {
		b.methodB();
	}
	public void methodA() {
		System.out.println("methodA() 호출성공");
	}
	public static void main(String[] args) {
		A a= new A();
		a.methodA();
	}
}