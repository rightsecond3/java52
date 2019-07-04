package com.ch12;

public class NoteBook extends Object {
	@Override
	public String toString() {
		return "toString메소드 재정의";
	}
	public static void main(String args[]) {
		NoteBook nb = new NoteBook();
		System.out.println(nb);
		System.out.println(nb.toString());
	}
}
