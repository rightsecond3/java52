<%@page import="com.vo.ZipCodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ZipCodeVO> zipList = (List<ZipCodeVO>) request.getAttribute("zipList");
	int size = 0;
	if(zipList!=null && zipList.size()>0) {
		size = zipList.size();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>

<body>
	<script type="text/javascript">
		//전역변수 선언 - 선택한 로우의 주소를 담는다.
		var g_address;
		$(document).ready(function(){
			$('#dg_member').datagrid({
				url:"memberList.kos?work=member"
				,title:"회원관리 ver1.0"
				,toolbar : '#tb_member'
				,singleSelect : true
			    ,columns:[[
			    	//myBatis에서
			    	//Map을 쓰는 경우 default로 나오는 영문 값이 대문자이기 때문에 필드 값을 맞춰야한다
			        {field:'MEM_ID',title:'아이디',width:150},
			        {field:'MEM_NAME',title:'이름',width:150},
			        {field:'MEM_ZIPCODE',title:'도시코드',width:100,align:'left'},
			        {field:'MEM_ADDR',title:'주소',width:300,align:'left'},
			        {field:'MEM_PW',title:'비밀번호',width:100,align:'left'}
			    ]]
			});	
			$('#dg_zipcode').datagrid({
				url:"#"
				,title:"우편번호 검색"
				,singleSelect : true
				,columns:[[
			        {field:'zipcode',title:'우편번호',width:100, align:'center'},
			        {field:'address',title:'주소',width:500}
			    ]]
			});
			$('#dlg_ins').dialog({
				title : "회원가입"
				,closed:true
				,width:450
				,height:510
				,footer:"#tb_ins"
				,modal:true
			});
			$('#dlg_upd').dialog({
				title : "수정"
				,closed:true
				,width:450
				,height:510
				,footer:"#tb_upd"
				,modal:true
			});
			$("#btn_save").linkbutton({
				onClick:function() {
					$("#dlg_ins").dialog('close');
					$("#f_ins").attr('method', 'get');
					$("#f_ins").attr('action', './memberInsert.kos');
					$("#f_ins").submit();
				}
			});
			$("#btn_cancel").linkbutton({
				onClick:function() {
					$("#dlg_ins").dialog('close');
				}
			});
			$("#btn_dlg_ins").linkbutton({
				onClick:function() {
					$("#dlg_ins").dialog('open');
				}
			});
			$("#dlg_zipcode").dialog({
				title : "우편번호 검색"
				,closed:true
				,width:600
				,height:500
				,modal:true
			});
			$("#btn_zipcode").linkbutton({
				onClick:function() {
					$('#dlg_zipcode').dialog('open');
				}
			});
			$("#dong").textbox('textbox').bind('keydown', function(e){
				if (e.keyCode == 13){	// when press ENTER key, accept the inputed value.
					//t.textbox('setValue', $(this).val());
					//우편번호 데이터 초기화 하기
					$("#dg_zipcode").datagrid({
						//this -> $(#dong)
						url:"./zipcodeList.kos?work=member&dong="+$(this).val()
						,onSelect: function(index, row) {
							g_address = row.address;
						} 
						,onDblClickCell: function(index,field,value){
							//alert("index :"+index+", field :"+field+", value :"+value);
							if('zipcode'==field) {
								//우편번호 textbox에 출력 id
								$("#mem_zipcode").textbox('setValue', value);
								$("#mem_addr").textbox('setValue', g_address);
								//선택된 로우 해제 시키기
								$("#dg_zipcode").datagrid('clearSelections');
								$("#dlg_zipcode").dialog('close');
							}
							else {
								alert("우편번호를 선택하세요.");
							}
						}
					});
				}
			});
			/*
			주소창에 꽃히게도 해보기
			*/
			$("#btn_search").linkbutton({
				onClick:function() {
					var u_dong = $("#dong").val();
					$.ajax({
						method:'GET'
						,url:'member/zipcodeList.kos?work=member&dong='+u_dong
						,suceess :function(data) {
							alert('data '+data);
							$("#dg_zipcode").datagrid({
								
							});
						}	
					});
				}
			});
			$("#btn_dlg_upd").linkbutton({
				onClick:function() {
					//해당 로우의 값들을 가져와야함
					var user = $("#dg_member").datagrid('getSelected');
					if(user==null) {
						alert("수정할 사원을 선택하세요");
					}
					else {
					$('#dlg_upd').dialog('open');
					$("#upd_mem_id").textbox('setValue', user.MEM_ID);
					$("#upd_mem_name").textbox('setValue', user.MEM_NAME);
					$("#upd_mem_zipcode").textbox('setValue', user.MEM_ZIPCODE);
					$("#upd_mem_addr").textbox('setValue', user.MEM_ADDR);
					$("#upd_mem_pw").textbox('setValue', user.MEM_PW);
					}
				}
			});
			$("#upd_btn_update").linkbutton({
				onClick:function() {
					$("#dlg_upd").dialog('close');
					$("#f_upd").attr('method', 'get');
					$("#f_upd").attr('action', './memberUpdate.kos?work=member');
					$("#f_upd").submit();
				}
			});
			$("#upd_btn_cancel").linkbutton({
				onClick:function() {
					$("#dlg_upd").dialog('close');
				}
			});
		});//////end of document.ready
		function deleteRow() {
			alert("deleteRow 호출성공 ");
            $.messager.confirm('Confirm', '정말 삭제하시겠습니까?', function(r) {
                if(r) {
                	var u_id = $("#dg_member").datagrid('getSelected');
                	alert(u_id.MEM_ID);
                    if(u_id==null) {
                    	alert(u_id);
                    	alert("삭제할 사원을 선택하세요.");
                    	return;
                    } else {
                    	location.href="./memberDelete.kos?work=member&mem_id="+u_id.MEM_ID;
                    }
                }
            });
		}

	</script>
	<table id="dg_member" width="800px"></table>
	<!-- 툴바 영역 -->
	<div id="tb_member" style="padding:5px;">
		 <a id="btn_dlg_ins" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-add'" style="width:80px">가입</a>
		 <a id="btn_dlg_upd" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-edit'" style="width:80px">수정</a>
		 <a id="btn_dlg_del" href="javascript:deleteRow()" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-remove'" style="width:80px">삭제</a>
	</div>
	<!-- 우편번호 검색기 -->
	<div id="dlg_zipcode" class="easyui_dialog" style="width:100%;max-width:600px;padding:30px 30px">
		<input class="easyui-textbox" id="dong" name="dong" data=options="promt:'Enter a dong'" style="width:210px;">
	    <a id="btn_zipSearch" href="#" class="easyui-linkbutton" 
		data-options="iconCls:'icon-search'" style="width:100">찾기</a>
		<div style="margin-bottom:10px"></div>	
		<!-- zipcode 데이터 그리드 -->			
		<table id="dg_zipcode" width="550px"></table>
	</div>
	<!-- 회원 가입 다이얼로그창 -->
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
            <input class="easyui-textbox" id="mem_zipcode" name="mem_zipcode" label="우편번호:" labelPosition="top" style="width:300px;">
            <a id="btn_zipcode" href="#" class="easyui-linkbutton">우편번호찾기</a>
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
	
	<!-- 수정다이얼로그창 -->
	<div id="dlg_upd">
		<form id="f_upd">
        <div style="margin-bottom:20px; margin-top:10px;" align="center" padding="5px">
            <input class="easyui-textbox" id="upd_mem_id" name="mem_id" label="아이디:" editable="false" labelPosition="top" style="width:400px;">
        </div>
        <div style="margin-bottom:20px" align="center" padding="5px">
            <input class="easyui-textbox" id="upd_mem_name" name="mem_name" label="이름:" labelPosition="top" style="width:400px;">
        </div>
        <div style="margin-bottom:20px" align="center" padding="5px">
            <input class="easyui-textbox" id="upd_mem_zipcode" name="mem_zipcode" label="우편번호:" labelPosition="top" style="width:300px;">
            <a id="btn_zipcode" href="#" class="easyui-linkbutton">우편번호찾기</a>
        </div>
        <div style="margin-bottom:20px" align="center" padding="5px">
            <input class="easyui-textbox" id="upd_mem_addr" name="mem_addr" label="주소:" labelPosition="top" style="width:400px;">
        </div>
        <div align="center" padding="5px">
            <input class="easyui-textbox" id="upd_mem_pw" name="mem_pw" label="비밀번호:" labelPosition="top" style="width:400px;">
        </div>
        	<input type="hidden" id="work" name="work" value="member">
        </form>
	</div>
	
	<!-- 입력 버튼 다이얼로그 창에 붙을 푸터 -->
	<div id="tb_ins" style="padding:5px" align="right">
	    <a id="btn_save" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-save'" style="width:80px">저장</a>
	    <a id="btn_cancel" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-cancel'" style="width:80px">닫기</a>
	</div>
	
	<!-- 수정 버튼 다이얼로그 창에 붙을 푸터 -->
	<div id="tb_upd" style="padding:5px" align="right">
	    <a id="upd_btn_update" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-edit'" style="width:80px">수정</a>
	    <a id="upd_btn_cancel" href="#" class="easyui-linkbutton" 
		  data-options="iconCls:'icon-cancel'" style="width:80px">닫기</a>
	</div>
	
</body>
</html>
