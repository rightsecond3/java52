package com.onlinetest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc1.Action;
import com.mvc1.ActionForward;
import com.util.HashMapBinder;

public class TestController extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(TestController.class);
	TestLogic tLogic = new TestLogic();
	
	@Override
	public ActionForward execuete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud = (String) req.getAttribute("crud");
		if("onLineTest/subjectList".equals(crud)) {
			logger.info("combobox url");
			List<Map<String, Object>> subjectList = null;
			subjectList = tLogic.subjectList();
			req.setAttribute("subjectList", subjectList);
			viewName = "jsonSubjetList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		} 
		else if("onLineTest/examReceipt".equals(crud)) {
			logger.info("Ctrl 시험 접수 호출 성공");
			int result = -1; //시험 접수 성공 여부
			//사용자가 입력한 값 받아오기
			Map<String, Object> pMap = new HashMap<String, Object>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			//화면에서 받아올 것들 - 아이디, 과목, 응시일자
			
			//서버에서 새로 채번할 것들
			result = tLogic.examReceipt(pMap);
			viewName = "index.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		
		return forward;
	}

}
