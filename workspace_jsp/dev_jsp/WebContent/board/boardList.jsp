<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 총 레코드 갯수 - 아작스 활용하여 해결
/* 	int tot = 0;
	if(session.getAttribute("s_tot")!=null) {
		tot = Integer.parseInt(session.getAttribute("s_tot").toString());
	}
	out.print("tot : "+tot); */
%>
<!-- 
	화면처리를 태그로 할 때와 스크립트로 할 때
	1. 태그안에 코드를 작성하면 디자인과 코드가 분리가 안되서 가독성이 떨어짐.
	2. 스크립트로 처리할 때 화면에서 코드가 분리됨.(이벤트 처리나 DOM 조작하는 코드 작성 시 접근성이 좋다.)
	3. 화면과 스크립트 코드를 분리할 시 react적용 시 라이프 사이클에 따라 코드 적용이 용이하다.
-->
<!-- 
	body태그에서 getBoardList()함수를 호출하여
	서블릿을 경유하게 되는데 왜 이땐 session값이 0인 걸까요?
	결론
	세션과 쿠키 모두 생성되자마자 화면에 반영되지 않는다.
	그 이유는 세션과 쿠키는 모두 서버단에서 일어나는 사건이고
	화면은 이미 사용자측에서 랜더링이 끝난 상태이므로 시점 문제가 발생
	따라서, 생성된 시점에서 현재 바라보고 있는 페이지에서는 그 값을 확인 할 수 없다.
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC패턴을 적용한 계층형 게시판</title>
<%@ include file="/common/JEasyUICommon.jsp" %>
	<script type="text/javascript">
		//* pageMove : 페이지네이션 페이지 이동시 사용하는 함수
		function pageMove(pageNumber, pageSize) {
			var cb_value = user_combo; // 콤보박스 값
			var tb_value = $("#keyword").val(); // 사용자가 검색한 값
			var bm_value = $("#bm_date").val(); // 데이트박스 값
			$("#dg_board").datagrid({
				url:"/board/test.mo?crud=boardList&keyword="+tb_value
												+"&cb_value="+cb_value
												+"&bm_date="+bm_value			
												+"&pageNumber="+pageNumber		
												+"&pageSize="+pageSize
			});
		}
		//* boardList
		function boardList() {
			var cb_value = user_combo; // 콤보박스 값
			var tb_value = $("#keyword").val(); // 사용자가 검색한 값
			var bm_value = $("#bm_date").val(); // 데이트박스 값
			if(pn_pageNumber == null || pn_pageSize == null) {
				pn_pageNumber = 1;
				pn_pageSize = 5;
			}
			$("#dg_board").datagrid({
				url:"/board/test.mo?crud=boardList&keyword="+tb_value
												+"&cb_value="+cb_value
												+"&bm_date="+bm_value
												+"&pageNumber="+pn_pageNumber
												+"&pageSize="+pn_pageSize
				,onLoadSuccess: function(data) {
					$.ajax({
						method:"GET"
						,url:"/board/test.mo?crud=total&keyword="+tb_value
														+"&cb_value="+cb_value
						,success: function(result) {
							$("#pn_board").pagination({
								total:result			
							});
						}
					});
				}
			});
		}
		//* addForm
		function addForm() {
			//alert("입력화면");
			$("#dlg_boardAdd").dialog('open');
		}
		//* updForm
		function updForm() {
			alert("수정화면");
		}
		//* delForm
		function delForm() {
			alert("삭제화면");
		}
		//addAction : form 전송
		function addAction() {
			if($("#bm_title").val()==null || $("#bm_wirter").val()==null
				|| $("#bm_content").val()==null || $("#bm_pw").val()==null) {
				alert("필수 입력사항을 입력하세요.");
				return;
			} else {
				$("#f_boardAdd").attr("method","post");
				$("#f_boardAdd").attr("action","/board/test.mo?crud=boardAdd");
				$("#f_boardAdd").submit();
			}
		}
	</script>	
</head>

<body onload="boardList()">
	<script type="text/javascript">
		var user_combo; // 콤보박스에서 선택한 값 담기
		var tb_value; 
		var pn_pageNumber; 
		var pn_pageSize;
		var g_no; // 사용자가 제목을 더블클릭 했을 시 hidden 값인 bm_no를 담는 변수
		// 날짜 포멧을 설정해주는 함수
		$.fn.datebox.defaults.formatter = function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10 ? "0"+m:m)+'-'+(d<10 ? "0"+d:d);
		}
		// 새로운 날짜 포멧을 적용해주는 함수
		$.fn.datebox.defaults.parser = function(s){
			var t = Date.parse(s);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
		}
		// DOM 구성이 완료된 후
		$(document).ready(function() {
			//* dg_board - datagrid 초기화 및 설정
			$("#dg_board").datagrid({
				toolbar:'#tb_board, #tb_search'
				,rownumbers:'true'
				,footer:'#pn_board'
				,singleSelect:true
			    ,columns:[[
			    	// hidden 화면에는 나오지 않지만 데이터는 가지고 있다.
			        {field:'BM_NO',title:'글번호',width:100,hidden:'true'}
			        ,{field:'BM_TITLE',title:'제목',width:350}
			        ,{field:'BM_WRITER',title:'작성자',width:100}
			        ,{field:'BM_DATE',title:'작성일',width:150}
			        ,{field:'BS_FILE',title:'첨부파일',width:100}
			        ,{field:'BM_HIT',title:'조회수',width:100}
			    ]]
				,onSelect: function(index, row) {
					//alert("해당 셀의 BM_NO : "+row.BM_NO);
					g_no = row.BM_NO;
				}
				,onDblClickCell: function(index,field,value){
					// 제목을 더블클릭
					if("BM_TITLE"==field) {
						cmm_window_popup("test.mo?crud=boardDetail&bm_no="+g_no,"720","450","read");
						// 선택한 로우 값 초기화
						$("#dg_board").datagrid('clearSelections');
					}
					// 첨부파일 더블클릭
					else if("BS_FILE"==field) {
						location.href="downLoad.jsp?bs_file="+value;
					}
				}
			});
			//* cb_search - combobox 이벤트 처리(값 가져오기)
			$("#cb_search").combobox({
				onChange:function(newValue,oldValue) {
					//user_combo = $(this).combobox('getValue');
					user_combo = newValue;
				}
			});
			//* keyword - textbox 엔터 이벤트
			$("#keyword").textbox('textbox').bind('keydown', function(e){
				if(e.keyCode == 13) {
					boardList();
				}
			});
			//* pn_board - pagination
			$('#pn_board').pagination({
				pageList:[5,10,15,20]
				,pageSize:5
				// 페이지 이동 시 이벤트 처리
				// 1) 현재 내가 바라보는 페이지, 2) 한 페이지에 보여 줄 로우의 수
				,onSelectPage: function(pageNumber, pageSize) {
					pageMove(pageNumber, pageSize);
					pn_pageNumber = pageNumber;
					pn_pageSize = pageSize;
	            }
			});
		});
	</script>
	<!-- =============[[글 목록 화면_jEqsyUI DataGrid API]]============== -->
	<!-- 1)익스프레션을 이용해서 화면처리  :td, td 태그를 직접 작성하여 처리 -->
	<!-- 2)json포멧으로 처리해서 매핑  : field명만 맞춰주면 자동 매핑 -->
	<table id="dg_board" class="easyui-datagrid" title="글목록" style="width:900px;height:400px;">
		
	</table>
	<!-- [툴바부분] -->
    <div id="tb_search" style="padding:2px 5px;">
    	<select id="cb_search" name="cb_search" class="easyui-combobox" panelHeight="auto" style="width:100px"
    	data-options="editable:false">
    		<option selected value="">전체조회</option>
    		<option value="bm_title">제목</option>
    		<option value="bm_content">내용</option>
    		<option value="bm_writer">작성자</option>
    	</select>
    	<input class="easyui-textbox" id="keyword" name="keyword" style="width:400px;" plain="true"
    	data-options="prompt:'Search...'">
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	작성일 : <input class="easyui-datebox" id="bm_date" name="bm_date" style="width:120px">
    </div>
    <div id="tb_board" style="padding:2px 5px;">
        <a href="javascript:boardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
        <a href="javascript:addForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
        <a href="javascript:updForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">수정</a>
        <a href="javascript:delForm()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
    </div>
    <!-- [페이지네이션 부분] - 데이터 그리드 하단 페이지 표시부-->
    <div id="pn_board" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;"></div>
	<!-- =============[[글 쓰기 화면_jEasyUI Dialog API]]============== -->
	<div id="dlg_boardAdd" class="easyui-dialog" style="width:600px;height:400px;padding:20px" title="글 쓰기"
	data-options="closed:true,modal:true,footer:'#tbar_boardAdd'">
		<!-- 첨부파일을 보낼 시 GET방식이 사용되지 않음 POST 방식으로 바꿔줘야한다. -->
		<!-- 해당 방식(enctype="multipart/form-data")을 쓸 경우 req객체로 값을 가져올 수 없기 때문에 cost.jar 오픈소스를 활용한다. -->
		<form id="f_boardAdd" metod="post" enctype="multipart/form-data">
			<input type="hidden" name="bm_no" value="0" />
			<input type="hidden" name="bm_pos" value="0" />
			<input type="hidden" name="bm_step" value="0" />
			<input type="hidden" name="bm_group" value="0" />
			<table>
				<tr>
					<td width="100px">&nbsp;&nbsp;제목</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_title" name="bm_title" required style="width:400px;">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;작성자</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_wirter" name="bm_writer" required style="width:400px;">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;이메일</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_email" name="bm_email" style="width:400px;">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;내용</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_content" name="bm_content" required style="width:400px;height:90px;"
						data-options="multiline:'true'">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;비밀번호</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_pw" name="bm_pw" required style="width:400px;">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;첨부파일</td>
					<td width="500px">
						<input class="easyui-filebox" id="bs_file" name="bs_file" style="width:400px;">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- [입력 화면 버튼 추가] -->
	<div id="tbar_boardAdd" align="right">
		<a href="javascript:addAction()" class="easyui-linkbutton" plain='true'
		iconCls='icon-save'>저장</a>
		<a href="javascript:$('#dlg_boardAdd').dialog('close')" class="easyui-linkbutton" plain='true'
		iconCls='icon-cancel'>닫기</a>
	</div>
</body>

</html>