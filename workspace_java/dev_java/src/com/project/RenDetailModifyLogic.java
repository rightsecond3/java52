package com.project;

public class RenDetailModifyLogic {
	RenDetailDao Dao = new RenDetailDao();
	public RenDetailVO Update(RenDetailVO rdpaVO) {
		RenDetailVO rdraVO = null;
		rdraVO = Dao.Update(rdpaVO);
		return rdraVO;
	}

}
