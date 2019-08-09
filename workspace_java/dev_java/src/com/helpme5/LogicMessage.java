package com.helpme5;

import java.util.List;
import java.util.Map;

public class LogicMessage {
	DaoMessage msgDao = new DaoMessage();
	
	//메세지를 보낼 경우 DB에도 넣고 룸캐스팅  : MESSAGE
	public List<Map<String, Object>> insMsgLogic(Map<String, Object> pMap) {
		List<Map<String, Object>> rList = null;
		// 메세지 인서트 해주기
		msgDao.insMsg(pMap);
		rList = msgDao.selMessage(pMap);
		return rList;
	}
}
