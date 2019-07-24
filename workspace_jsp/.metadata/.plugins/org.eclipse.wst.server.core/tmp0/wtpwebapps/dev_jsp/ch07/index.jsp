<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = request.getParameter("menu");
	out.print(menu);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소프트인재개발원</title>
</head>
<body>
	<table border="0" width="1000px" height="480px">
		<!-- top.jsp -->
		<tr>
			<td>
				<jsp:include page="top.jsp" flush="flase"></jsp:include>
			</td>
		</tr>
		<!-- main과 menu -->
		<tr>
			<td>
				<table border="0" width="100%" height="400px">
					<tr>
						<!-- menu.jsp -->
						<td width="200px" height="400px">
							<!-- 메뉴에는 로그인, 온라인 시험, 게시판 -->
							<jsp:include page="menu.jsp" flush="false"></jsp:include>
						</td>
						<!-- main.jsp -->
						<td width="800px" height="400px">
							<%
								if("login".equals(menu)) {
							%>
								<jsp:include page="login.jsp" flush="flase"></jsp:include>
							<%
								}
								else if("test".equals(menu)) {										
							%>
								<jsp:include page="test.jsp" flush="flase"></jsp:include>
							<%
								}
								else if("board".equals(menu)) {
							%>
								<jsp:include page="board.jsp" flush="flase"></jsp:include>
							<%
								} else {
							%>
								<jsp:include page="main.jsp" flush="flase"></jsp:include>
							<%
								}
							%>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- bottom.jsp -->
		<tr>
			<td>
				<jsp:include page="bottom.jsp" flush="flase"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>