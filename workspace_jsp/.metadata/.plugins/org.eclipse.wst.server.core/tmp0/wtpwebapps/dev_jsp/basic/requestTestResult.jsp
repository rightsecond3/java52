<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>requestTest.do에 대한 응답 페이지임</title>
</head>
<body>
<%
	//요청을 처리한 것(requestTest.do)을 유지 못하기 때문에 에러
	List<String> nameList = (List<String>)request.getAttribute("nameList");
	for(String name : nameList) {
		out.print("name : "+name+"\n");
	}
%>
</body>
</html>