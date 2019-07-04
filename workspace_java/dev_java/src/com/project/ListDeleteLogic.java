package com.project;

public class ListDeleteLogic {
	ListDao Dao = new ListDao();
	public ListVO Delete(ListVO paVO) {
		ListVO raVO = null;
		raVO = Dao.Delete(paVO);
		return raVO;
	}

}
