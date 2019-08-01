package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Test2Controller implements Controller {
	//** 선언부
	Logger logger = Logger.getLogger(Test2Controller.class);
	String requestName = null;
	String crud = null;
	//*** 생성자
	public Test2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("[Test2Controller_execute] : 호출 성공");
		String path = null;
		if("select".equals(crud)) {
			path = "forward:test.jsp";
		} else if("update".equals(crud)) {
			path = "";
		} else if("delete".equals(crud)) {
			path = "";
		} else {
			path = "redirect:index.jsp";
		}
		return path;
	}

}
