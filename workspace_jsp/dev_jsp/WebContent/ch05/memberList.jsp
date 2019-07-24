<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
	테스트 시나리오 - 사용자 메뉴얼
	1.memberList.do
	2.memberList.jsp
*/
//jsp과목 - 50% DB연동
	List<Map<String, Object>> memList
	= (List<Map<String, Object>>) request.getAttribute("memList");
	int size = 0;
	if(memList != null && memList.size() != 0) {
		size = memList.size(); //NullPointerException 방지
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>

<body>
<!-- 조회결과 존재-->
<!--========= table 태그 시작 =========-->
<table width="400px" border="1">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
	</thead>
<%
	if(size>0) {
		for(int i=0;i<size;i++) {
			Map<String, Object> rMap = memList.get(i);
%>
		<!-- data출력 -->
		<tr>
			<td><%= rMap.get("mem_id") %></td>
			<td><%= rMap.get("mem_pw") %></td>
			<td><%= rMap.get("mem_name") %></td>
		</tr>
<%			
		}//////end of for
%>
<!-- 조회결과 존재X -->
<%
	}/////end of if
	else{
		
%>
	<!-- 조회된 데이타가 없습니다 -->
	<tr>
		<td colspan="3" align="center">조회된 결과가 없습니다.</td>
	</tr>
<%
	}/////end of else if
%>
</table>
<!--========= table 태그 끝 =========-->
<%
Gson gson = new Gson();
String temp = gson.toJson(memList);
out.print(temp);
%>
</body>

</html>