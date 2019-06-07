package com.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//메소드의 파라미터로 어떤 타입을 선택하는 것이 유연한 것인지?
public class MemberApp {
	//List : Interface
	public void methodA(List<String> nameList) {
		System.out.println("List 호출 성공");
	}
	//ArrayList : List의 구현체 클래스
	public void methodA(ArrayList<String> nameList) {
		System.out.println("ArrayList 호출 성공");
	}
	//Vector : List의 구현체 클래스
	public void methodA(Vector<String> nameList) {
		System.out.println("Vector 호출 성공");
	}
	public static void main(String[] args) {
		MemberApp ma = new MemberApp();
		List<String>      names  = new ArrayList<String>();
		List<String>      names2 = new Vector<String>();
		ArrayList<String> names3 = new ArrayList<String>();
		Vector<String>    names4 = new Vector<String>();
		//List타입 이기때문에 구현체 클래스의 2번 3번을 다 담을 수 있다.
		ma.methodA(names);
		ma.methodA(names2);
		//names3가 ArrayList 타입이기 때문에 ArrayList 메소드만 호출됨
		ma.methodA(names3);
		//names4가 Vector 타입이기 때문에 Vector 메소드만 호출됨
		ma.methodA(names4);
		//12~19행이 없을 경우에는 List가 다른 타입을 다 담아줘서
		//List호출 성공이라고 뜬다
	}

}
