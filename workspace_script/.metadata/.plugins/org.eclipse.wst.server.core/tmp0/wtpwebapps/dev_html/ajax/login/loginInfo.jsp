<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.google.gson.Gson" %>
<%
String p_id = request.getParameter("mem_id");
List<Map<String,Object>> memList = new ArrayList<>();
Map<String,Object> memInfo = new HashMap<>();
memInfo.put("mem_name", "박과장");
memInfo.put("mem_id", "park");
memInfo.put("mem_pw", "123");
memList.add(memInfo);

memInfo = new HashMap<>();
memInfo.put("mem_name", "유사원");
memInfo.put("mem_id", "yu");
memInfo.put("mem_pw", "123");
memList.add(memInfo);

memInfo = new HashMap<>();
memInfo.put("mem_name", "김부장");
memInfo.put("mem_id", "kim");
memInfo.put("mem_pw", "123");
memList.add(memInfo);

Gson g = new Gson();
String result = g.toJson(memList);
out.print(result);
%>