<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	List<Map<String, Object>> designList 
	= (List<Map<String, Object>>) request.getAttribute("designList"); 
	//Map<String, Object> pMap = (Map<String, Object>) request.getAttribute("pMap");
	Gson g = new Gson();
	String temp = g.toJson(designList);
	out.print(temp);
%>