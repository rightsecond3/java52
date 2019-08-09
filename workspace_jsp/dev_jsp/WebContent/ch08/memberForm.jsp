<%@page import="com.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<!-- html, css, javascript 땅 -->

<%//** 기존의 사용 방법 **//
	//자바 땅
	//스크립틀릿 - 지역변수, 메소드선언불가, 생성자 불가, 제어문 가능, 인스턴스화 가능
	MemberVO mVO = new MemberVO(); // 순제어-자신이 필요할 때 직접 인스턴스화 하여 직접 관리
	mVO.setMem_id("test");
	mVO.setMem_name("김유신");
%>
<%=mVO.getMem_id() %>, <%=mVO.getMem_name() %>

<!-- useBean으로 객체 생성 -->
<br>
<jsp:useBean id="mVO2" scope="request" class="com.vo.MemberVO" />
<jsp:setProperty property="mem_id" name="mVO2" value="Mr.Lee"/>
아이디 : <jsp:getProperty property="mem_id" name="mVO2"/>
<br>
<jsp:setProperty property="mem_name" name="mVO2" value="이순신" />
이름 : <jsp:getProperty property="mem_name" name="mVO2"/>
</body>
</html>