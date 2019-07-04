package com.ch14;

public class IllegalArgumentException_1 {
	//javac 클래스명.java
	//java 클래스명 11
	public static void main(String[] args) {
		System.out.println("월 정보를 입력하세요(0부터 11로 줍니다.)");
		String smm = args[0];
		int imm = Integer.parseInt(smm);
		if(imm<0 || imm>11) {//0부터 11까지 입력하지 않은 경우
			throw new IllegalArgumentException("유효한 값이 아닙니다.");
		} else {
			System.out.println("정상 처리 하면 됨");
		}
	}
	//오른쪽 버튼 Run as -> Arguments에 번호 작성
}
