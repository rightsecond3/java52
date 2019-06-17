package com.ch6;

public class Outer {
	int i;
	public Outer() {
		System.out.println(x);// 불가능
	}
	class Inner {
		// 그러나 이런 이너클래스를 현업에서 지향하지 않는다
		// 유지보수 등 
		int x;
		void methodA() {
			System.out.println(i);// 아빠꺼 접근가능
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
