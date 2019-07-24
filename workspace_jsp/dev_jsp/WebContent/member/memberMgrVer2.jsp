<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>

<body>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#dg_member').datagrid({
				url:"memberList.kos"
				,title:"회원관리 ver1.0"
				,toolbar : '#tb_member'
			    ,columns:[[
			    	//myBatis에서
			    	//Map을 쓰는 경우 default로 나오는 영문 값이 대문자이기 때문에 필드 값을 맞춰야한다
			        {field:'MEM_ID',title:'아이디',width:150},
			        {field:'MEM_NAME',title:'이름',width:150},
			        {field:'MEM_ADDR',title:'주소',width:300,align:'left'}
			    ]]
				
			});	
			$('#dlg_ins').dialog({
				title : "회원가입"
				,closed:true
				,width:450
				,height:510
				,footer:"#tb_ins"
			});
			$("#btn_save").linkbutton({
				onClick:function() {
					//alert("save");
					$("#dlg_ins").dialog('close');
					$("#f_ins").attr('method', 'get');
					$("#f_ins").attr('action', './memberInsert.kos');
					$("#f_ins").submit();
				}
			});
			$("#btn_cancel").linkbutton({
				onClick:function() {
					//alert("cancel");
					$("#dlg_ins").dialog('close');
				}
			});
		});
	</script>
	<table id="dg_member" width="600px"></table>
	<!-- 툴바 영역 -->
	<div id="tb_member" style="padding:5px;">
		 <a id="btn" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-add'" style="width:80px"
		  onclick="$('#dlg_ins').dialog('open')">가입</a>
		 <a id="btn" href="./memberList.kos?work=member" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-search'" style="width:80px">조회</a>
	</div>
	<!-- 다이얼로그창 -->
	<div id="dlg_ins">
		<!-- 
		사용자가 화면에 입력한 값을 서버에 전달 할 때 반드시 name속성이 필요하다
		입력받은 컴포넌트에 값이 담기기 때문에 반드시 form전송으로 처리한다.
		form태그는 여러개를 사용할 수 도 있고 아이디로 구분하여 서로 다른 서버계층으로 전송이 가능하다
		화면에는 존재하지 않지만 개발자가 업무처리를 위한 목적으로 따로 전달하고 싶은 정보가 있을 때도 form태그를 사용함
		이 때 사용하는 컴포넌트는 hidden속성으로 처리한다.
		hidden속성은 input type text 속성과 동일하게 사용하면 된다.
		아이디와 이름 속성을 반드시 부여하여 서버에 전송할 때와 ajax처리 할 때를 준비해둔다.
		아이디는 절대로 중복되면 안된다.
		실제 서버로 전송할 때는 form태그에 메소드 방식과 목적지를 기술하지 않고 jquert api를 사용하여 함수 처리한다.
		화면에 담겨 있는 정보들은 가독성이 떨어지고 화면 내용이 많아지게 되면 찾기가 불편함.
		-->
		<form id="f_ins">
        <div style="margin-bottom:20px; margin-top:10px;" align="center" padding="5px">
            <input class="easyui-textbox" id="mem_id" name="mem_id" label="아이디:" labelPosition="top" style="width:400px;">
        </div>
        <div style="margin-bottom:20px" align="center" padding="5px">
            <input class="easyui-textbox" id="mem_name" name="mem_name" label="이름:" labelPosition="top" style="width:400px;">
        </div>
        <div style="margin-bottom:20px" align="center" padding="5px">
            <input class="easyui-textbox" id="mem_zipcode" name="mem_zipcode" label="우편번호:" labelPosition="top" style="width:400px;">
        </div>
        <div style="margin-bottom:20px" align="center" padding="5px">
            <input class="easyui-textbox" id="mem_addr" name="mem_addr" label="주소:" labelPosition="top" style="width:400px;">
        </div>
        <div align="center" padding="5px">
            <input class="easyui-textbox" id="mem_pw" name="mem_pw" label="비밀번호:" labelPosition="top" style="width:400px;">
        </div>
        	<input type="hidden" id="work" name="work" value="member">
        </form>
	</div>
	
	<div id="tb_ins" style="padding:5px" align="right">
	    <a id="btn_save" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-save'" style="width:80px">저장</a>
	    <a id="btn_cancel" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-cancel'" style="width:80px">닫기</a>
	</div>
	
</body>
</html>