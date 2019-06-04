package com.ch8;
/*
 * 자바의 특징 - 자바답게 코딩을 할까?? - 재사용성과 다형성
 * 인스턴스화 할때 선언부와 생성부의 이름이 다를 수 있다.
 * 기억할 것. - 생성부에 오는 클래스이름으로 객체가 생성된다.
 */
public class SupNSubSumulation {
	
	public static void main(String[] args) {
	//선언부의 타입과 생성부의 타입이 다를 수 있다.
	//이 때 다형성을 기대할 수 있다.
	//만일 선언부의 타입과 생성부의 타입이 같을 땐 다형성은 불가
	Sup sup1 = new Sub();
	Sub sub = new Sub();
	sup1.methodA();
	//Sup타입의 변수이고 실제로 생성된 객체는 Sub이다.
	sup1.methodB(); 
	sup1 = (Sub)sup1; // 이 코드로 위 코드 해결 불가능
	sub.methodA();
	sub.methodB();
	}
}
