package com.project;

public class MemDetailLogic {
	MemDao mDao = new MemDao();
	public MemVO memDetail(MemVO mpaVO) {
		MemVO mraVO = null;
		mraVO = mDao.getMemDetail(mpaVO);
		return mraVO;
	}

}
