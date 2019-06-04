package com.myquiz0529;

public class myQ17 {

	 public static void go(short n) {System.out.println("short");//원시형타입}
	 public static void go(Short n) {System.out.println("SHORT");//클래스타입}
	 public static void go(Long n) {System.out.println("LONG"); }
	 public static void main(String [] args) {
	 Short y= 6;  //클래스 타입
	 int z=7;  
	 go(y);  
//	 go(z);  
	 }

}
