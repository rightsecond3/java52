package com.mvc1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.MemberVO;
import com.vo.ZipCodeVO;
/*
 * select 일 경우 forward
 * 나머지 경우 redirect
 */
public class MemberCont extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(MemberCont.class);
	MemberLogic memLogic = new MemberLogic();
	
	@Override
	public ActionForward execuete(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud = (String) req.getAttribute("crud");
		if("member/zipcodeList".equals(crud)) {
			logger.info("우편번호 조회 호출 성공");
			List<ZipCodeVO> zipList = null;
			ZipCodeVO zVO = new ZipCodeVO();
			zVO.setDong(req.getParameter("dong"));
			zipList = memLogic.zipcodeList(zVO);
			req.setAttribute("zipList", zipList);
			viewName = "jsonZipcodeList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		else if("member/memberList".equals(crud)) {
			logger.info("회원 목록 조회 호출 성공");
			List<Map<String, Object>> memList = null;
			memList = memLogic.memberList();
			//조회된 결과 forward로 넘겨주기 위해 담아줌
			req.setAttribute("memList", memList);
			viewName = "../member/jsonMemberList.jsp";
			isRedirect = false;
			forward.setViewName(viewName);
			forward.setRedirect(isRedirect);
		}
		else if("member/memberInsert".equals(crud)) {
			logger.info("회원 가입 호출 성공");
			int result = 0;
			Map<String, Object> pMap = new HashMap<>();
			//req.getParameter 대신 해주는 클래스
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			result = memLogic.memberInsert(pMap);
			viewName = "memberMgr.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		else if("member/memberUpdate".equals(crud)) {
			logger.info("회원 수정 호출 성공");
			MemberVO mVO = new MemberVO();
			mVO.setMem_id(req.getParameter("mem_id"));
			mVO.setMem_name(req.getParameter("mem_name"));
			mVO.setMem_addr(req.getParameter("mem_addr"));
			mVO.setMem_pw(req.getParameter("mem_pw"));
			mVO.setMem_zipcode(req.getParameter("mem_zipcode"));
			int result = 0;
			result = memLogic.memberUpdate(mVO);
			viewName = "memberMgr.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		else if("member/memberDelete".equals(crud)) {
			logger.info("회원 삭제 호출 성공");
			int result = 0;
			String mem_id = req.getParameter("mem_id");
			result = memLogic.memberDelete(mem_id);
			viewName = "memberMgr.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		//온라인 시험 처리 서비스에서 로그인 할 경우
		else if("member/login".equals(crud)) { 
			logger.info("온라인 서험처리 서비스 로그인");
			MemberVO pmVO = new MemberVO();
			MemberVO rmVO = null;
			pmVO.setMem_id(req.getParameter("mem_id"));
			pmVO.setMem_pw(req.getParameter("mem_pw"));
			rmVO = memLogic.proc_login(pmVO);
			// 일정 시간만 로그인 되게 하기 위해 session에 담기
			HttpSession session = req.getSession();
			session.setAttribute("rmVO", rmVO);
			//로그인 성공시 보여줄 화면
			viewName = "/onLineTest/loginAccount.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}

		return forward;
	}

}
