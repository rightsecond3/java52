package com.ch10;
/*
 * 추상클래스보다 더 추상적이다.
 */
public interface Movable {
	final int _I=0;
	//인터페이스에서는 abstract 예약어를 생략할 수 있다.
	//추상 메소드만 지정할 수 있기 때문
	abstract void move(int x, int y);
	public void back(int x, int y);
}
