<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>주문확인서</title>
</head>

<body>
    <%
    //스크립틀릿 - html코드 안에 자바 코드를 쓰고 싶을 때
	String user_name = request.getParameter("mem_name");
	String paper = request.getParameter("paper");
    String dep = request.getParameter("mem_addr");
    out.print(user_name+","+paper+","+dep);
    %>

    <table align="center" width="500px" border="1">
        <tr>
            <td>주문자</td>
            <td><%out.print(user_name);%></td>
        </tr>
        <tr>
            <td>주문내용</td>
            <td><%out.print(paper);%></td>
        </tr>
        <tr>
            <td>배송지</td>
            <td><%out.print(dep);%></td>
        </tr>

    </table>
</body>

</html>