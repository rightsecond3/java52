package com.ch4;

import java.util.Random;

public class Test1_Ver2 {
	int is[] =new int[10];
	int hap1=0; //양수의 합을 담을 변수
	int hap2=0; //음수의 합을 담을 변수
	
	//임의의 숫자를 채번하는 메소드 선언하기
	//배열을 사용해서 초기화 할 수 있으므로 for문 사용하였다.
	void randomValue() {
		Random r = new Random();
		for(int i=0; i<10;i++) {
			is[i] = r.nextInt(21)-10;
		}
	}////end of randomValue
	
	//양수의 합을 구하는 메소드 선언
	int plusHap() {
		for(int i=0;i<10;i++) {
			if(is[i]>=0) {// 너 양수니?
				hap1+=is[i];
			}
		}
		return hap1;
	}/////////////end of plusHap
	
	//음수의 합을 구하는 메소드 선언
	int minusHap() {
		for(int i=0;i<10;i++) {
			if(is[i]<0) {
				hap2+=is[i];
			}
		}
		return hap2;
	}///////////////end of minusHap
	
	//전역변수로 선언하면 메소드에서 사용하고 싶을때 언제든 사용가능
	//만일 지역변수로 선언했다면 메소드의 파라미터로 넘겨주어야 유지된다
	void printRandomValue() {
		for(int i=0;i<10;i++) {
			System.out.println(is[i]);
		}
	}///////////////////////end of printRandomValue
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.randomValue();
		t1.printRandomValue();
		t1.plusHap();
		t1.minusHap();
		t1.hap1=t1.plusHap(); // 전역변수니까 초기화 해줘야함
		t1.hap2=t1.minusHap();// 전역변수니까 초기화 해줘야함
		System.out.println("양수의 합은"+t1.hap1);
		System.out.println("음수의 합은"+t1.hap2);
		System.out.println("양합"+t1.plusHap());

	}
}