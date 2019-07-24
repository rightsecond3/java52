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
	session.setAttribute("name", name);
	response.sendRedirect("B1.jsp");
	%>
</body>
</html>