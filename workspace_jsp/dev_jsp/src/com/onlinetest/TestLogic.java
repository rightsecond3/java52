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

	public int examReceipt(Map<String, Object> pMap) {
		logger.info("TestLogic examReceipt");
		int result = 0;
		String exam_no = null;
		//수험번호 채번하여 담기 - select
		exam_no = tDao.getExamNo();
		//위에서 채번한 수험번호를 파라미터에 넣기
		pMap.put("exam_no", exam_no);
		//시험 응시 접수처리 -select
		//0이면 접수 실패, 1이면 접수 성공
		result = tDao.examReceipt(pMap);
		return result;
	}

	public List<Map<String, Object>> swDesignExam(Map<String, Object> pMap) {
		logger.info("TestLogic swDesignExam");
		List<Map<String, Object>> designList = null;
		designList = tDao.swDesignExam(pMap);
		return designList;
	}
	
	//**** 내꺼
	public Map<String, Object> swDesignExam2(Map<String, Object> pMap) {
		tDao.swDesignExam2(pMap);
		return pMap;
	}
	// 수험번호와 이름이 맞는지 확인하기
	public String isOk(Map<String, Object> pMap) {
		logger.info("TestLogic isOk");
		String msg = null;
		msg = tDao.isOk(pMap);
		return msg;
	}

}
