package com.ch8;

public class FatherSimulation {

	public static void main(String[] args) {
		Father fa = new Father();
		Son mySon = new Son();
		System.out.println(mySon.book);
		//기존에 가리키던 객체를 재생성하기 위해서  null로 초기화 한 후
		mySon = null;//기존에 참조하던 객체는 Candidate상태로 빠짐
		//다시 생성하였음. - 이때 파라미터를 갖는 생성자를 호출함
		//그러면 생성자 내부에서 멤버변수 book이 다시 초기화됨.
		mySon = new Son("Oracle 프로그래밍");
		//출력해보면 성경책에서 Oracle 프로그래밍으로 바뀐것을 확인할 수 있음.
		System.out.println(mySon.book);
		fa.walk();
		mySon.walk();
		mySon.walk(1);
	}

}