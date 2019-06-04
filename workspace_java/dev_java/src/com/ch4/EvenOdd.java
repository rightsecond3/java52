package com.ch4;

public class EvenOdd {

	public static void main(String[] args) {
		int i=0, OddSum=0, EvenSum=0;
		for(i=1;i<=10;i++) {
			if(i%2==1) {
				OddSum+=i;
			}else if(i%2==0) {
				EvenSum+=i;				
			}
		}
		System.out.println("1부터 10까지 홀수의 합은 "+OddSum+"입니다.");
		System.out.println("1부터 10까지 짝수의 합은 "+EvenSum+"입니다.");
	}

}
