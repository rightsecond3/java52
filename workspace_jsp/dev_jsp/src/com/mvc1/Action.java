package com.mvc1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 표준 서블릿을 사용하면 리턴타입 변경 불가
 * 파라미터 갯수 변경 불가
 */
public interface Action {
	public ActionForward execuete(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;
}
