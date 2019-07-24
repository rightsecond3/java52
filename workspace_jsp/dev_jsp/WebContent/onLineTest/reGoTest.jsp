<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험응시</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function (){
			$('#cb_subject').combobox({
			    url:'subjectList.kos?work=onLineTest'
			    ,valueField:'SUB_CD'
			    ,textField:'SUB_NAME'
			    ,prompt : '수험번호를 선택하세요.'
			    ,panelHeight:'auto'
			    ,editable:false
			    ,onSelect:function(record) {
			    	alert(record.SUB_NAME);
			    }
			    	
			});
		});
	</script>
	
	<div class="easyui-panel" title="Test Take" style="width:100%;max-width:400px;padding:30px 30px">
		<div style="margin-bottom:20px">
			<select class="easyui-combobox" id="cb_subject" label="수험과목 :" labelPosition="left" style="width:100%;">
			</select>
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" label="수험번호" labelPosition="left" style="width:150px">
		</div>
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">시험시작</a>
		</div>
	</div>
</body>
</html>