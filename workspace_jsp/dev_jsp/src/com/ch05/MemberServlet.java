package com.ch05;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MemberServlet extends HttpServlet {
	Logger logger = Logger.getLogger(MemberServlet.class);
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//insert here - DAO객체를 주입하시오.
		MemberDao mDao = new MemberDao();
		List<Map<String, Object>> memList = mDao.memberList();
		//request는 저장소이기도 하다
		//request 저장소에 담을 땐 setAttrubute 호출함
		req.setAttribute("memList", memList);
		RequestDispatcher view = req.getRequestDispatcher("./jsonMemberList.jsp");
		view.forward(req, res);
		logger.info("service 호출 성공");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//service는 GenericServlet에서 상속받은 메소드
		//service에서 인터셉트해서 doGet은 실행 기회를 같지못함
		//logger.info("두 겟");
		//service(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//service(req, res);
	}
}
