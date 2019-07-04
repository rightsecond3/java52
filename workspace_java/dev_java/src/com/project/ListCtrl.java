package com.project;

import java.util.List;

public class ListCtrl {
	private static final String _SEL = "select";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";
	private static final String _DET = "detail";
	
	public List<ListVO> send(String command, ListVO paVO) {
		List<ListVO> dvdList = null;
		if(_SEL.equals(command)) {
			ListRetriveLogic retLogic = new ListRetriveLogic();
			dvdList = retLogic.getDVDList(paVO);
			
		}
		return dvdList;
	}

	public ListVO send(ListVO paVO) {
		//입력하고 난 후, 수정하고 난 후 삭제하고 난 후 상세조회하고 난 후에 오라클 서버에서
		//반환한 값을 담을 변수가 필요함.
		ListVO raVO = null;
		//사용자가 AddressBook에서 선택한 정보를 받아서 command변수에 저장함.
		String command = paVO.getCommand();//insert
		if(_INS.equals(command)) {//입력-> ("insert".equasl("insert"))
			System.out.println("입력 호출 성공");
			ListRegisterLogic RegLogic = new ListRegisterLogic();
			raVO = RegLogic.Insert(paVO);
		}
		else if(_UPD.equals(command)) {//수정버튼을 누른거야?
			ListModifyLogic ModLogic = new ListModifyLogic();
			System.out.println("Ctrl의 status값 ");
			raVO = ModLogic.Update(paVO);
		}
		else if(_DEL.equals(command)) {//삭제하니?
			ListDeleteLogic DelLogic = new ListDeleteLogic();
			raVO = DelLogic.Delete(paVO);	
		}
		return raVO;
	}
}
