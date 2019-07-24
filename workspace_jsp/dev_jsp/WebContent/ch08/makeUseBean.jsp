<%@page import="com.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="mVO" class="com.vo.MemVO" scope="request"></jsp:useBean>
	<%
		mVO.setMem_name("박상범");
		mVO.setMem_id("jvm");
	%>
	<jsp:forward page="./useBean.jsp"></jsp:forward>
</body>
</html>