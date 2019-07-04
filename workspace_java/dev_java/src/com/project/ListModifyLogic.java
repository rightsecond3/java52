package com.project;

public class ListModifyLogic {
	ListDao Dao = new ListDao();
	public ListVO Update(ListVO paVO) {
		ListVO raVO = null;
		System.out.println("Logic");
		raVO = Dao.Update(paVO);
		return raVO;
	}

}
