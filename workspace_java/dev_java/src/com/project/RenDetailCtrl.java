package com.project;

import java.util.List;
import java.util.Map;

public class RenDetailCtrl {
	private static final String _SEL = "select";//전체조회를 구분하기 위한 값
	private static final String _DET = "detail";//상세조회를 구분하기 위한 값
	private static final String _INS = "insert";//입력을 구분하기 위한 값
	private static final String _UPD = "update";//수정을 구분하기 위한 값
	private static final String _DEL = "delete";//삭제를 구분하기 위한 값
	public List<Map<String, Object>> send(String command, RenDetailVO paVO) {
		List<Map<String, Object>> detList = null;
		if(_SEL.equals(command)) {
			RenDetailRetrieveLogic retLogic = new RenDetailRetrieveLogic();
			detList = retLogic.getRenDetailMap(paVO);
		}
		return detList;
	}
	public RenDetailVO send(RenDetailVO rdpaVO) {
		RenDetailVO rdraVO = null;
		String command = rdpaVO.getCommand();
		if(_INS.equals(command)) {//입력-> ("insert".equasl("insert"))
			System.out.println("입력 호출 성공");
			RenDetailRegisterLogic RegLogic = new RenDetailRegisterLogic();
			rdraVO = RegLogic.Insert(rdpaVO);
		}
		else if(_UPD.equals(command)) {//수정버튼을 누른거야?
			RenDetailModifyLogic ModLogic = new RenDetailModifyLogic();
			System.out.println("Ctrl의 status값 ");
			rdraVO = ModLogic.Update(rdpaVO);
		}
		else if(_DEL.equals(command)) {//삭제하니?
			RentDetailDelteLogic DelLogic = new RentDetailDelteLogic();
			rdraVO = DelLogic.Delete(rdpaVO);	
		}
		return rdraVO;
	}

}