package com.ch2;

public class MoonWeight {

	public static void main(String[] args) {
		//지구의 몸무게를 담을 변수 선언해 볼까?
		int earth_weight = 100;
		String unit = "kg";
		double moon_weight = 0.0;		
		double a=17f;
		double b=100f;
		//int 나누기 int는 정수이기 때문에 double로 선언해야한다.
		//달의 몸무게를 계산해서 출력하시오.
		moon_weight=earth_weight*(a/b);
		System.out.println("달의 몸무게는 "+moon_weight+unit+"입니다");
		System.out.println(earth_weight*(a/b));
		
	}
	//insert here
	//eart_weight*0.17

}
