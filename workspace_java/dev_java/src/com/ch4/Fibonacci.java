package com.ch4;
/*
 * 피보나치 수열
 * 1 1 2 3 5 8 13 ...
 * a1항에서 a10번째 항까지 출력하는 프로그램을 작성하시오
 */
public class Fibonacci {

	public static void main(String[] args) {
		int i=1; //첫번째 항
		int j=1; //두번째 항
		int k=0; //세번째 항
		for(int cnt=1; cnt<=10; cnt++) {
			k=i+j;
			i=j;
			j=k;
			System.out.println("피보나치수열 "+cnt+" 항은  : "+i);
		}
		
	}

}
