package com.quiz0607;

import java.util.Arrays;

public class Question6 {
	String str[] = {"1","2","3"};
	//Object 최상위 클래스에 여러가지 클래스 타입을 넣어 줄 수 있다.
	Object[] myObjects = {
			new Integer(12),
			new String("foo"),
			new Integer(5),
			new Boolean(true)
	};
	public void methodA() {
		try {
			//정렬시 형변환 오류 발생, 타입이 다르기 때문에 서로 비교 불가능
			Arrays.sort(myObjects);			
		} catch (Exception e) {
			System.out.println("EXCEPTION"+e.toString());
		}
		for(int i=0;i<myObjects.length;i++) {
			System.out.println(myObjects[i].toString());
			System.out.println("    ");
		}		
	}
	public static void main(String[] args) {
		Question6 q6 = new Question6();
		q6.methodA();
	}
}