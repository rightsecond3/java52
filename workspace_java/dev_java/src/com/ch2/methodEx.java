package com.ch2;
//1부터 10까지 더해주는 메소드를 생성해보고 해당 메소드를 호출해보자
public class methodEx {
	int hap=0; //전역변수
	int i;
	
	void cal() {
		for(i=1; i<=10; i++) {
			hap=hap+i; //지역변수
		}
		System.out.println("1부터 10까지의 합은 "+hap);
		System.out.println("현재 i의 숫자는  "+i);		
		//hap=0; 
	}
	void cal2() {
		cal(); // 스태틱 밖에서 메소드 호출
			   // 전역변수로 선언하여 hap값이 초기화되지 않아 결과가 110???
	}
	public static void main(String[] args) {
		methodEx mycal = new methodEx(); //인스턴스 생성, heep에 메모리가 저장
		mycal.cal(); //메소드 호출
		mycal.cal2();
		int hap1=0;
		int j;
		for(j=1; j<=10; j++) {
			hap1=hap1+j;
		}
		System.out.println("2번째 1부터 10까지의 합은 "+hap1);
		for(j=1; j<=10; j++) {
			hap1=hap1+j;
		}
		System.out.println("2번째 1부터 10까지의 합은 "+hap1);
	}

}