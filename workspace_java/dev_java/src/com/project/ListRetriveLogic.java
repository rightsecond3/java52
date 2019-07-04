package com.project;

import java.util.List;

public class ListRetriveLogic {
	ListDao dvdDao = new ListDao();
	//** 조회를 구현할 메소드 구현 **//
	public List<ListVO> getDVDList(ListVO paVO) {
		List<ListVO> list = null;
		list = dvdDao.getList(paVO);
		return list;
	}



}
