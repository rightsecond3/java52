package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Member2Controller implements Controller {
	//** 선언부
	Logger logger = Logger.getLogger(Member2Controller.class);
	String requestName = null;
	String crud = null;
	//*** 생성자
	public Member2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("[Member2Controller_execute] : 호출성공");
		String path = null;
		if("login".equals(crud)) {
			// path 경로에 jsp 뿐만이 아닌 다른 서블릿을 요청하는 것도 가능하다.
			path = "redirect:/onLineTest/loginAccount.jsp";
		} else {
			path = "redirect:index.jsp";
		}
		return path;
	}

}
