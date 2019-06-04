package com.ch4;
/*
 * 1부터 100까지 세면서 5의 배수이면 FIZZ라고 출력
 * 7의 배수이면 BUZZ라고 출력하고
 * 5와 7의 공배수(EX.35, 70)이면 FIZZBUZZ를 출력
 * 그 외 나머지 수는 그냥 출력한다. 
 */
public class FizzBuzzSwitch {

	public static void main(String[] args) {
		int cnt;
		for(cnt=1; cnt<101; cnt++) {
			switch(cnt%35) {
			case 0 :
			System.out.println("FizzBuzz");
			break;
			case 5: case 10: case 15: case 20: case 25: case 30: 
		    System.out.println("Fizz");
		    break;
			case 7: case 14: case 21: case 28:
			System.out.println("Buzz");
			break;
		    default : 
		    	System.out.println(cnt);
			}
		}
	}

}
