package com.ch2;

public class Question5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		int hap=0;
		for(i=1;i<=10;i++)	{
			hap=hap+i;
			System.out.println("hap==> "+hap);
		}
		//아래는 for문 밖에 있어요
		System.out.println("1부터 10까지의 합은 "+hap);
		hap=0;
		for(i=1;i<=5;i=i+2) {
			hap=hap+i;
		}
		System.out.println("1부터 5까지 홀수의 합은 "+hap);
	}

}
