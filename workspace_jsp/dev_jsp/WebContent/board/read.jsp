<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Map<String, Object>> boardDetail 
	= (List<Map<String, Object>>) request.getAttribute("boardDetail");
	Map<String, Object> rMap = null;
	if(boardDetail != null) {
		rMap = boardDetail.get(0);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/JEasyUICommon.jsp"%>
	<script type="text/javascript">
		function addAction() {
			$("#f_boardAdd").attr('method','post');
			$("#f_boardAdd").attr('action','/board/test.mo?crud=boardAdd');
			$("#f_boardAdd").submit();
			// 부모창의 함수를 호출 할 때 opener.함수명()
			opener.boardList();
			self.close();
		}
		// 댓글쓰기
		function repleForm() {
			$("#dlg_boardAdd").dialog('open');
		}
		// 수정
		function editForm() {
			
		}
		// 삭제
		function deleteForm() {
			
		}
		// 목록
		function boardList() {
			
		}
	</script>
</head>

<body>
	<table id="pan_read" class="easyui-panel" title="글상세보기"
	style="width: 670px; height: 380px; padding: 10px; background: #fafafa;"
	data-options="footer:'#tb_read'">
		<tr>
			<td width="100px">&nbsp;&nbsp;제목</td>
			<td width="500px">
				<input class="easyui-textbox" id="bm_title" name="bm_title" 
				value="<%=rMap.get("BM_TITLE") %>" required style="width: 400px;">
			</td>
		</tr>
		<tr>
			<td width="100px">&nbsp;&nbsp;작성자</td>
			<td width="500px">
				<input class="easyui-textbox" id="bm_wirter" name="bm_writer" 
				value="<%=rMap.get("BM_WRITER") %>" required style="width: 400px;">
			</td>
		</tr>
		<tr>
			<td width="100px">&nbsp;&nbsp;이메일</td>
			<td width="500px">
				<input class="easyui-textbox" id="bm_email"
				value="<%=rMap.get("BM_EMAIL") %>" name="bm_email" style="width: 400px;">
			</td>
		</tr>
		<tr>
			<td width="100px">&nbsp;&nbsp;내용</td>
			<td width="500px">
				<input class="easyui-textbox" id="bm_content"
				name="bm_content" required style="width: 400px; height: 90px;"
				value="<%=rMap.get("BM_CONTENT") %>" data-options="multiline:'true'">
			</td>
		</tr>
		<tr>
			<td width="100px">&nbsp;&nbsp;비밀번호</td>
			<td width="500px"><input class="easyui-passwordbox" id="bm_pw"
				name="bm_pw" style="width: 200px;"></td>
		</tr>
	</table>
	<!-- ===========[수정, 삭제, 댓글, 목록 버튼]============ -->
	<div id="tb_read" align="center">
		<a href="javascript:repleForm()" class="easyui-linkbutton" plain='true'
		iconCls='icon-tip'>댓글</a>
		<a href="javascript:updateForm()" class="easyui-linkbutton" plain='true'
		iconCls='icon-edit'>수정</a>
		<a href="javascript:deleteForm()" class="easyui-linkbutton" plain='true'
		iconCls='icon-cancel'>삭제</a>
		<a href="javascript:boardList()" class="easyui-linkbutton" plain='true'
		iconCls='icon-more'>목록</a>
	</div>
	<!-- ==================[글 수정]==================== -->
	<!-- ==================[글 삭제]==================== -->
	<!-- ===================[댓글]==================== -->
	<div id="dlg_boardAdd" class="easyui-dialog" style="width:600px;height:400px;padding:20px" title="댓글 쓰기"
	data-options="closed:true,modal:true,footer:'#tbar_boardAdd'">
		<!-- 첨부파일을 보낼 시 GET방식이 사용되지 않음 POST 방식으로 바꿔줘야한다. -->
		<!-- 해당 방식(enctype="multipart/form-data")을 쓸 경우 req객체로 값을 가져올 수 없기 때문에 cost.jar 오픈소스를 활용한다. -->
		<form id="f_boardAdd" metod="post" enctype="multipart/form-data">
			<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO") %>" />
			<input type="hidden" name="bm_pos" value="<%=rMap.get("BM_POS") %>" />
			<input type="hidden" name="bm_step" value="<%=rMap.get("BM_STEP") %>" />
			<input type="hidden" name="bm_group" value="<%=rMap.get("BM_GROUP") %>" />
			<table>
				<tr>
					<td width="100px">&nbsp;&nbsp;제목</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_title" name="bm_title" style="width:400px;">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;작성자</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_wirter" name="bm_writer" style="width:400px;">
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
						<input class="easyui-textbox" id="bm_content" name="bm_content" style="width:400px;height:90px;"
						data-options="multiline:'true'">
					</td>
				</tr>
				<tr>
					<td width="100px">&nbsp;&nbsp;비밀번호</td>
					<td width="500px">
						<input class="easyui-textbox" id="bm_pw" name="bm_pw" required style="width:400px;">
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