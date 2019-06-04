package com.ch2;

public class VariableInitial1 {
	int a1, a2, a3 = 0;
	void initial() {
		a1 = 7;
		a2 = 14;
		a3 = 21;
	}
	void methodA() {
		int account;
		account = a1+a2+a3;
		System.out.println("a1+a2+a3="+account+" 입니다.");
	}
	public static void main(String[] args) {
		VariableInitial1 vl1 = new VariableInitial1();
		vl1.initial();
		vl1.methodA();
	}
}
