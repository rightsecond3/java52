<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.google.gson.Gson" %>
<%
String mem_tel = request.getParameter("mem_tel");
List<Map<String,Object>> memList = new ArrayList<>();
Map<String,Object> memInfo = new HashMap<>();
memInfo.put("mem_name","이순신");
memInfo.put("mem_addr","서울시 마포구 공덕동");
memInfo.put("mem_tel","025559999");
memList.add(memInfo);

memInfo = new HashMap<>();
memInfo.put("mem_name","김유신");
memInfo.put("mem_addr","서울시 영등포구 당산동");
memInfo.put("mem_tel","026669999");
memList.add(memInfo);

memInfo = new HashMap<>();
memInfo.put("mem_name","강감찬");
memInfo.put("mem_addr","서울시 구로구 개봉동");
memInfo.put("mem_tel","027779999");
memList.add(memInfo);

//구글에서 제공하는 오픈 API를 사용하여 JSON포맷으로 꺼내기
Gson g = new Gson();
String result = g.toJson(memList);
//picList가 아닌 Json포맷으로 변형된 result를 넘겨야 된다.
out.print(result);
%>
