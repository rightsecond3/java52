<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");
	String dap2 = request.getParameter("dap2");
	String dap3 = request.getParameter("dap3");
	String daps[] = {dap1,dap2,dap3};
	String jungdaps[] = {"2","1","4"};
	int rightNum = 0;
	int wrongNum = 0;
	for(int i=0;i<jungdaps.length; i++) {
		if(jungdaps[i].equals(daps[i])) {
			rightNum++;
		} else {
			wrongNum++;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채점 결과</title>
</head>
<body>
	<div>
	정답 수 : <%=rightNum %>
	<br>
	오답 수 : <%=wrongNum %>
	</div>
</body>
</html>