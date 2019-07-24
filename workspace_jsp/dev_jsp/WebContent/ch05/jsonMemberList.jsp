<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> memList
	=(List<Map<String, Object>>) request.getAttribute("memList");
	String temp = "";
	if(memList!=null && memList.size() != 0) {
		Gson g = new Gson();
		temp = g.toJson(memList);
	}
	else {
		temp = "조회된 값이 없습니다.";
	}
	out.print(temp);
%>