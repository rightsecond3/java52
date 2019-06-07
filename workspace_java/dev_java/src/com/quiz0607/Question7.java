package com.quiz0607;
//변수의 적용 범위
public class Question7 {
	public static void main(String[] args) {
		int x = 5;
		Question7 p = new Question7();
		p.doStuff(x);
		System.out.println("main x = "+x);
	}
	void doStuff(int x) {
		//doStuff의 지역변수 x
		//메인문의 x와 다른 변수이다
		System.out.println("doStuff x = "+ x++);
	}
}
