package com.myquiz0529;

public class myQ18 {
	public static void main(String[] args) {
		 String test = "This is a test";
		 //test.split \\s : 초기는 1, 스페이스마다 카운트를 세주는 메소드
		 String[] tokens = test.split("\\s");  //test.split(\\s);
		 System.out.println(tokens.length);

	}
}
