package com.ch7;

import java.util.Random;

public class Test03 {
	//100개의 정수를 담을 수 있는 1차배열 생성
	int a[] = new int[20]; //단위테스트를 위해 10개만 생성해본다
	//카운트를 셀 cnt 배열 선언
	int cnt[] = new int[10];
	//분포도를 측정할 메소드 선언 1000번실행
	public void ranking() {
		//i는 100개의 정수를 검사하는 변수
		for(int i=0;i<a.length;i++) {
			//j는 cnt배열의 인덱스값과 같을 경우 그 인덱스의 값을 1씩 올려주어 카운트를 세는 변수
			for(int j=0;j<cnt.length;j++) {
				if(a[i]==j) {
					cnt[j]++;
				}
			}
		}
	}
	//분포도를 측정할 메소드2 100번실행
	public void ranking2() {
		for(int i=0; i<a.length; i++) {
			cnt[a[i]]++;
		}
	}
	//랜덤값을 넣을 메소드 생성
	public void arrayInit() {
		Random r = new Random();		
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(10);
			System.out.println(a[i]);
		}
	}
	//프린트를 할 메소드 생성
	public void Print() {
		for(int i=0;i<cnt.length;i++) {
			System.out.println(i+"의 빈도는 "+cnt[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Test03 ts = new Test03();
		ts.arrayInit();
		ts.ranking2();
		ts.Print();
	}
}
