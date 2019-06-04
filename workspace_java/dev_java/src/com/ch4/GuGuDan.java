package com.ch4;

public class GuGuDan {

	public static void main(String[] args) {
		int i, j;
		for(i=2;i<10;i++) {//단수를 카운트하기 2단~9단
			for(j=1;j<10;j++) {//1부터 9까지 숫자를 카운트하기
				System.out.println(i+"X"+j+"="+i*j);		
			}//////////end of inner for
		}//////////////end of outter for
	}//////////////////end of main
}//////////////////////end of class
