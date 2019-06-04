package com.quiz0529;

import javax.swing.JButton;

public class Question1 {

	public static void main(String[] args) {
		int x1, y1, z1;
		//배열 기호가 앞에 있을 경우 뒤의 선언된 변수도 전부 배열처리
		int []a, b, c;
		//배열 기호가 뒤에 있을 경우 해당 변수만 배열처리
		int a1[], b1, c1;
		int []x = {1,2,3,4,5};
		int y[] = x;
		System.out.println(y[2]);//3번째
		JButton jbtn_save = new JButton("저장");
		JButton jbtn_imsi = null;
		jbtn_imsi = jbtn_save;
		System.out.println(jbtn_imsi.getText());//저장
	}
}
