<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A.jsp(요청을 받는 곳)</title>
</head>
<body>
	<%	
	String name = "SCOTT";
	// 요청 객체에 담기
	request.setAttribute("name", name);
	// 페이지 이동처리 -> 주소변경_기존의 요청이 끊어짐.
	// request객체가 현페이지의 같은 원본이 아니다.(name 값이 들어있지않다.)
	response.sendRedirect("B.jsp"); 
	// 요청 유지하기 -> 주소변경 X
	RequestDispatcher view = request.getRequestDispatcher("B.jsp");
	view.forward(request, response);
%>
</body>
</html>