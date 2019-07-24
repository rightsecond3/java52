package com.basic;
import java.io.IOException;

import javax.servlet.ServletException;
/*
 * 웹서비스를 제공하기 위해서는 서블릿이 되어야 함.
 * 왜냐하면 통신을 지원(누가 : 톰캣[WAS]) 받아야 하고
 * 서블릿이 생성 될 때 마다 스레드 지원이 필요
 * 한 사람이 서버에 접속하여 여러 페이지를 이동하고 때로는 결재를 때로는 동영상을 시청하는 것을 관리해야 함.
 * 작업에 대한 순서, 경합 상황이 계속 발생하게 됨.
 * 이렇게 생성된 서블릿 객체는 싱글톤으로 관리됨.
 */
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

//@WebServlet(urlPatterns="/hello.do")
public class HelloServlet extends HttpServlet {
	Logger logger = Logger.getLogger(HelloServlet.class);
	//Get방식으로 요청이 들어올 때
	/****************************************************************
	 * @return : void
	 * 질문 1 : 리턴타입이 void 인데 처리 결과를 어떻게 html문서에서 받을 수 있는가?
	 * @param1 : request 요청 객체 - 사용자 화면에 입력한 아이디를 받아 올 때 사용
	 * @param2 : response 응답 객체 - mime type, charset지정 
	 * 자바는 요청객체와 응답객체가 없다. - 웹페이지 처리 불가
	 * 오라클 연동은 자바로 함.
	 * 질문 2 : 파라미터 객체는 누가 제공하나요?
	 * 답변 2 : 객체주입은 톰캣[WAS]에서 담당한다.
	 * 질문 3 : 객체주입은 언제 일어나는가?
	 * 답변 3 : 요청이 있을 때 주입됨.
	 * 질문 4 : 서블릿의 doGet메소드는 어떻게 호출하는가?
	 * 답변 4 : 시스템에서 자동으로 호출함.(콜백메소드), 브라우저의 URL 주소 필요
	 * 서블릿을 호출하는 데는 URL 주소가 필요
	 * 해당 주소는 배치 서술자에 등록이 되어 있어야 한다.
	 * 배치 서술자는 DD(deploy discriptor) web.xml 이다.
	 * web.xml 문서에 서블릿 클래스 이름을 등록하고 대응하는 url 주소를 미리 정함
	 * URL 명 : http://localhost:8000/hello.do
	 * hello.do 이름으로 HelloServlet 클래스를 찾아야함.
	 *****************************************************************/

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		/*
		 * JSP에서는 내장 객체로 자동 지원되지만
		 * 서블릿에서는 내장객체 지원이 없으므로 다음과 같이 생성한후 사용함
		 */
		HttpSession session = req.getSession();
		//세션에 값을 담기
		session.setAttribute("name", "이순신");
		//세션에 있는 값 꺼내기
		//List 같은 자료구조도 담을 수 있다.
		//그러나 cache메모리 공간의 한계로 조회 결과를 담는데 사용하지 않음
		//일반적으로 이런 경우에는 request를 사용
		String s_name = (String) session.getAttribute("name");
		
		String mem_id = "test";
		res.setContentType("text/html;charset=utf-8");
		//hello.do?command=insert
		String command = req.getParameter("command");
		if ("insert".equals(command)) {//입력
			logger.info("입력선택");
		}
		else if("update".equals(command)) {//수정
			logger.info("수정선택");
		}
		else if("delete".equals(command)) {//삭제
			logger.info("삭제선택");
		}
		else if("select".equals(command)) {//조회
			logger.info("조회선택");
		}
	}
	//Post방식으로 요청이 들어올 때
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

	}
	public void methodA(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
}
