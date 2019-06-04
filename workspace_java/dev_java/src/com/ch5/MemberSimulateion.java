package com.ch5;

public class MemberSimulateion {

	public static void main(String[] args) {
		MemberVO memVO = new MemberVO();
		/*
		 * MemberVO에는 여러 변수가 선언되어 있음.
		 * 그러나 선언만 되어 있고 초기화는 되어 있지 않음
		 * 즉 어떤 정보도 가지고 있지 않은 상태
		 * 어떤 정보를 초기회 해주어야 값을 꺼낼 수 있음
		 */
		 //MEM_ID = mEM_ID; 이미 setMEM_ID 메소드에 들어 있기 때문에 바로 파라미터에 넣어줘야한다.
		memVO.setMEM_ID("test");
		String mem_id=memVO.getMEM_ID();
		System.out.println(mem_id);
		System.out.println(memVO.getMEM_ID());
	}

}
