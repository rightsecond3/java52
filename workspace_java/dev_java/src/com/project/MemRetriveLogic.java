package com.project;

import java.util.List;

public class MemRetriveLogic {
	MemDao dMemDao = new MemDao();
	//** 조회를 구현할 메소드 구현 **//
	public List<MemVO> getDVDList(MemVO mpaVO) {
		List<MemVO> list = null;
		list = dMemDao.getList(mpaVO);
		return list;
	}

}
