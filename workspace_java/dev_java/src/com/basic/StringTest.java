package com.basic;

public class StringTest {

	public static void main(String[] args) {
		String s = new String("hello");
		s.replace('e', 'o'); //알파벳 e를 o로 바꿔줘라
		System.out.println(s);
		s = s.replace('e', 'o'); //알파벳 e를 o로 바꿔줘라
		System.out.println(s);
		// console : hello ,, hollo
		s = s+"world";
		s = s+"!!!!";
		System.out.println(s);
	}

}