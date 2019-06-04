package com.ch9;

import com.ch10.Movable;

public class StarCraftTest {

	public static void main(String[] args) {
		Unit myMarin = new Marine();
		Unit myTank = new Tank();
		Unit myDropShip = new DropShip();
//		Unit unit = new Unit(); 불가능
		//그렇다면 생성자는 어떻게 호출되는 걸까?
		//오버라이드인지 판별하려면 부모 클래스를 먼저 스캔해야하지 않을까?
		//결론 : 자식 클래스(하위 클래스) 생성자가 호출되면
		//      상속 관계에 있는 상위 생성자가 먼저 호출된다.
		//아래에서 세개의 유닛이 모두 같은 메소드를 호출하였다.
		//그런데 결과는 각각 다르다. - 다형성
		myMarin.display();
		myTank.display();
		myDropShip.display();
		/*
		 * 추상 클래스와 인터페이스는 반드시 구현체 클래스를 갖는다.
		 */
		Movable mov = new DropShip();
		mov.move(10, 10);
	}
}