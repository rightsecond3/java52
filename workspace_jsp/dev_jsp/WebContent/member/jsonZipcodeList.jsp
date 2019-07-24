<%@page import="com.google.gson.Gson"%>
<%@page import="com.vo.ZipCodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ZipCodeVO> zipList = null;
	zipList = (List<ZipCodeVO>) request.getAttribute("zipList");
	String temp = null;
	if(zipList.size()>0) {
		Gson gson = new Gson();
		temp = gson.toJson(zipList);
	}
	else {
		temp = "";
	}
	out.print(temp);
%>