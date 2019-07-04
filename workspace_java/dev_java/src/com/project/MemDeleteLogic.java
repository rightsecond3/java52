package com.project;

public class MemDeleteLogic {
	MemDao mDao = new MemDao();
	public MemVO memDelete(MemVO mpaVO) {
		MemVO mraVO = null;
		mraVO = mDao.memDelete(mpaVO);
		return mraVO;
	}

}
