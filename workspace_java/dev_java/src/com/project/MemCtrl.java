package com.project;

import java.util.List;

import com.address.AddressVO;
import com.address.DeleteLogic;
import com.address.ModifyLogic;
import com.address.RegisterLogic;
import com.address.RetrieveLogic;

public class MemCtrl {
	private static final String _SEL = "select";
	private static final String _INS = "insert";
	private static final String _UPD = "update";
	private static final String _DEL = "delete";
	private static final String _DET = "detail";
	
	public MemVO send(MemVO mpaVO) {
		//입력하고 난 후, 수정하고 난 후 삭제하고 난 후 상세조회하고 난 후에 오라클 서버에서
		//반환한 값을 담을 변수가 필요함.
		MemVO mraVO = null;
		//사용자가 AddressBook에서 선택한 정보를 받아서 command변수에 저장함.
		String command = mpaVO.getCommand();//insert
		if(_INS.equals(command)) {//입력-> ("insert".equasl("insert"))
			MemRegisterLogic memRegLogic = new MemRegisterLogic();
			mraVO = memRegLogic.memInsert(mpaVO);
		}
		else if(_UPD.equals(command)) {//수정버튼을 누른거야?
			MemModifyLogic memModLogic = new MemModifyLogic();
			mraVO = memModLogic.memUpdate(mpaVO);
		}
		else if(_DEL.equals(command)) {//삭제하니?
			MemDeleteLogic memDelLogic = new MemDeleteLogic();
			mraVO = memDelLogic.memDelete(mpaVO);	
		} else if(_DET.equals(command)) {
			MemDetailLogic memDetLogic = new MemDetailLogic();
			mraVO = memDetLogic.memDetail(mpaVO);
		}else {
			//command에 insert, update, detail, select, delete를 제외한
			//값이 넘어올 경우 강제로 예외를 발생시키는 문자임 -더이상 어플이 진행되지 않음.
		}
		//각 4가지 경우에서 처리된 결과를 raVO에 담아서 반환해줌. 
		return mraVO;
	}
	
	//** 조회버튼 **//
	public List<MemVO> send(String command, MemVO mpaVO) {
		List<MemVO> dvdList = null;
		if(_SEL.equals(command)) {
			MemRetriveLogic retLogic = new MemRetriveLogic();
			dvdList = retLogic.getDVDList(mpaVO);
			
		}
		return dvdList;
	}

}
