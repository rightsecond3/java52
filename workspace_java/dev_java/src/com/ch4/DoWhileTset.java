package com.ch4;

import java.util.Random;
/*
 * 랜덤한 난수 3개를 뽑아 서로 다른 수가 나오게 하는 프로그램
 */
public class DoWhileTset {

	public static void main(String[] args) {
		int first=-1;
		int second=-1;
		int third=-1;
		Random r = new Random();
		for(int i=0; i<10;i++) { //단위 테스트용 fro문
			first = r.nextInt(10);
		do {
			second = r.nextInt(10);
		}while(first==second);
		do {
			third = r.nextInt(10);
		}while(first==third||second==third); //&&냐 ||냐
		System.out.println(first+""+second+""+ third);
	}
	}
}
