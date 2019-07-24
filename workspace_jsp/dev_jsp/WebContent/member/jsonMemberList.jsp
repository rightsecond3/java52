<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> memList = null;
	memList = (List<Map<String, Object>>) request.getAttribute("memList");
	String temp = null;
	if(memList.size()>0) {
		Gson gson = new Gson();
		temp = gson.toJson(memList);
	}
	else {
		temp = "";
	}
	out.print(temp);
%>