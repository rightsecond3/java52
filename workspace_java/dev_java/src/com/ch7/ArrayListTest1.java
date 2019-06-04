package com.ch7;
//제네릭 자료형 미사용 -> 캐스팅연산자로 형전환을 계속 해줘야한다.
//오브젝트 타입에 어레이리스트 타입이 안들어가기 때문에
import java.util.ArrayList;

public class ArrayListTest1 {
	//갤럭시 3대를 담을 참조변수가 필요하다.
	public ArrayList setArrayList() {
		ArrayList galList = new ArrayList();
		Galaxy myGal = new Galaxy("갤럭시A 시리즈");
		Galaxy herGal = new Galaxy("갤럭시S 시리즈");
		Galaxy yourGal = new Galaxy("갤럭시노트 시리즈");
		
		boolean isMyGal = galList.add(myGal);
		if(isMyGal) System.out.println("내 갤럭시 담기성공");
		else System.out.println("내 갤럭시 담기실패");
		boolean isherGal = galList.add(herGal);
		if(isherGal) System.out.println("그녀의 갤럭시 담기성공");
		else System.out.println("그녀의 갤럭시 담기실패");
		boolean isyourGal = galList.add(yourGal);
		if(isyourGal) System.out.println("너의 갤럭시 담기성공");
		else System.out.println("너의 갤럭시 담기실패");

		return galList;
	}
	public static void main(String[] args) {
		ArrayListTest1 al = new ArrayListTest1();
		//메소드의 리턴타입으로 주소번지를 받아온다.
		ArrayList galList = al.setArrayList();
		//개선된 for문을 사용하여 반복처리
		for(Object obj:galList) { //Object 객체타입
			System.out.println(obj); //-> obj의 주소번지가 나옴
			//ArrayList안에 담긴 타입이 Galaxy이므로 타입을 맞춘다.
			Galaxy gal = (Galaxy)obj;
			//주소번지를 활용하여 전역변수를 출력한다.
			System.out.println(gal.name);
		}
		System.out.println("============================");
		double d = 3.14;
		int j = (int)d;
		for(int i=0;i<galList.size();i++) {
			Galaxy gal = (Galaxy)galList.get(i); //담아주는 타입을 캐스팅연산자에 적어준다
			String name = gal.name;
			System.out.println(name);
		}
	}

}