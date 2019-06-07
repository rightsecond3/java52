package com.quiz0607;

public class Father {
	public void methodA() {
		System.out.println("Father method 호출 성공");
	}
	public static void main(String args[]) {
		Father fa1 = new Father();
		//타입은 Father이지만 실제로 가리키는 곳은 Son
		Father fa2 = new Son();
		Son so2 = new Son();
		fa1.methodA();
		fa2.methodA();
		so2.methodA();
		//java.lang.ClassCastException
		//부모의 객체가 자식의 객체에 들어갈 수 없다.
		//큰타입이 더 작은 타입에 들어 갈 수없다.
		so2 = (Son)fa1; //so2 = new Father();
		so2 = new Son();
		so2=  (Son)fa2;
		//아빠한테 상속받은 methodB가 아니기 때문에 쓸 수 없다.
		//부모 타입으로 선언한 변수로 호출할 수 있는 메소드는 부모에도 있고 자녀에도 있어야한다
		//부모한테 없고 자녀한테만 있는 것은 에러
		fa2.methodB();
		
	}
}
class Son extends Father{
	@Override
	public void methodA() {
		System.out.println("Son methodA 호출 성공");
	}
	public void methodB() {
		System.out.println("Son methodB 호출 성공");
	}
}