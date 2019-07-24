<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B.jsp(응답이 나가는 곳)</title>
</head>
<body>
	<%
	String name = (String) request.getAttribute("name");
	out.print(name);
	%>
	<h3>B.jsp로 이동됨.</h3>
</body>
</html>