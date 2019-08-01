package com.mvc2;
/*
 * controller의 type은 Controller interface지만
 * ControllerMapping의 getController메소드가 호출되면
 * Controller의 구현체 클래스가 객체 생성이 되므로 controller는 더 이상 null이 아니다.
 * 그 구현체 클래스가 어떤 타입인지는 ControllerMapping 클래스에서 확인하면 된다.
 * 인터페이스의 execute는 추상메소드이지만 구현체 클래스를 통해서 execute는 더 이상 추상메소드가 아니다.
 * getController의 work값으로 해당 구현체 클래스의 객체가 생성되어 그에 맞는 execute 메소드가 호출이 된다.
 * 이렇게 설계하면 서블릿은 ActionServlet 하나만 생성되므로
 * 버전1에서 처럼 업무 처리클래스가 모두 서블릿이 될 필요가 없으므로 톰켓 입장에서는 단일 서블릿을 관리하면 되고
 * 나머지 클래스는 JVM을 통해서 객체의 라이프사이클을 관리가 이루어진다.
 * 동시 접속자 수가 많은 서비스의 경우에도 안전하게 서버를 운영할 수 있다.
 * 버전 1의 경우 업무마다 서블릿이 생성되게 되어서 서버의 부담을 가중 시키게 되므로 실제 운영 서버에는 사용불가한 설계임.
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionServlet extends HttpServlet {
	//*** 선언부
	Logger logger = Logger.getLogger(ActionServlet.class);
	
	private void doService(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		// dev_jsp/onLineTest/test.mo?crud=select
		String requestURI = req.getRequestURI();
		// /dev_jsp or /
		String contextPath = req.getContextPath();
		// onLineTest/test.mo -> 쿼리스트링은 출력되지않음
		String command = requestURI.substring(contextPath.length()+1);
		logger.info("[ActionServlet_doService] command : "+command);
		Controller controller = null;
		String crud = req.getParameter("crud");
		logger.info("[ActionServlet_doService] crud : "+crud);
		try {
			controller = ControllerMapping.getController(command, crud);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(controller != null) {
			// return "redirect:XXX.jsp";
			String pageMove[] = null;
			try {
				String ret = controller.execute(req, res);
				// pageMove[0] = redirect || forward
				// pageMove[1] = 실제 이동할 요청 페이지 이름
				pageMove = ret.split(":");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(pageMove != null) {
				String path = pageMove[1];
				logger.info("[ActionServlet_doService] forward || redirect : "+pageMove[0]);
				logger.info("[ActionServlet_doService] path :"+path);
				if("redirect".equals(pageMove[0])) { //sendRedirect 일 때
					res.sendRedirect(path);
				} else { //forward 일때
					if("forward".equals(pageMove[0])) {
						RequestDispatcher reqDispatcher = req.getRequestDispatcher(path);
						reqDispatcher.forward(req, res);
					} else {
						res.sendRedirect("/error/pageMoveFail.jsp");
					}
				}
			}
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		doService(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doService(req, res);
	}
}
