package com.ch4;

public class ForTest2 {
//for문 안에 변수를 선언하면 for문 안에서만 사용할 수 있다.
//초기화, 조건식, 증감연산자가 없으면 무한루프에 빠질 수 있다. - 서버가 중지
//반복문 사용시 주의사항 = 무한루프에 대한 방지 코드가 필요하다.
//방지코드 : break
	public static void main(String[] args) {
		int i,j;
		for(i=0;i<3;i++) {
			if(i==1) {
				break;
			}
			for(j=0;j<3;j++) {
				System.out.println(i+" "+j);
			}
		}
	}

}
