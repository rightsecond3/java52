package com.project;

public class RentModifyLogic {
	RentDao rDao = new RentDao();
	public RentVO update(RentVO rpaVO) {
		RentVO rraVO = null;
		rraVO = rDao.update(rpaVO);
		return rraVO;
	}

}
