package com.ch8;

public class Son extends Father{
	String book = "성경책";
	public Son() {
		System.out.println("Son 디폴트 생성자 호출");
	}
	public Son(String book) {
		this.book=book;
	}
	@Override
	public void walk() {
		System.out.println("아빠는 걷는 중....");
	}
	//메소드 오버 로딩
	public void walk(int i) {
		System.out.println("아빠는 뛰는 중....");
	}
}