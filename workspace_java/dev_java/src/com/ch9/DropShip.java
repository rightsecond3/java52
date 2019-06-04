package com.ch9;

import com.ch10.Movable;

public class DropShip extends Unit implements Movable{

	void load() {
		
	}
	void unload() {
		
	}
	@Override
	void display() {
		System.out.println("나는 드랍쉽입니다.");
	}
	/*
	 * 메소드 선언시 좌중괄호, 우중괄호 있다는 것만으로도 구현으로 본다.
	 * 선언이 아니다
	 * 선언은 ; 끝났을 때가 선언이다.
	 * 아래 메소드는 Movable 인터페이스에서 선언된 추상메소드를 구현한 메소드이다.
	 * 따라서 인터페이스 안에는 구현된 부분이 없다.
	 * 구현체 클래스는 Movable이라는 인터페이스를 implements한 클래스가 구현체 클래스인 것이다.
	 */
	@Override
	public void move(int x, int y) {
		System.out.println("Dropship이 "+x+","+y+"좌표로 이동하였다.");
	}
	@Override
	public void back(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
