package com.ch12;

import java.util.ArrayList;

public class A {
	ArrayList<String> chatList = null;

	public A() {
		//디폴트 생성자[파라미터가 없는 생성자]는 생략 가능
		//그러나 파라미터가 있는 생성자는 생략불가
		chatList = new ArrayList<>();
		chatList.add("이해되라");
		B b = new B(this);
	}
}
