package com.ch9;
//public > protected > friendly > private
//더 넓은 것만 가능하다
public abstract class Unit {
	int x, y;
	public Unit() {
		System.out.println("Unit 디폴트 생성자 호출");
	}
	void stop() {}	
	abstract void display();

}