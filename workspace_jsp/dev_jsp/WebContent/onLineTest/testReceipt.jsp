<%@page import="com.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mVO = (MemberVO) session.getAttribute("rmVO");
	String s_memid = null;
	String s_memname = null;
	if(mVO != null) {
		s_memid = mVO.getMem_id(); // 사용자가 입력한 mem_id 
		s_memname = mVO.getMem_name();
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>자격시험 접수 - 정보처리기사</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	function receipt() {
		$("#f_receipt").attr("method", "get");
		$("#f_receipt").attr("action", "examReceipt.kos");
		$("#f_receipt").submit();
	}
</script>
</head>

<body>
	<script type="text/javascript">
		// 데이터 포멧가져오기
		$.fn.datebox.defaults.formatter = function(date){
			var y = date.getFullYear();
			//달은 0~11을 리턴해주기 때문에 1을 더해준 것
			var m = date.getMonth()+1;
			var d = date.getDate();
			// 삼항 연산자 (조건 ? 참 : 거짓)
			return y+'-'+(m<10 ? ('0'+m) : m)+'-'+(d<10?('0'+d) : d);
		}
		// 선택한 날짜 가져오기
		$.fn.datebox.defaults.parser = function(s){
			var t = Date.parse(s);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
		}
		$(document).ready(function() {
			$("#mem_name").textbox('setValue', '<%=s_memname%>');
			//* 콤보박스 초기화
			$('#cb_subject').combobox({
			    url:'subjectList.kos?work=onLineTest'
			    ,valueField:'SUB_CD' // 서버에 넘어가는 값
			    ,textField:'SUB_NAME' //화면에 출력하는 값
			    ,prompt : '수험번호를 선택하세요.'
			    ,panelHeight:'auto'
			    ,editable:false
			    ,onSelect:function(record) {
			    	alert(record.SUB_NAME);
			    }
			});
			// jQuery에서 제공하는 attr()메소드에 쿼리스트링은 값이 넘어가지 않음 : 결함. -> hidden으로 처리해라.
		});
	</script>
	<!-- 패널 부분 -->
	<div class="easyui-panel" title="자격시험 접수" style="width:100%;max-width:450px;padding:30px 30px">
		<!-- form -->
		<form id="f_receipt">
		<input type="hidden" id="mem_id" name="mem_id" value="<%=s_memid %>" />
		<input type="hidden" id="work" name="work" value="onLineTest" />
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" id="mem_name" name="mem_name" label="이름 :" labelPosition="left" style="width:160px" editable=false>
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-datebox" id="exam_date" name="exam_date" label="응시일자 :" labelPosition="left" style="width:200px">
		</div>
		<div style="margin-bottom:20px">
			<select class="easyui-combobox" id=cb_subject name="sub_cd" label="수험과목 :" labelPosition="left" style="width:300px">
			</select>
		</div>
		<div>
			<a href="javascript:receipt()" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">접수</a>
		</div>
		</form>
		<!-- /from -->
	</div>
	
</body>

</html>