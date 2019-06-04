package com.ch4;
/*
 * 두 개의 정수를 입력 받아서
 * 두개의 정수 사이에 있는 3의 배수는 몇개 인지
 * 출력하는 프로그램을 작성하시오.
 * 
 */

import java.util.Scanner;

public class quiz02 {

	public static void main(String[] args) {
		System.out.println("첫번째 숫자를 입력하시오");
		Scanner scan1 = new Scanner(System.in);
		int one = scan1.nextInt();
		System.out.println("두번째 숫자를 입력하시오.");
		Scanner scan2 = new Scanner(System.in);
		int two = scan2.nextInt();
		int i=0;
		int gaesu = 0;
		for(i=one+1; i<two; i++) {
			if(i%3==0) {
				gaesu++;
			}
		}System.out.println("두 정수사이의 3의 배수는 "+gaesu+"개 입니다.");
	}

}
