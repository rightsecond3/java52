<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> subjectList = null;
	subjectList = (List<Map<String, Object>>) request.getAttribute("subjectList");
	String temp = null;
	Gson gson = new Gson();
	temp = gson.toJson(subjectList);
	out.print(temp);
%>