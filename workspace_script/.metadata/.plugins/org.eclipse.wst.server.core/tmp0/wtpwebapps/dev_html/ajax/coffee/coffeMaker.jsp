<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String coffeemaker = request.getParameter("coffeemaker");
	String name = request.getParameter("name");
	for(double i=0;i<9999999990.0;i++) {
		//커피를 만드는 시늉을 한다.
	}
	//기존에 갖고 있던 정보를 출력버퍼에서 삭제하기
	//해당 코드를 작성하지 않으면 계속 1번 머신 정보만 유지될 수 도 있다.
	out.clear();
	out.print(coffeemaker+name);
%>