package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestController implements Controller {
	
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String jsonStr = null;
		jsonStr = "[{'mem_id':'test', 'mem_name':'이순신'}]";
		return jsonStr;
	}

}
