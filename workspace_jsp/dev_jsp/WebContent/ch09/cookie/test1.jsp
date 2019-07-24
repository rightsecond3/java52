<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<%@include file="/common/JEasyUICommon.jsp" %>
	<script type="text/javascript">
		//체크박스 선택된것 해제시켜주기 - 선택 유무 - 멀티 초이스 막기
		function answer(p_dap) {
			for(var i=0;i<document.getElementById("f_test1").cb.length;i++) {
				if(p_dap==i) { //0이 아닐 경우 다 true
					document.getElementById("f_test1").cb[i].checked=1;
				} else {
					document.getElementById("f_test1").cb[i].checked=0;
				}
			}
		}
		//다음 문제 선택시 이전문제 답안지 기억하기 - hidden 속성
		function next() {
			var temp = 1;
			for(var i=0;i<document.getElementById("f_test1").cb.length;i++) {
				if(document.getElementById("f_test1").cb[i].checked==1) {
					document.getElementById("f_test1").dap1.value = temp;
				} else {
					temp = temp + 1;
				}
			}
			document.getElementById("f_test1").submit();
		}
	</script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#p_test1").panel({
				fit:true
				,border:false
				,footer:'#footer'
			});
			// type="checkbox"인 갯수 만큼 반복한다.
<%-- 			for(var i=0;i<document.getElementById("f_test1").cb.length;i++) {
				//alert(document.getElementById("f_test1").cb[i].value);
				// test2.jsp에서 이전 버튼을 눌렀을 때 이전 test1.jsp의 답이 해당 value값과 일지할 경우
				// 체크해주고 일치하지 않을경우 전부 체크 해제
				if(<%=dap1%> == document.getElementById("f_test1").cb[i].value) {
					document.getElementById("f_test1").cb[i].checked=1;
				} else {
					document.getElementById("f_test1").cb[i].checked=0;
				}
			} --%>
		});
	</script>
	<!-- 패널이 오는 구역 -->
	<div class="easyui-panel" id="p_test1" title="문제1" style="width:600px;height:100px">
		<form id="f_test1" name="f_test1" method="get" action="test2.jsp">
			<input type="hidden" id="dap1" name="dap1"/>
			<div>
				문제1 : DML구문 중에서 성격이 다른 하나를 고르시오.
			</div>
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test1" name="cb" value="1" onChange="answer(0)">
			1. INSERT
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test1" name="cb" value="2" onChange="answer(1)">
			2. SELECT
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test1" name="cb" value="3" onChange="answer(2)">
			3. UPDATE
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test1" name="cb" value="4" onChange="answer(3)">
			4. DELETE
		</form>
	</div>
	<!-- 패널의 푸터가 오는 구역 -->
    <div id="footer" style="padding:5px;" align="right">
	    <!-- <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">이전</a> -->
	    <a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">다음</a>
    </div>
</body>
</html>