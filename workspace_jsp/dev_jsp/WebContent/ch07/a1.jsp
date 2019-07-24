<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a1.jsp</title>
</head>
<body>
<%
	String name = "김유신";
	int i =10;
%>
1. 첫번째 코드<br><!-- 실행순서 1 -->
2. 두번째 코드<br><!-- 실행순서 2 -->
<%@ include file="b1.jsp" %>
3. 세번째 코드<br><!-- 실행순서 6 -->
4. 네번째 코드<br><!-- 실행순서 7 -->
</body>
</html>