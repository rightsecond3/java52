<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.mvc1.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao mDao = new MemberDao();
	Map<String, Object> pMap = new HashMap<>();
	mDao.my_proc2(pMap);
	List list = (List)pMap.get("key");
	Gson g = new Gson();
	String temp = g.toJson(list);
	out.print(temp);
%>