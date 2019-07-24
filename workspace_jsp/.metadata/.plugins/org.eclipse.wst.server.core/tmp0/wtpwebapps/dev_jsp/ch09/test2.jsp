<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");
	String dap2 = request.getParameter("dap2");
	//out.print(dap1);
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	//체크박스 선택된것 해제시켜주기 - 선택 유무 - 멀티 초이스 막기
	function answer(p_dap) {
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++) {
			if(p_dap==i) { //0이 아닐 경우 다 true
				document.getElementById("f_test2").cb[i].checked=1;
			} else {
				document.getElementById("f_test2").cb[i].checked=0;
			}
		}
	}
	//다음 문제 선택시 이전문제 답안지 기억하기 - hidden 속성
	function next() {
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++) {
			if(document.getElementById("f_test2").cb[i].checked==1) {
				document.getElementById("f_test2").dap2.value = temp;
			} else {
				temp = temp + 1;
			}
		}
		document.getElementById("f_test2").submit();
	}
	//이전 문제로 돌아가는 함수 -- hiddend
	function prev() {
		location.href = "test1.jsp?dap1=<%=dap1%>";
	}
	</script>
<meta charset="UTF-8">
<title>문제2</title>
<%@include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#p_test2").panel({
				fit:true
				,border:false
				,footer:'#footer'
			});
			// type="checkbox"인 갯수 만큼 반복한다.
			for(var i=0;i<document.getElementById("f_test2").cb.length;i++) {
				//alert(document.getElementById("f_test1").cb[i].value);
				// test2.jsp에서 이전 버튼을 눌렀을 때 이전 test1.jsp의 답이 해당 value값과 일지할 경우
				// 체크해주고 일치하지 않을경우 전부 체크 해제
				if(<%=dap2%> == document.getElementById("f_test2").cb[i].value) {
					document.getElementById("f_test2").cb[i].checked=1;
				} else {
					document.getElementById("f_test2").cb[i].checked=0;
				}
			}
		});
	</script>
	<!-- 패널이 오는 구역 -->
	<div class="easyui-panel" id="p_test2" title="문제2" style="width:600px;height:100px">
		<form id="f_test2" method="get" action="test3.jsp">
			<input type="hidden" name="dap1" value="<%=dap1%>">
			<input type="hidden" name="dap2">
			<div>
				문제2 : 다음 중 문자열을 잘라주는 오라클 함수를 고르시오.
			</div>
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test2" name="cb" value="1" onChange="answer(0)">
			1. SUBSTR
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test2" name="cb" value="2" onChange="answer(1)">
			2. ROUND
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test2" name="cb" value="3" onChange="answer(2)">
			3. NVL
			<div style="margin-bottom:20px;"></div>
			<input type="checkbox" id="test2" name="cb" value="4" onChange="answer(3)">
			4. TO_CHAR
		</form>
	</div>
	<!-- 패널의 푸터가 오는 구역 -->
    <div id="footer" style="padding:5px;" align="right">
	    <a href="javascript:prev()" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">이전</a>
	    <a href="javascript:next()" class="easyui-linkbutton" data-options="iconCls:'icon-redo'">다음</a>
    </div>
</body>
</html>