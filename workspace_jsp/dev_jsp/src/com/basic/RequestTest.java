package com.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestTest extends HttpServlet {
		
	Logger logger = Logger.getLogger(RequestTest.class);
	/*
	 * 아래 메소드는 HttpServlet에서 정의된 메소드를 재정의 하였음.
	 * 이 때 파라미터는 반드시 request, response 사용
	 * 그래야 그 객체를 주입 받으므로 NullPointerException 피할 수 있다.
	 * 서블릿은 톰캣 서버에서 싱글톤으로 객체를 관리하므로 
	 * 한개의 서블릿 클래스를 메모리에 올린 후 여러 사용자가 사용할 땐 스레드를 통하여
	 * 순서 혹은 경합의 경우 공평하게 서비스를 제공 받게 됨.
	 * 싱글톤으로 만들어진 RequestTest객체를 톰캣에서 관리 하므로 내가 직접 예외처리하는데 한계가 있다.
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//int i = req.getParameter("name"); : 불가
		List<String> nameList = new ArrayList<>();
		nameList.add("김유신");
		nameList.add("홍길동");
		nameList.add("이순신");
		//req 객체에 필요한 정보를 담을 수 있다.
		req.setAttribute("nameList", nameList);
		Object obj = req.getAttribute("nameList");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		/*
		 * 상대경로 - 현재 내가 있는 곳 -> 어디를 보면 알 수 있는가?
		 * 절대경로 - http://192.168.0.244:8000/basic/XXX.jsp
		 * 왜 NullPointerException이 발생하는 거지?
		 * 주소창에 URL이 바뀌었다. - 관찰 -> 이동처리(새로운 요청 발생)
		 * 톰캣은 기존 요청이 끊어지고 새로운 요청이 발생함.
		 * 우리가 사용한 request와 requestTestResult.jsp request가 다름
		 * 해결 : 
		 * 같은 주소번지를 가짐
		 * 어떻게? - 
		 * URL이 바뀌지 않는다는건 톰캣이 같은 요청이 계속 유지되고 있다고 판단.
		 */
		//res.sendRedirect("requestTestResult.jsp"); - 요청이 끊어짐
		RequestDispatcher view = req.getRequestDispatcher("./requestTestResult.jsp");
		view.forward(req, res); //서블릿의 req와 res를 넘겨줌
		//URL이 바뀌지 않음
	}
}
