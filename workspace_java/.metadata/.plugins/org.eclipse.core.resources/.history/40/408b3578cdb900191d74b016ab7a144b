package com.helpme4;

import java.util.Map;

public class LogicMember {
	DaoMember mDao = new DaoMember();
	// :JOIN
	public String join(Map<String, Object> pMap) {
		String mem_id = null;
		mem_id = mDao.join(pMap);
		return mem_id;
	}
	// :OVERLAP
	public String overLap(String mem_id) {
		String temp = mDao.overLap(mem_id);
		return temp;
	}
	//로그인 : LOGIN
	public VOMem login(VOMem pVO) {
		VOMem rVO = new VOMem();
		rVO = mDao.login(pVO);
		return rVO;
	}
}
