package com.ch2;

import com.ch9.Car;

public class Sonata extends Car {
	int wheelNum = 4; //전역변수
	int speed = 0; //전역변수
	String carColor = "빨강";
	
	public Sonata() {}
	
	void move(int i) {//int i는 지역변수
		speed = speed+1; //후에 for문을 통해 speed를 높일 수 잇다.
		System.out.println("지역변수 i는 "+i);
	}
	/*
	 * void move() {
	 *
	 *	speed = speed+1;
	}
	void stop() {
		speed = speed-1;
	} //지역변수로 사용할경우 {}안에 하나의 변수만 기억할 수 있기 때문에 전역변수로 클래스 전역에 사용할 수 있어야하기 위함
	 */
	public static void main(String[] args) {
		//insert here -move 메소드 호출
		Sonata mycar = new Sonata(); // Sonata 클래스 생성
		//너 버퀴수가 몇개니?
		mycar.move(2);
		System.out.println("차바퀴수"+mycar.wheelNum);
		System.out.println("차색깔"+mycar.carColor);
		System.out.println("차속도"+mycar.speed);
		System.out.println("유승기의 차의 바퀴수는 "+mycar.wheelNum+"이고 색깔은 "+mycar.carColor+"이며 "
				+ "현재 속도는 "+mycar.speed+"입니다" );
		 // 인스턴스 이름 .메소드이름
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
