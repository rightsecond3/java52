package com.mvc2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class Test2Controller implements Controller {
	//** 선언부
	Logger logger = Logger.getLogger(Test2Controller.class);
	String requestName = null;
	String crud = null;
	TestLogic tLogic = new TestLogic();
	//*** 생성자
	public Test2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("[Test2Controller_execute] : 호출 성공");
		String path = null;
		if("examReceipt".equals(crud)) {
			logger.info("[Test2Controller_execute] : examReceipt");
			int result = -1; // 시험 접수 성공 여부
			Map<String, Object> pMap = new HashMap<String, Object>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = tLogic.examReceipt(pMap);
			if (result==1) {
				logger.info("[Test2Controller_examReceipt] 성공");
				path = "redirect:examReceiptSuccess.jsp";
			} else {
				path = "redirect:examReceiptFail.jsp";
			}
		} else if("subjectList".equals(crud)) {
			logger.info("[Test2Controller_execute] : subjectList");
			List<Map<String, Object>> subjectList = null;
			subjectList = tLogic.subjectList();
			req.setAttribute("subjectList", subjectList);
			path = "forward:jsonSubjectList.jsp";
		} else if("isOk".equals(crud)) {
			logger.info("[Test2Controller_execute] : isOk");
			String msg = null;
			Map<String, Object> pMap = new HashMap<String, Object>();
			String mem_id = req.getParameter("mem_id");
			String exam_no = req.getParameter("exam_no");
			pMap.put("mem_id", mem_id);
			pMap.put("exam_no", exam_no);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);
			path = "forward:isOkResult.jsp";
		} else if("swDesignExam".equals(crud)) {
			logger.info("[Test2Controller_execute] : swDesignExam");
			Map<String, Object> pMap = new HashMap<String, Object>();
			List<Map<String, Object>> designList = new ArrayList<Map<String,Object>>();
			pMap = tLogic.swDesignExam2(pMap);
			List pList = null;
			if(pMap != null) {
				//pMap에 리턴으로 담겨있는 ref 커서의 값을 빼옴
				pList = (List) pMap.get("key");
			}
			req.setAttribute("designList", pList);
			path = "forward:jsonSwDesign.jsp";
		} else {
			path = "redirect:index.jsp";
		}
		return path;
	}

}
