package com.helpme2;

import javax.swing.JFrame;
/*
 * 현재 화면 처리 안되어 있으므로 로그인 성공되어도 화면 출력안됨..
 * 그러나 다이얼로그 화면은 확인 가능함.
 */
public class TalkClientVer2_1 extends JFrame {
	/////선언부
	Login_1 login = null;
	
	//* 생성자 *//
	public TalkClientVer2_1() {}
	//생성자를 통해서 앞 화면에서 처리된 결과인 nickName을 사용하려면 원본의 주소번지가 필요함.
	public TalkClientVer2_1(Login_1 login) {
		this.login = login;
	}
	
	//*** 화면 처리부 ***//
	public void initDisplay() {
		
	}
}
