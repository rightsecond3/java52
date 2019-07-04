package com.project;

public class RentDetailDelteLogic {
	RenDetailDao Dao = new RenDetailDao();
	public RenDetailVO Delete(RenDetailVO rdpaVO) {
		RenDetailVO rdraVO = null;
		rdraVO = Dao.delte(rdpaVO);
		return rdraVO;
	}

}
