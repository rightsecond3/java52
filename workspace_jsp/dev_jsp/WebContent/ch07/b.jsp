<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp에 포함되는 페이지 입니다.</title>
</head>
<body>
<%

	String i = request.getParameter("p1");
	String name = request.getParameter("p2");
%>
<%=i %>
<%=name %>
<!-- 이 서블릿은 b_jsp.java로 따로 만들어 진다. -->
1. 첫번째 코드<br><!-- 실행순서 3 -->
2. 두번째 코드<br><!-- 실행순서 4 -->
3. 세번째 코드<br><!-- 실행순서 5 -->
</body>
</html>