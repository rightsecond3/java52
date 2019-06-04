package com.ch4;

import java.util.Random;

public class Test1 {
	int i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
	int is[] =new int[10];
	int hap1=0; //양수의 합을 담을 변수
	int hap2=0; //음수의 합을 담을 변수
	//임의의 숫자를 채번하는 메소드 선언하기
	void randomValue() {
		Random r = new Random();
		i1 = r.nextInt(21)-10;
		i2 = r.nextInt(21)-10;
		i3 = r.nextInt(21)-10;
		i4 = r.nextInt(21)-10;
		i5 = r.nextInt(21)-10;
		i6 = r.nextInt(21)-10;
		i7 = r.nextInt(21)-10;
		i8 = r.nextInt(21)-10;
		i9 = r.nextInt(21)-10;
		i10 = r.nextInt(21)-10;
	}
	//양수의 합을 구하는 메소드 선언
	int plusHap() {
		if(i1>=0) {
			hap1=hap1+i1;			
		}
		if(i2>=0) {
			hap1=hap1+i2;			
		}
		if(i3>=0) {
			hap1=hap1+i3;			
		}
		if(i4>=0) {
			hap1=hap1+i4;			
		}
		if(i5>=0) {
			hap1=hap1+i5;			
		}
		if(i6>=0) {
			hap1=hap1+i6;			
		}
		if(i7>=0) {
			hap1=hap1+i7;			
		}
		if(i8>=0) {
			hap1=hap1+i8;			
		}
		if(i9>=0) {
			hap1=hap1+i9;			
		}
		if(i10>=0) {
			hap1=hap1+i10;			
		}
		return hap1;
	}
	//음수의 합을 구하는 메소드 선언
	int minusHap() {
		if(i1<0) {
			hap2=hap2+i1;			
		}
		if(i2<0) {
			hap2=hap2+i2;			
		}
		if(i3<0) {
			hap2=hap2+i3;			
		}
		if(i4<0) {
			hap2=hap2+i4;			
		}
		if(i5<0) {
			hap2=hap2+i5;			
		}
		if(i6<0) {
			hap2=hap2+i6;			
		}
		if(i7<0) {
			hap2=hap2+i7;			
		}
		if(i8<0) {
			hap2=hap2+i8;			
		}
		if(i9<0) {
			hap2=hap2+i9;			
		}
		if(i10<0) {
			hap2=hap2+i10;			
		}
		return hap2;
	}
	//전역변수로 선언하면 메소드에서 사용하고 싶을때 언제든 사용가능
	//만일 지역변수로 선언했다면 메소드의 파라미터로 넘겨주어야 유지된다
	void printRandomValue() {
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
		System.out.println(i7);
		System.out.println(i8);
		System.out.println(i9);
		System.out.println(i10);
	}
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
