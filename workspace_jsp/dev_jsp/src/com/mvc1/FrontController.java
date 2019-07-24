package com.mvc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.onlinetest.TestController;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	MemberCont memCtrl = new MemberCont();
	GoodsCont goodsCtrl = new GoodsCont();
	OrderCont orderCtrl = new OrderCont();
	// 온라인 시험 테스트
	TestController tCtrl = new TestController();

	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// logger.info("doService 호출 성공"+"work=member, order, goods");
		// * url로 분기하기
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();//-> /*.kos
		String context = req.getContextPath();//-> /
		String command = uri.substring(context.length() + 1);
		int end = command.lastIndexOf('.');
		logger.info(command + ", " + end);
		command = command.substring(0, end);
		logger.info(command);
		// 요청하는 이름에 따라 구체적인 업무를 구분하고 싶다면 호출하는 이름을 별도로 처리해야함
		// 어찌하면 될까?
		// 테스트 할 때 어떤 이름이든 상관 없이 ?work=member를 넘겨주면 됨.
		// work 정보는 사용자가 요청 시 결정해서 넘겨주고
		// crud의 경우는 같은 회원 관리 업무 중에서도 입력|수정|삭제|조회를 식별가능 해야함.
		String work = req.getParameter("work");
		logger.info("work : " + work);
		ActionForward forward = null;
		if ("member".equals(work)) {
			req.setAttribute("crud", command);
			forward = memCtrl.execuete(req, res);
		} else if ("goods".equals(work)) {
			forward = goodsCtrl.execuete(req, res);
		} else if ("order".equals(work)) {
			forward = orderCtrl.execuete(req, res);
		} else if ("onLineTest".equals(work)) { //온라인 시험 테스트 : 정처기
			req.setAttribute("crud", command);
			// req res는 WAS가 객체주입시켜준다.
			// req는 파라미터로 넘겨서 get, set
			// forward는 리턴타입으로 받아 get, set
			forward = tCtrl.execuete(req, res);
		}
		//////
		if (forward != null) {
			if (forward.isRedirect()) {
				res.sendRedirect(forward.getViewName());
			} else {
				RequestDispatcher view = req.getRequestDispatcher(forward.getViewName());
				view.forward(req, res);
			}
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res);
	}
}
