package com.project;

public class RentDeleteLogic {
	RentDao rDao = new RentDao();
	public RentVO delete(RentVO rpaVO) {
		RentVO rraVO = null;
		rraVO = rDao.delete(rpaVO);
		return rraVO;
	}

}
