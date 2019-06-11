package com.myDVD;

import java.util.List;

import com.address.AddressVO;

public class DVDCtrl {
	public static final String _SEL = "select"; 
	public static final String _DET = "delete";
	public static final String _INS = "insert";
	public static final String _UPD = "update";
	public static final String _DEL = "delete";
	/********************************************************************
	 * 
	 * @param paVO - 사용자가 입력한 값
	 * @return raVO - 오라클 서버에서 반환값을 담은 변수
	 * @throws Exception - 이 메소드를 호출하는 메소드에서는 반드시 try..catch를 구현
	 *********************************************************************/
	public DVDVO send(DVDVO paVO) throws Exception {
		DVDVO raVO = null;
		String command = paVO.getCommand();
		if(_INS.equals(command)) { //입력
			
		}
		else if (_UPD.equals(command)) { //수정버튼을 누른거야?
			
		}
		else if (_DEL.equals(command)) { //삭제하니?
			
		}
		else if (_DET.equals(command)) { //상세조회
			
		}else {
			throw new Exception("잘못된 command명 입니다.");
		}
		return raVO;
	}
	/***********************************************************
	 * 전체 조회 구현
	 * @param command select
	 * @return ArrayList<DVDVO>
	 ***********************************************************/
	public List<DVDVO> send(String command) {
		List<DVDVO> dvdList = null;
		if (_SEL.equals(command)) {
			
		}
		return dvdList;
	}
}

