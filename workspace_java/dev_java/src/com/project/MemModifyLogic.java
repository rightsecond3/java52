package com.project;

public class MemModifyLogic {
	MemDao mDao = new MemDao();
	public MemVO memUpdate(MemVO mpaVO) {
		MemVO mraVO = null;
		mraVO = mDao.memUpdate(mpaVO);
		return mraVO;
	}

}
