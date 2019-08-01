package com.onlinetest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
		else if("onLineTest/swDesignExam".equals(crud)) {
			logger.info("Ctrl 소프트웨어설계 문제 호출 성공");
			Map<String, Object> pMap = new HashMap<String, Object>();
			//pMap을 한번에 set할 수 없기 때문에 리스트로 보낸다
			List<Map<String, Object>> designList = new ArrayList<Map<String,Object>>();
			pMap = tLogic.swDesignExam2(pMap);
			logger.info("Map의 클래스 : "+pMap.get("key").getClass());
			// key 값의 value만 빼오기
			List pList = null;
			if(pMap != null) {
				pList = (List) pMap.get("key");
			}
			// pList의 값 확인하기.
			Iterator iter = pList.iterator();
			while(iter.hasNext()) {
				logger.info("iter.next() : "+iter.next());
			}
			req.setAttribute("designList", pList);
			viewName = "jsonSwDesign.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		// http://localhost:8000/onLineTest/isOk.kos?work=onLineTest&mem_id=test&exam_no=1907300017
		else if("onLineTest/isOk".equals(crud)) {
			String msg = null;
			Map<String, Object> pMap = new HashMap<>();
			String mem_id = req.getParameter("mem_id");
			String exam_no = req.getParameter("exam_no");
			pMap.put("mem_id", mem_id);
			pMap.put("exam_no", exam_no);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);
			viewName = "isOkResult.jsp";
			isRedirect = false;
			forward.setViewName(viewName);
			forward.setRedirect(isRedirect);
		}
		return forward;
	}

}
