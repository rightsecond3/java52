<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/JEasyUICommon.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table class="easyui-datagrid" style="width:400px;height:250px" title="물품목록"
	        data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true,toolbar:'#tb_board'">
	    <thead>
	        <tr>
	            <th data-options="field:'code',width:100">Code</th>
	            <th data-options="field:'name',width:100">Name</th>
	            <th data-options="field:'price',width:100,align:'right'">Price</th>
	        </tr>
	    </thead>
	    <!-- dataset과 datagrid가 만나는 부분(매핑) -->
	    <tbody>
	    	<%
	    		for(int i=0;i<2;i++) {
	    	%>
	    	<tr>
	    		<td><%="a00"+i %></td>
	    		<td><%="노트북" %></td>
	    		<td><%="35000" %></td>
	    	</tr>
	    	<%
	    		}
	    	%>
	    </tbody>
	</table>
    <div id="tb_board" style="padding:2px 5px;">
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
    </div>
</body>

</html>