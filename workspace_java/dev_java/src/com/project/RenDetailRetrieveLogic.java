package com.project;

import java.util.List;
import java.util.Map;

public class RenDetailRetrieveLogic {
	RenDetailDao rdDao = new RenDetailDao();
	public List<Map<String, Object>> getRenDetailMap(RenDetailVO paVO) {
		List<Map<String, Object>> list = null;
		list = rdDao.getDetMap(paVO);
		return list;
	}


}