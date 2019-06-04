package com.ch7;
//제네릭 자료형 사용
import java.util.ArrayList;

public class ArrayListTest1_1 {
	//갤럭시 3대를 담을 참조변수가 필요하다.
	public ArrayList<Galaxy> setArrayList() {
		ArrayList galList = new ArrayList();
		//제네릭 자료형 사용
		ArrayList<Galaxy> galList2 = new ArrayList<Galaxy>();
		Galaxy myGal = new Galaxy("갤럭시A 시리즈");
		Galaxy herGal = new Galaxy("갤럭시S 시리즈");
		Galaxy yourGal = new Galaxy("갤럭시노트 시리즈");
		
		boolean isMyGal = galList2.add(myGal);
		if(isMyGal) System.out.println("내 갤럭시 담기성공");
		else System.out.println("내 갤럭시 담기실패");
		boolean isherGal = galList2.add(herGal);
		if(isherGal) System.out.println("그녀의 갤럭시 담기성공");
		else System.out.println("그녀의 갤럭시 담기실패");
		boolean isyourGal = galList2.add(yourGal);
		if(isyourGal) System.out.println("너의 갤럭시 담기성공");
		else System.out.println("너의 갤럭시 담기실패");

		return galList2;
	}
	public static void main(String[] args) {
		ArrayListTest1_1 al = new ArrayListTest1_1();
		//메소드의 리턴타입으로 주소번지를 받아온다.
		ArrayList<Galaxy> galList = al.setArrayList();
		//개선된 for문을 사용하여 반복처리
		for(Galaxy gal:galList) { //Object 객체타입
			//ArrayList안에 담긴 타입이 Galaxy이므로 타입을 맞춘다.
			//주소번지를 활용하여 전역변수를 출력한다.
			System.out.println(gal.name);
		}
		System.out.println("============================");
		double d = 3.14;
		int j = (int)d;
		for(int i=0;i<galList.size();i++) {
			Galaxy gal2 = galList.get(i);
			String name = gal2.name;
			System.out.println(name);
			
		}
	}

}