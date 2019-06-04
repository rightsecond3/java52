package com.ch2;

public class VariableTest1 {
	//non-static타입의 변수는 static영역에서 사용불가
	//해결방법 - 인스턴스화를 하면 가능함.
	//전역변수는 초기화를 생략할 수도 있다. 이유?->생성자가 대신해주니까!
	int i=100; //전역변수이다. 다른 메소드에서도 사용이 가능하다.
	//i=100; -> 전역변수를 쓰는 곳에서는 두군데로 나눠서 초기화나 선언을 시킬수 없다
	void methodA() {
		//지역변수는 반드시 초기화를 해야됨. 안하면 컴파일 에러
		int i; //지역변수
		i=10;
		System.out.println(i); //가까이 있는 지역변수 i인 10이 출력됨 //1라인 10
	}
	//void methodA() 에러 ~> 같은이름의 메소드가 선언됬기 때문
	void methodA(int i) { //메소드의 파라미터 자리에도 지역변수를 선언할 수 있다. 메소드 선언		
		System.out.println(i); //this를쓰면 전역변수 i->아직 초기화가 되지 않앗으므로, 메소드는 호출할때 초기화가 일어난다
		System.out.println(this.i); //this(클래스)를 쓰면 전역변수 i, 아직 초기화가 되지 않앗으므로, 메소드는 호출할때 초기화가 일어난다
		methodA();
	}
	/*
	 * void methodA(String id, String pw) { 
	 *		System.out.println(i); }
	 */ 
	public static void main(String[] args) {
		//main에 static이 있기 때문에 사용할수 없다.
		VariableTest1 vt = new VariableTest1(); //heep 메모리안에 집(공간)이 생긴다. 인스턴스화
		vt.methodA();//메소드 호출하기->전역변수i를 찍음
		vt.methodA(20);//메소드 호출, vt.method(int i)
		System.out.println(vt); //@abcd1234_16진수 주소번지, TV 리모컨 같은 느낌
		System.out.println(vt.i);//전역변수
		
	}

}
