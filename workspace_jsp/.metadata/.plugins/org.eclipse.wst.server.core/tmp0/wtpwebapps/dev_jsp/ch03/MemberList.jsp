<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
이 페이지는 dev_jsp/ch03/MemberList
해당 파일을 요청하면 톰캣서버는 자신이 바라보는 경로에서 해당 페이지를 찾음.
MemberList_jsp.java로 변환 -> MemberList_jsp.class 컴파일
-> 실행 -> 태그 생성 -> 생성된 태그와 아래 태그들을 개인 컴퓨터에 다운로드
-> DOM출력 -> 사용자의 브라우저를 통해 다운로드 된 것 출력
*/
	String name = "이순신";
	out.print("너의 이름 : "+name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		var	s_name = '김유신';
	</script>
</head>

<body>
	여기는 html 영역입니다.
	<div id='d_msg'></div>
	<script type="text/javascript">
		//익스프레션 부분은 서버에서 실행된 값을 가져오는 것 이기 때문에 항상 고정값
		//화면 단에서 바꿀 수 없다. -> 유연하지 않다.
		s_name = '<%=name%>';
		//실행 주체 : 클라이언트
		document.getElementById("d_msg").innerHTML = s_name;
	</script>
</body>

</html>