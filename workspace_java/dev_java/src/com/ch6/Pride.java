package com.ch6;
class Sorento {
	Sorento(Pride herCar) {
		herCar.speed = 150;
	}
}
public class Pride {
	int speed=0;
	public Pride() {
		//전변 speed에 100을 초기화
		//그리고 Sorento를 인스턴스화 할 때 생성자의 파라미터로 this를 넘김
		speed = 100;
		//아래 this는 Pride의 주소번지를 가짐
		//Sorento와 Pride간의 객체 협력을 위한 인스턴스화임.
		//또 다른 말로 바꾸면 Pride 객체안에서 Sorento객체를 주입했다고도 함.
		Sorento himCar = new Sorento(this); // this -> Pride
	}
	public static void main(String[] args) {
		//Pride를 인스턴스화 하면 Pride 생성자를 호출합니다.
		Pride herCar = new Pride();
		System.out.println(herCar.speed);
	}

}
