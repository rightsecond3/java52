package com.project;

public class RenDetailRegisterLogic {
	RenDetailDao rdDao = new RenDetailDao();
	public RenDetailVO Insert(RenDetailVO rdpaVO) {
		RenDetailVO rdraVO = new RenDetailVO();
		rdraVO = rdDao.Insert(rdpaVO);
		return rdraVO;
	}

}
