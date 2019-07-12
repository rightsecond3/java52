<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html땅 -->
<%!
/* 자바땅 */
	//Declaration
	int i; //Declarration안의 변수는 전역 변수
	public String methodA(int i) {
		i = 100;
		return "hello";
	}
%>
<%
	String insa = methodA(10);
	out.print("insa : "+insa+"<hr>");
	//Scriptlet
	String name = null; //스클립틀릿 안에서의 변수는 지역번수
	name = "이성계";
	out.print(name);//이성계
	out.print("<br>"); //줄바꿈 처리
	out.print(i); //0
%>
<%=
	//Expression
	"문자열"
%>
</body>
</html>