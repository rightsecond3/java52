<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>
<%@ page import="java.util.HashMap"%>
<!-- 
이 파일을 json 포맷으로 출력해주는 파일 입니다.
이 주석은 응답페이지에 출력되는 주석이므로 반드시 jsp주석을 사용할 것.
테스트 하기
오라클 서버 : 211.45.89.50
오라클 계쩡 : scott/tiger
톰캣 서버 주소 : 192.168.0.211
-->
<%-- <json:useBean id="a" class="com.basic.A" scope="page"/> --%>
<%
	List<Map<String, Object>> deptList = new ArrayList<>();
	Map<String, Object> pMap = new HashMap<>();
	pMap.put("deptno", 10);
	pMap.put("dname", "영업부");
	pMap.put("loc", "인천");
	deptList.add(pMap);
	
	pMap = new HashMap<>();
	pMap.put("deptno", 20);
	pMap.put("dname", "총무부");
	pMap.put("loc", "서울");
	deptList.add(pMap);
	
	pMap = new HashMap<>();
	pMap.put("deptno", 30);
	pMap.put("dname", "관리부");
	pMap.put("loc", "대전");
	deptList.add(pMap);
	
	//out.print(deptList); JSON포맷이 아니다
	Gson gson = new Gson();
	String temp = gson.toJson(deptList);
	out.print(temp);
%>