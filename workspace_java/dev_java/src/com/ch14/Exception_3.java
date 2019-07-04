package com.ch14;

public class Exception_3 {
	void methodA(String temp) {
		System.out.println("methodA 호출");
		//Integer.parseInt는 "123"을 int 123으로 바꿔주는 메소드
		int x = Integer.parseInt(temp);
		//값이 맞든 아니든 무조건 예외를 일으키는 코드
		throw new NumberFormatException();
	}
	/*
	 * try~catch블록은 예외상황이 발생했을 경우에만 효과가 있다.
	 * 예외상황이 없다면 있으나 마나한 코드
	 */
	public static void main(String[] args) {
		Exception_3 exc1 = null;
		try {
			exc1 = new Exception_3();
			exc1.methodA("123");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("후행 코드들도 실행 기회를 갖는다");
	}

}
