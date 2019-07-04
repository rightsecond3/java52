package com.project;

public class ListRegisterLogic {
	ListDao Dao = new ListDao();
	public ListVO Insert(ListVO paVO) {
		ListVO raVO = new ListVO();
		raVO=Dao.Insert(paVO);
		return raVO;
	}

}
