package com.project;

import java.util.List;
import java.util.Map;

public class RentRetrieveLogic {
	RentDao rDao = new RentDao();
	public List<Map<String, Object>> getRentMap(RentVO paVO) {
		List<Map<String, Object>> list = null;
		list = rDao.getRentMap(paVO);
		return list;
	}

}
