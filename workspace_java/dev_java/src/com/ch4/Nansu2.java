package com.ch4;

import java.util.Random;

/*
 * -10에서 10사이의 정수 10개를 랜덤하게 채번하여
 * 음수와 양수의 합계를 구하는 프로그램을 작성하시오
 * 9, -2, -3, 8, 0, -3, -8, -6, -2, 0
 * 음수합 : -24
 * 양수합 : 17
 * 5장 - 클래스
 * 인스턴스화를 왜 해야하는가?
 * 클래스 구성요소 2가지가 뭐지?
 * 1)변수 - field
 * 2)메소드 - method
 * 변수와 메소드는 소유하고 있는 클래스 이름이 있다.
 * 자바에서 제공되는 클래스가 있다.
 * 변수나 메소드를 재사용하기 위해서는 반드시 인스턴스화 해야함.
 * 클래스 타입
 */
public class Nansu2 {

	public static void main(String[] args) {
		Random r = new Random();
		int cnt = 1;
		int EmSum = 0;
		int YangSum = 0;
		for(cnt=1; cnt<11; cnt++) {
			int nansu = r.nextInt(19)-9; //0~18까지의 수에서 -9하면 -9~9까지가 나온다.
			System.out.println(nansu);
			if(nansu>0) {
				YangSum += nansu;
			}else if(nansu<0) {
				EmSum += nansu;
			}
		}
		System.out.println("음수합 : "+EmSum);
		System.out.println("양수합  : "+YangSum);
	}

}
