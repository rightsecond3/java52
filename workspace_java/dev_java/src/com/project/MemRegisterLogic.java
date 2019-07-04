package com.project;

public class MemRegisterLogic {
	MemDao mDao = new MemDao();
	public MemVO memInsert(MemVO mpaVO) {
		MemVO mraVO = new MemVO();
		mraVO=mDao.memInsert(mpaVO);
		return mraVO;
	}

}
