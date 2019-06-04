package com.quiz0529;
//생성자와 this
/*
 * this : 자기자신의 주소번지, this() : 자기자신 생성자호출
 * 생성자도 메소드 오버로딩의 규칙을 준수한다
 * 리턴타입(void, int, Question3)이 있다면 메소드이다.
 */
public class Question3 {
	String name="김유신";
	int age = 40;
	public Question3() {}
	public Question3(int age) {
		this("이순신",20);
		System.out.println("파라미터 한개짜리 호출");
//		this("김유신",20); // 에러 : this는 반드시 맨 앞에 위치해야한다
	}
	public Question3(String name, int age) {
		System.out.println("파라미터 두개짜리 호출");
	}
	public static void main(String[] args) {
		//두번째 생성자를 호출하려면 어떻게 작성해야하나
		new Question3(25);//변수 선언을 하지 않았으니까 접근이 불가함.
		Question3 q3 = new Question3(25);//변수가 있어서 접근이 가능함.
		//console : 파라미터 두개짜리 호출 - 파라미터 한개짜리 호출
		System.out.println(new Question3(25).age);//변수명이 없어서 재사용불가함.
		//위 상태에서 실행하면 객체는 몇개 생성될까요? - 3개가 생성됨.
		//메소드안에서 호출 하더라도 객체는 생성이 된다.
		//단 집어넣은 변수가 없기 때문에 접근이 불가하다.
	}

}
