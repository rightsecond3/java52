package com.quiz0607;
//Question2
//클래스의 형 변환
interface Foo{}
class Alpha implements Foo{
}
class Beta extends Alpha{
}
public class Delta extends Beta {

	public static void main(String[] args) {
		Beta x = new Beta();
		Alpha a = x;
		//Foo의 구현체 클래스인 Alpha 타입이 와야함. 
		//java.lang.ClassCastException 런타임 에러
		Foo f = (Delta)x;
		Foo f = (Alpha)x;
		Beta b = (Beta)(Alpha)x;
	}
}