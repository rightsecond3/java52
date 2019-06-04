package com.ch4;
/*
 * 1부터 100까지 세면서 5의 배수이면 FIZZ라고 출력
 * 7의 배수이면 BUZZ라고 출력하고
 * 5와 7의 공배수(EX.35, 70)이면 FIZZBUZZ를 출력
 * 그 외 나머지 수는 그냥 출력한다. 
 */
public class FizzBuzz {

	public static void main(String[] args) {
		int i=0;
		for(i=1;i<=100;i++) {
			if(i%5==0) {
				System.out.println("Fizz!");
			}else if(i%7==0) {
				System.out.println("Buzz!");
			}else if(i%(5*7)==0) {
				System.out.println("FizzBuzz!");
			}else {
				System.out.println(i);
			}
		}
	}
}
