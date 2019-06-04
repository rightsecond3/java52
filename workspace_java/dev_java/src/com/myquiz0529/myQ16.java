package com.myquiz0529;

public class myQ16 {
	public static void go(Long n) {
		System.out.println("Long ");
	}
	public static void go(Short n) {
		System.out.println("Short");
	}
	public static void go(int n) {
		System.out.println("int");
	}
	public static void main(String [] args) {
	short y= 6;//short는 int로 자동 형전환된다.
	long z= 7;  
	go(y); 
	go(z); 
	}

}
