<%@ page import="java.util.*" %>
<%@ page import="com.util.HashMapBinder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공통코드 bind메소드 활용법</title>
</head>
<body>
<%
	Map<String, Object> target = new HashMap<>();
	HashMapBinder hmb = new HashMapBinder(request);
	hmb.bind(target);
	Object keys[] = target.keySet().toArray();
	for(int i=0;i<keys.length;i++) {
		out.print(target.get(keys[i]));
		out.print("<br>");
	}
%>
</body>
</html>