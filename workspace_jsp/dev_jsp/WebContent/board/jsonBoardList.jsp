<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> rList = (List<Map<String, Object>>) request.getAttribute("rList");
	Gson gson = new Gson();
	if(rList != null && rList.size() != 0) {
		String temp = gson.toJson(rList);
		out.print(temp);
	} else {
		out.print("");
	}
%>