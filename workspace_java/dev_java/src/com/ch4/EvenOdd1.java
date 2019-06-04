package com.ch4;

public class EvenOdd1 {

	public static void main(String[] args) {
		int i=0, sum=0;
		for(i=1;i<=10;i++) {
			if(i%2==1) { // 너 홀수니?
				sum+=i;
			}/////////end of if
		}/////////////end of for
		System.out.println("1부터 10까지 홀수의 합은 "+sum+"입니다.");
		sum=0; // sum의 값이 짝수의 합에 영향을 줄수 있으니 다시 초기화 시킴
		for(i=1; i<=10; i++) { // 너 짝수니?
			if(i%2==0) {
				sum+=i;
			}/////////end of if
		}/////////////end of for
		System.out.println("1부터 10까지 짝수의 합은"+sum+"입니다.");
	}/////////////////end of main
}/////////////////////end of EvenOdd1
