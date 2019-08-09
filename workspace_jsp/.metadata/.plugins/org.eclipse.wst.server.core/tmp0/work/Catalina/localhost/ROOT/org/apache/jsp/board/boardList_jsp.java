/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-08-09 02:51:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class boardList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/JEasyUICommon.jsp", Long.valueOf(1564466243821L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	// 총 레코드 갯수 - 아작스 활용하여 해결
/* 	int tot = 0;
	if(session.getAttribute("s_tot")!=null) {
		tot = Integer.parseInt(session.getAttribute("s_tot").toString());
	}
	out.print("tot : "+tot); */

      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("\t화면처리를 태그로 할 때와 스크립트로 할 때\r\n");
      out.write("\t1. 태그안에 코드를 작성하면 디자인과 코드가 분리가 안되서 가독성이 떨어짐.\r\n");
      out.write("\t2. 스크립트로 처리할 때 화면에서 코드가 분리됨.(이벤트 처리나 DOM 조작하는 코드 작성 시 접근성이 좋다.)\r\n");
      out.write("\t3. 화면과 스크립트 코드를 분리할 시 react적용 시 라이프 사이클에 따라 코드 적용이 용이하다.\r\n");
      out.write("-->\r\n");
      out.write("<!-- \r\n");
      out.write("\tbody태그에서 getBoardList()함수를 호출하여\r\n");
      out.write("\t서블릿을 경유하게 되는데 왜 이땐 session값이 0인 걸까요?\r\n");
      out.write("\t결론\r\n");
      out.write("\t세션과 쿠키 모두 생성되자마자 화면에 반영되지 않는다.\r\n");
      out.write("\t그 이유는 세션과 쿠키는 모두 서버단에서 일어나는 사건이고\r\n");
      out.write("\t화면은 이미 사용자측에서 랜더링이 끝난 상태이므로 시점 문제가 발생\r\n");
      out.write("\t따라서, 생성된 시점에서 현재 바라보고 있는 페이지에서는 그 값을 확인 할 수 없다.\r\n");
      out.write("-->\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>MVC패턴을 적용한 계층형 게시판</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/commons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.cookie.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t//* pageMove : 페이지네이션 페이지 이동시 사용하는 함수\r\n");
      out.write("\t\tfunction pageMove(pageNumber, pageSize) {\r\n");
      out.write("\t\t\tvar cb_value = user_combo; // 콤보박스 값\r\n");
      out.write("\t\t\tvar tb_value = $(\"#keyword\").val(); // 사용자가 검색한 값\r\n");
      out.write("\t\t\tvar bm_value = $(\"#bm_date\").val(); // 데이트박스 값\r\n");
      out.write("\t\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\turl:\"/board/test.mo?crud=boardList&keyword=\"+tb_value\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&cb_value=\"+cb_value\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&bm_date=\"+bm_value\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&pageNumber=\"+pageNumber\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&pageSize=\"+pageSize\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//* boardList\r\n");
      out.write("\t\tfunction boardList() {\r\n");
      out.write("\t\t\tvar cb_value = user_combo; // 콤보박스 값\r\n");
      out.write("\t\t\tvar tb_value = $(\"#keyword\").val(); // 사용자가 검색한 값\r\n");
      out.write("\t\t\tvar bm_value = $(\"#bm_date\").val(); // 데이트박스 값\r\n");
      out.write("\t\t\tif(pn_pageNumber == null || pn_pageSize == null) {\r\n");
      out.write("\t\t\t\tpn_pageNumber = 1;\r\n");
      out.write("\t\t\t\tpn_pageSize = 5;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\turl:\"/board/test.mo?crud=boardList&keyword=\"+tb_value\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&cb_value=\"+cb_value\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&bm_date=\"+bm_value\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&pageNumber=\"+pn_pageNumber\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"&pageSize=\"+pn_pageSize\r\n");
      out.write("\t\t\t\t,onLoadSuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\tmethod:\"GET\"\r\n");
      out.write("\t\t\t\t\t\t,url:\"/board/test.mo?crud=total&keyword=\"+tb_value\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+\"&cb_value=\"+cb_value\r\n");
      out.write("\t\t\t\t\t\t,success: function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#pn_board\").pagination({\r\n");
      out.write("\t\t\t\t\t\t\t\ttotal:result\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//* addForm\r\n");
      out.write("\t\tfunction addForm() {\r\n");
      out.write("\t\t\t//alert(\"입력화면\");\r\n");
      out.write("\t\t\t$(\"#dlg_boardAdd\").dialog('open');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//* updForm\r\n");
      out.write("\t\tfunction updForm() {\r\n");
      out.write("\t\t\talert(\"수정화면\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//* delForm\r\n");
      out.write("\t\tfunction delForm() {\r\n");
      out.write("\t\t\talert(\"삭제화면\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//addAction : form 전송\r\n");
      out.write("\t\tfunction addAction() {\r\n");
      out.write("\t\t\tif($(\"#bm_title\").val()==null || $(\"#bm_wirter\").val()==null\r\n");
      out.write("\t\t\t\t|| $(\"#bm_content\").val()==null || $(\"#bm_pw\").val()==null) {\r\n");
      out.write("\t\t\t\talert(\"필수 입력사항을 입력하세요.\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\t$(\"#f_boardAdd\").attr(\"method\",\"post\");\r\n");
      out.write("\t\t\t\t$(\"#f_boardAdd\").attr(\"action\",\"/board/test.mo?crud=boardAdd\");\r\n");
      out.write("\t\t\t\t$(\"#f_boardAdd\").submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"boardList()\">\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar user_combo; // 콤보박스에서 선택한 값 담기\r\n");
      out.write("\t\tvar tb_value; \r\n");
      out.write("\t\tvar pn_pageNumber; \r\n");
      out.write("\t\tvar pn_pageSize;\r\n");
      out.write("\t\tvar g_no; // 사용자가 제목을 더블클릭 했을 시 hidden 값인 bm_no를 담는 변수\r\n");
      out.write("\t\t// 날짜 포멧을 설정해주는 함수\r\n");
      out.write("\t\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\t\tvar d = date.getDate();\r\n");
      out.write("\t\t\treturn y+'-'+(m<10 ? \"0\"+m:m)+'-'+(d<10 ? \"0\"+d:d);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 새로운 날짜 포멧을 적용해주는 함수\r\n");
      out.write("\t\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\t\treturn new Date(t);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn new Date();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// DOM 구성이 완료된 후\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t//* dg_board - datagrid 초기화 및 설정\r\n");
      out.write("\t\t\t$(\"#dg_board\").datagrid({\r\n");
      out.write("\t\t\t\ttoolbar:'#tb_board, #tb_search'\r\n");
      out.write("\t\t\t\t,rownumbers:'true'\r\n");
      out.write("\t\t\t\t,footer:'#pn_board'\r\n");
      out.write("\t\t\t\t,singleSelect:true\r\n");
      out.write("\t\t\t    ,columns:[[\r\n");
      out.write("\t\t\t    \t// hidden 화면에는 나오지 않지만 데이터는 가지고 있다.\r\n");
      out.write("\t\t\t        {field:'BM_NO',title:'글번호',width:100,hidden:'true'}\r\n");
      out.write("\t\t\t        ,{field:'BM_TITLE',title:'제목',width:350}\r\n");
      out.write("\t\t\t        ,{field:'BM_WRITER',title:'작성자',width:100}\r\n");
      out.write("\t\t\t        ,{field:'BM_DATE',title:'작성일',width:150}\r\n");
      out.write("\t\t\t        ,{field:'BS_FILE',title:'첨부파일',width:100}\r\n");
      out.write("\t\t\t        ,{field:'BM_HIT',title:'조회수',width:100}\r\n");
      out.write("\t\t\t    ]]\r\n");
      out.write("\t\t\t\t,onSelect: function(index, row) {\r\n");
      out.write("\t\t\t\t\t//alert(\"해당 셀의 BM_NO : \"+row.BM_NO);\r\n");
      out.write("\t\t\t\t\tg_no = row.BM_NO;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t,onDblClickCell: function(index,field,value){\r\n");
      out.write("\t\t\t\t\t// 제목을 더블클릭\r\n");
      out.write("\t\t\t\t\tif(\"BM_TITLE\"==field) {\r\n");
      out.write("\t\t\t\t\t\tcmm_window_popup(\"test.mo?crud=boardDetail&bm_no=\"+g_no,\"720\",\"450\",\"read\");\r\n");
      out.write("\t\t\t\t\t\t// 선택한 로우 값 초기화\r\n");
      out.write("\t\t\t\t\t\t$(\"#dg_board\").datagrid('clearSelections');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t// 첨부파일 더블클릭\r\n");
      out.write("\t\t\t\t\telse if(\"BS_FILE\"==field) {\r\n");
      out.write("\t\t\t\t\t\tlocation.href=\"downLoad.jsp?bs_file=\"+value;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//* cb_search - combobox 이벤트 처리(값 가져오기)\r\n");
      out.write("\t\t\t$(\"#cb_search\").combobox({\r\n");
      out.write("\t\t\t\tonChange:function(newValue,oldValue) {\r\n");
      out.write("\t\t\t\t\t//user_combo = $(this).combobox('getValue');\r\n");
      out.write("\t\t\t\t\tuser_combo = newValue;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//* keyword - textbox 엔터 이벤트\r\n");
      out.write("\t\t\t$(\"#keyword\").textbox('textbox').bind('keydown', function(e){\r\n");
      out.write("\t\t\t\tif(e.keyCode == 13) {\r\n");
      out.write("\t\t\t\t\tboardList();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t//* pn_board - pagination\r\n");
      out.write("\t\t\t$('#pn_board').pagination({\r\n");
      out.write("\t\t\t\tpageList:[5,10,15,20]\r\n");
      out.write("\t\t\t\t,pageSize:5\r\n");
      out.write("\t\t\t\t// 페이지 이동 시 이벤트 처리\r\n");
      out.write("\t\t\t\t// 1) 현재 내가 바라보는 페이지, 2) 한 페이지에 보여 줄 로우의 수\r\n");
      out.write("\t\t\t\t,onSelectPage: function(pageNumber, pageSize) {\r\n");
      out.write("\t\t\t\t\tpageMove(pageNumber, pageSize);\r\n");
      out.write("\t\t\t\t\tpn_pageNumber = pageNumber;\r\n");
      out.write("\t\t\t\t\tpn_pageSize = pageSize;\r\n");
      out.write("\t            }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- =============[[글 목록 화면_jEqsyUI DataGrid API]]============== -->\r\n");
      out.write("\t<!-- 1)익스프레션을 이용해서 화면처리  :td, td 태그를 직접 작성하여 처리 -->\r\n");
      out.write("\t<!-- 2)json포멧으로 처리해서 매핑  : field명만 맞춰주면 자동 매핑 -->\r\n");
      out.write("\t<table id=\"dg_board\" class=\"easyui-datagrid\" title=\"글목록\" style=\"width:900px;height:400px;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- [툴바부분] -->\r\n");
      out.write("    <div id=\"tb_search\" style=\"padding:2px 5px;\">\r\n");
      out.write("    \t<select id=\"cb_search\" name=\"cb_search\" class=\"easyui-combobox\" panelHeight=\"auto\" style=\"width:100px\"\r\n");
      out.write("    \tdata-options=\"editable:false\">\r\n");
      out.write("    \t\t<option selected value=\"\">전체조회</option>\r\n");
      out.write("    \t\t<option value=\"bm_title\">제목</option>\r\n");
      out.write("    \t\t<option value=\"bm_content\">내용</option>\r\n");
      out.write("    \t\t<option value=\"bm_writer\">작성자</option>\r\n");
      out.write("    \t</select>\r\n");
      out.write("    \t<input class=\"easyui-textbox\" id=\"keyword\" name=\"keyword\" style=\"width:400px;\" plain=\"true\"\r\n");
      out.write("    \tdata-options=\"prompt:'Search...'\">\r\n");
      out.write("    \t&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    \t작성일 : <input class=\"easyui-datebox\" id=\"bm_date\" name=\"bm_date\" style=\"width:120px\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"tb_board\" style=\"padding:2px 5px;\">\r\n");
      out.write("        <a href=\"javascript:boardList()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">조회</a>\r\n");
      out.write("        <a href=\"javascript:addForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">입력</a>\r\n");
      out.write("        <a href=\"javascript:updForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">수정</a>\r\n");
      out.write("        <a href=\"javascript:delForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\">삭제</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- [페이지네이션 부분] - 데이터 그리드 하단 페이지 표시부-->\r\n");
      out.write("    <div id=\"pn_board\" class=\"easyui-pagination\" style=\"background:#efefef;border:1px solid #ccc;\"></div>\r\n");
      out.write("\t<!-- =============[[글 쓰기 화면_jEasyUI Dialog API]]============== -->\r\n");
      out.write("\t<div id=\"dlg_boardAdd\" class=\"easyui-dialog\" style=\"width:600px;height:400px;padding:20px\" title=\"글 쓰기\"\r\n");
      out.write("\tdata-options=\"closed:true,modal:true,footer:'#tbar_boardAdd'\">\r\n");
      out.write("\t\t<!-- 첨부파일을 보낼 시 GET방식이 사용되지 않음 POST 방식으로 바꿔줘야한다. -->\r\n");
      out.write("\t\t<!-- 해당 방식(enctype=\"multipart/form-data\")을 쓸 경우 req객체로 값을 가져올 수 없기 때문에 cost.jar 오픈소스를 활용한다. -->\r\n");
      out.write("\t\t<form id=\"f_boardAdd\" metod=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_no\" value=\"0\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_pos\" value=\"0\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_step\" value=\"0\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_group\" value=\"0\" />\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;제목</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_title\" name=\"bm_title\" required style=\"width:400px;\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;작성자</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_wirter\" name=\"bm_writer\" required style=\"width:400px;\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;이메일</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_email\" name=\"bm_email\" style=\"width:400px;\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;내용</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_content\" name=\"bm_content\" required style=\"width:400px;height:90px;\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"multiline:'true'\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;비밀번호</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_pw\" name=\"bm_pw\" required style=\"width:400px;\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;첨부파일</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-filebox\" id=\"bs_file\" name=\"bs_file\" style=\"width:400px;\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- [입력 화면 버튼 추가] -->\r\n");
      out.write("\t<div id=\"tbar_boardAdd\" align=\"right\">\r\n");
      out.write("\t\t<a href=\"javascript:addAction()\" class=\"easyui-linkbutton\" plain='true'\r\n");
      out.write("\t\ticonCls='icon-save'>저장</a>\r\n");
      out.write("\t\t<a href=\"javascript:$('#dlg_boardAdd').dialog('close')\" class=\"easyui-linkbutton\" plain='true'\r\n");
      out.write("\t\ticonCls='icon-cancel'>닫기</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}