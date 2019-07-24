package com.onlinetest;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	TestDao tDao = new TestDao();
	
	//* DB에 있는 콤보박스 과목명을 불러오는 메소드
	public List<Map<String, Object>> subjectList() {
		logger.info("Dao subjectList 호출 성공");
		List<Map<String, Object>> subjectList = null;
		subjectList = tDao.subjectList();
		return subjectList;
	}

}
