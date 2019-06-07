package com.baseball;

public class B {
	int b;
	A a = null;
	//생성자를 활용해서 객체를 주입할 수있다.
	public B(A a) {
		System.out.println("B(A a) 생성자 호출 성공");
		this.a=a;
	}
	public void methodB() {
		//생성자의 파라미터로 넘어온 a변수를 전역변수와
		//초기화(8번라인) 했으므로 13번은 정상적으로 호출 
		a.methodA();
		System.out.println("methodB() 호출성공");
	}
}
