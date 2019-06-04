package com.ch5;
public class MemberSimulation3 {
	public static void main(String[] args) {
		MemberVO mVO = new MemberVO();
		mVO = new MemberVO(10);
		//파라미터에 준 상수값들은 전역변수에 담긴다.
		mVO = new MemberVO("test", "abcd", "박상범", "서울시 금천구 가산동", "237-111");
		System.out.println(mVO.getMEM_ID());
		System.out.println(mVO.getMEM_PW());
		System.out.println(mVO.getMEM_NAME());
		System.out.println(mVO.getMEM_ADDR());
		System.out.println(mVO.getMEM_ZIPCODE());
	}
}
