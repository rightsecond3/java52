package com.ch4;

public class ArrayFor {

	public static void main(String[] args) {
		int deptnos[] = new int[3];
		deptnos[0] = 10;
		deptnos[1] = 20;
		deptnos[2] = 30;
		for(int i=0;i<3;i++) {
			 System.out.println(deptnos[i]);
		}
		System.out.println("=============================");
		for(int num:deptnos) {//개선된 for문, 전체를 모두 출력할 때 사용
			System.out.println(num);
		}
		System.out.println("==========================");
		String nickNames[] = new String[3];
		nickNames[0] = "이순신";
		nickNames[1] = "김유신";
		nickNames[2] = "강감찬";
		for(String cnt:nickNames) { //for(자료형 변수명 : 수식)
			System.out.println(cnt);
		}
	}
}
