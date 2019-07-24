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
	<jsp:useBean id="mVO" scope="request" class="com.vo.MemVO"></jsp:useBean>
	<%= mVO.getMem_name() %>
	<%= mVO.getMem_id() %>
</body>
</html>