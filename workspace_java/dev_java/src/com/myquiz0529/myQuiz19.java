package com.myquiz0529;

public class myQuiz19 {
	public static void main(String[] args) {
		 String test= "a1b2c3";
		 String[] tokens = test.split("\\d");//data형만 추출해주는 \\d
		 for(String s: tokens) System.out.print(s +" ");
	}
}
