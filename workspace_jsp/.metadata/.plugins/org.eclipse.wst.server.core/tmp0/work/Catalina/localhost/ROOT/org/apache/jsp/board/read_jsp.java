/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-08-09 04:07:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.List;

public final class read_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Map");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	List<Map<String, Object>> boardDetail 
	= (List<Map<String, Object>>) request.getAttribute("boardDetail");
	Map<String, Object> rMap = null;
	if(boardDetail != null) {
		rMap = boardDetail.get(0);
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/commons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.cookie.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction addAction() {\r\n");
      out.write("\t\t\t$(\"#f_boardAdd\").attr('method','post');\r\n");
      out.write("\t\t\t$(\"#f_boardAdd\").attr('action','/board/test.mo?crud=boardAdd');\r\n");
      out.write("\t\t\t$(\"#f_boardAdd\").submit();\r\n");
      out.write("\t\t\t// 부모창의 함수를 호출 할 때 opener.함수명()\r\n");
      out.write("\t\t\topener.boardList();\r\n");
      out.write("\t\t\tself.close();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 댓글쓰기\r\n");
      out.write("\t\tfunction repleForm() {\r\n");
      out.write("\t\t\t$(\"#dlg_boardAdd\").dialog('open');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 수정\r\n");
      out.write("\t\tfunction editForm() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 삭제\r\n");
      out.write("\t\tfunction deleteForm() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 목록\r\n");
      out.write("\t\tfunction boardList() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<table id=\"pan_read\" class=\"easyui-panel\" title=\"글상세보기\"\r\n");
      out.write("\tstyle=\"width: 670px; height: 380px; padding: 10px; background: #fafafa;\"\r\n");
      out.write("\tdata-options=\"footer:'#tb_read'\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">&nbsp;&nbsp;제목</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_title\" name=\"bm_title\" \r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(rMap.get("BM_TITLE") );
      out.write("\" required style=\"width: 400px;\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">&nbsp;&nbsp;작성자</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_wirter\" name=\"bm_writer\" \r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(rMap.get("BM_WRITER") );
      out.write("\" required style=\"width: 400px;\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">&nbsp;&nbsp;이메일</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_email\"\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(rMap.get("BM_EMAIL") );
      out.write("\" name=\"bm_email\" style=\"width: 400px;\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">&nbsp;&nbsp;내용</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_content\"\r\n");
      out.write("\t\t\t\tname=\"bm_content\" required style=\"width: 400px; height: 90px;\"\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(rMap.get("BM_CONTENT") );
      out.write("\" data-options=\"multiline:'true'\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">&nbsp;&nbsp;비밀번호</td>\r\n");
      out.write("\t\t\t<td width=\"500px\"><input class=\"easyui-passwordbox\" id=\"bm_pw\"\r\n");
      out.write("\t\t\t\tname=\"bm_pw\" style=\"width: 200px;\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<!-- ===========[수정, 삭제, 댓글, 목록 버튼]============ -->\r\n");
      out.write("\t<div id=\"tb_read\" align=\"center\">\r\n");
      out.write("\t\t<a href=\"javascript:repleForm()\" class=\"easyui-linkbutton\" plain='true'\r\n");
      out.write("\t\ticonCls='icon-tip'>댓글</a>\r\n");
      out.write("\t\t<a href=\"javascript:updateForm()\" class=\"easyui-linkbutton\" plain='true'\r\n");
      out.write("\t\ticonCls='icon-edit'>수정</a>\r\n");
      out.write("\t\t<a href=\"javascript:deleteForm()\" class=\"easyui-linkbutton\" plain='true'\r\n");
      out.write("\t\ticonCls='icon-cancel'>삭제</a>\r\n");
      out.write("\t\t<a href=\"javascript:boardList()\" class=\"easyui-linkbutton\" plain='true'\r\n");
      out.write("\t\ticonCls='icon-more'>목록</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- ==================[글 수정]==================== -->\r\n");
      out.write("\t<!-- ==================[글 삭제]==================== -->\r\n");
      out.write("\t<!-- ===================[댓글]==================== -->\r\n");
      out.write("\t<div id=\"dlg_boardAdd\" class=\"easyui-dialog\" style=\"width:600px;height:400px;padding:20px\" title=\"댓글 쓰기\"\r\n");
      out.write("\tdata-options=\"closed:true,modal:true,footer:'#tbar_boardAdd'\">\r\n");
      out.write("\t\t<!-- 첨부파일을 보낼 시 GET방식이 사용되지 않음 POST 방식으로 바꿔줘야한다. -->\r\n");
      out.write("\t\t<!-- 해당 방식(enctype=\"multipart/form-data\")을 쓸 경우 req객체로 값을 가져올 수 없기 때문에 cost.jar 오픈소스를 활용한다. -->\r\n");
      out.write("\t\t<form id=\"f_boardAdd\" metod=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_no\" value=\"");
      out.print(rMap.get("BM_NO") );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_pos\" value=\"");
      out.print(rMap.get("BM_POS") );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_step\" value=\"");
      out.print(rMap.get("BM_STEP") );
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"bm_group\" value=\"");
      out.print(rMap.get("BM_GROUP") );
      out.write("\" />\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;제목</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_title\" name=\"bm_title\" style=\"width:400px;\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;작성자</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_wirter\" name=\"bm_writer\" style=\"width:400px;\">\r\n");
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
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_content\" name=\"bm_content\" style=\"width:400px;height:90px;\"\r\n");
      out.write("\t\t\t\t\t\tdata-options=\"multiline:'true'\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\">&nbsp;&nbsp;비밀번호</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_pw\" name=\"bm_pw\" required style=\"width:400px;\">\r\n");
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
      out.write("\r\n");
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
