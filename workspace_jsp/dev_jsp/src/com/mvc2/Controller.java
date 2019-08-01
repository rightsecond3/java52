package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public abstract String execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
}
