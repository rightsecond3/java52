package com.project;

public class RentRegisterLogic {
	RentDao rDao = new RentDao();
	public RentVO insert(RentVO rpaVO) {
		RentVO rraVO = new RentVO();
		rraVO = rDao.Insert(rpaVO);
		return rraVO;
	}

}
