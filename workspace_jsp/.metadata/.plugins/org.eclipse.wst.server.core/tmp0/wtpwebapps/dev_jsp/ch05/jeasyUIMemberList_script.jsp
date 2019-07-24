<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 유저가 보는 뷰 --%>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/demo/demo.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function memberList() {
			$("#dg_member").datagrid({
				url : "./memberList.do"
				,onLoadSuccess : function(data) {
					alert("성공");
				}
			});
		}
	</script>
	<meta charset="UTF-8">
	<title>회원목록</title>
</head>

<body>
<!-- 조회결과 존재-->
<!--========= table 태그 시작 =========-->
	<table id="dg_member" toolbar="#tb_member" class="easyui-datagrid" 
	title="회원목록" width="400px" border="1">
		<thead>
			<tr>
				<th data-options="field:'mem_id', width:80">아이디</th>
				<th data-options="field:'mem_pw', width:80">비밀번호</th>
				<th data-options="field:'mem_name', width:80">이름</th>
			</tr>
		</thead>
	</table>
	<!-- 테이블 안에 들어갈 링크 버튼 추가 -->
	<div id="tb_member" >
		<a href="javascript:memberList()" class="easyui-linkbutton" 
		data-options="iconCls:'icon-search'"
		style="width:80px">조회</a>
	</div>
</body>

</html>