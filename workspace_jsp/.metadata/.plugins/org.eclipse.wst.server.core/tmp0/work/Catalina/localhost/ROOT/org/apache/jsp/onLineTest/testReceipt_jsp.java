/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-25 07:44:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onLineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vo.MemberVO;

public final class testReceipt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/onLineTest/../common/JEasyUICommon.jsp", Long.valueOf(1563429222261L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.vo.MemberVO");
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

	MemberVO mVO = (MemberVO) session.getAttribute("rmVO");
	String s_memid = null;
	String s_memname = null;
	if(mVO != null) {
		s_memid = mVO.getMem_id(); // 사용자가 입력한 mem_id 
		s_memname = mVO.getMem_name();
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>자격시험 접수 - 정보처리기사</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction receipt() {\r\n");
      out.write("\t\t$(\"#f_receipt\").attr(\"method\", \"get\");\r\n");
      out.write("\t\t$(\"#f_receipt\").attr(\"action\", \"examReceipt.kos\");\r\n");
      out.write("\t\t$(\"#f_receipt\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t// 데이터 포멧가져오기\r\n");
      out.write("\t\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\t\t//달은 0~11을 리턴해주기 때문에 1을 더해준 것\r\n");
      out.write("\t\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\t\tvar d = date.getDate();\r\n");
      out.write("\t\t\t// 삼항 연산자 (조건 ? 참 : 거짓)\r\n");
      out.write("\t\t\treturn y+'-'+(m<10 ? ('0'+m) : m)+'-'+(d<10?('0'+d) : d);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 선택한 날짜 가져오기\r\n");
      out.write("\t\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\t\treturn new Date(t);\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn new Date();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$(\"#mem_name\").textbox('setValue', '");
      out.print(s_memname);
      out.write("');\r\n");
      out.write("\t\t\t//* 콤보박스 초기화\r\n");
      out.write("\t\t\t$('#cb_subject').combobox({\r\n");
      out.write("\t\t\t    url:'subjectList.kos?work=onLineTest'\r\n");
      out.write("\t\t\t    ,valueField:'SUB_CD' // 서버에 넘어가는 값\r\n");
      out.write("\t\t\t    ,textField:'SUB_NAME' //화면에 출력하는 값\r\n");
      out.write("\t\t\t    ,prompt : '수험번호를 선택하세요.'\r\n");
      out.write("\t\t\t    ,panelHeight:'auto'\r\n");
      out.write("\t\t\t    ,editable:false\r\n");
      out.write("\t\t\t    ,onSelect:function(record) {\r\n");
      out.write("\t\t\t    \talert(record.SUB_NAME);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t// jQuery에서 제공하는 attr()메소드에 쿼리스트링은 값이 넘어가지 않음 : 결함. -> hidden으로 처리해라.\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- 패널 부분 -->\r\n");
      out.write("\t<div class=\"easyui-panel\" title=\"자격시험 접수\" style=\"width:100%;max-width:450px;padding:30px 30px\">\r\n");
      out.write("\t\t<!-- form -->\r\n");
      out.write("\t\t<form id=\"f_receipt\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"mem_id\" name=\"mem_id\" value=\"");
      out.print(s_memid );
      out.write("\" />\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"work\" name=\"work\" value=\"onLineTest\" />\r\n");
      out.write("\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\" id=\"mem_name\" name=\"mem_name\" label=\"이름 :\" labelPosition=\"left\" style=\"width:160px\" editable=false>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t<input class=\"easyui-datebox\" id=\"exam_date\" name=\"exam_date\" label=\"응시일자 :\" labelPosition=\"left\" style=\"width:200px\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t<select class=\"easyui-combobox\" id=cb_subject name=\"sub_cd\" label=\"수험과목 :\" labelPosition=\"left\" style=\"width:300px\">\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<a href=\"javascript:receipt()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\" style=\"width:100%;height:32px\">접수</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<!-- /from -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
