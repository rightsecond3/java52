package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// redirect인 경우
	public abstract String execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	
	/*
	// forward인 경우
	public abstract ModelAndView execute(HttpServletRequest req, HttpServletResponse res, String crud)
			throws Exception;
	*/
}
