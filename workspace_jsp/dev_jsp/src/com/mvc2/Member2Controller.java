package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vo.MemberVO;

public class Member2Controller implements Controller {
	//** 선언부
	Logger logger = Logger.getLogger(Member2Controller.class);
	String requestName = null;
	String crud = null;
	MemberLogic memLogic = null;
	
	//*** 생성자
	public Member2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
		memLogic = new MemberLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("[Member2Controller_execute] : 호출성공");
		String path = null;
		if("index".equals(crud)) {
			logger.info("[Member2Controller_execute] : index");
			// path 경로에 jsp 뿐만이 아닌 다른 서블릿을 요청하는 것도 가능하다.
			path = "redirect:/onLineTestVer2/index.jsp";
		} else if("login".equals(crud)) {
			logger.info("[Member2Controller_execute] : login");
			MemberVO pmVO = new MemberVO();
			pmVO.setMem_id(req.getParameter("mem_id"));
			pmVO.setMem_pw(req.getParameter("mem_pw"));
			MemberVO rmVO = memLogic.proc_login(pmVO);
			HttpSession session = req.getSession();
			session.setAttribute("rmVO", rmVO);
			logger.info("이름 : "+rmVO.getMem_name());
			path = "redirect:/onLineTestVer2/loginAccount.jsp";
		} else if("".equals(crud)) {
			path = "";
		}
		return path;
	}

}
