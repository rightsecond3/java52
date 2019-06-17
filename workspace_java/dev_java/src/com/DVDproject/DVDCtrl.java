package com.DVDproject;

import java.util.List;

public class DVDCtrl {
	private static final String _SEL = "select";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";
	
	public DVDVO send(DVDVO paVO) throws Exception {
		DVDVO raVO = null;
		String command = paVO.getCommand();
		if(_INS.equals(command)) {
			System.out.println("입력 호출 성공");
		}
		else if (_UPD.equals(command)) {
			System.out.println("수정 호출성공");
		}
		else if (_DEL.equals(command)) {
			System.out.println("삭제 호출성공");
		}
		else {
			throw new Exception("잘못된 command명 입니다.");
		}
		return raVO;
	}	
	
	//** 조회 메소드 구현 **// -조회는 건수가 여러건일 수 있다.
	public List<DVDVO> sendList(DVDVO paVO) {
		List<DVDVO> rentList = null;
		String command = paVO.getCommand();
		if (_SEL.equals(command)) {
			System.out.println("조회 호출 성공");
			RetrieveLogic retLogic = new RetrieveLogic();
			rentList = retLogic.getRentList(paVO);
		}
		return rentList;
	}
}