package com.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListTest {
	public static void methodA(List<String> list) {
		list.add("바나나");
		for(String fruit : list) {
			System.out.println(fruit);
		}
	}
	public static void methodB(ArrayList<String> list) {		
	}
	public static void methodC(Vector<String> list) {		
	}
	public static void main(String[] args) {
		//싱글 스레드에서 안전함. - 대신 읽고 쓰기 속도는 빠르다.
		ArrayList<String> deptList = new ArrayList<String>();
		//멀티 스레드에서 안전함. - 대신 읽고 쓰기가 느리다.
		Vector<String> v_deptList = new Vector<String>();
		/*
		 * List 인터페이스의 구현체 클래스는 ArrayList, Vector, LinkedList...
		 */
		List<String> a_list = new ArrayList<String>();
		a_list.add("사과");
		a_list.add("딸기");
		a_list.add("수박");
		ListTest.methodA(a_list);
		//ListTest.methodB(a_list);
		//ListTest.methodC(a_list);
		
		
		List<String> v_list = new Vector<String>();
		v_list.add("오렌지");
		v_list.add("망고");
		v_list.add("파인애플");
		ListTest.methodA(v_list);
	}

}