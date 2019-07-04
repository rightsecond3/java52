package com.project;

import java.util.List;
import java.util.Map;

public class RentCtrl {
	private static final String _SEL = "select";//전체조회를 구분하기 위한 값
	private static final String _DET = "detail";//상세조회를 구분하기 위한 값
	private static final String _INS = "insert";//입력을 구분하기 위한 값
	private static final String _UPD = "update";//수정을 구분하기 위한 값
	private static final String _DEL = "delete";//삭제를 구분하기 위한 값
	public List<Map<String, Object>> send(String command, RentVO paVO) {
		List<Map<String, Object>> rentList = null;
		if(_SEL.equals(command)) {
			RentRetrieveLogic retLogic = new RentRetrieveLogic();
			rentList = retLogic.getRentMap(paVO);
		}
		return rentList;
	}
	public RentVO send(RentVO rpaVO) {
		RentVO rraVO = null;
		String command = rpaVO.getCommand();
		if(_INS.equals(command)) {//입력-> ("insert".equasl("insert"))
			RentRegisterLogic RegLogic = new RentRegisterLogic();
			rraVO = RegLogic.insert(rpaVO);
		}
		else if(_UPD.equals(command)) {//수정버튼을 누른거야?
			RentModifyLogic ModLogic = new RentModifyLogic();
			rraVO = ModLogic.update(rpaVO);
		}
		else if(_DEL.equals(command)) {//삭제하니?
			RentDeleteLogic DelLogic = new RentDeleteLogic();
			rraVO = DelLogic.delete(rpaVO);	
		}
		return rraVO;
	}

}
