/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-22 08:09:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onLineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/onLineTest/bottom.jsp", Long.valueOf(1563782810985L));
    _jspx_dependants.put("/onLineTest/top.jsp", Long.valueOf(1563782772436L));
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Bootstrap Example</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.4.1.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    function loginModal(){\r\n");
      out.write("      $(\"#myModal\").modal();\r\n");
      out.write("    }\r\n");
      out.write("    function loginAction(){\r\n");
      out.write("\r\n");
      out.write("    }   \r\n");
      out.write("    function logoutAction(){\r\n");
      out.write("\r\n");
      out.write("    }   \r\n");
      out.write("  </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t.jumbotron {\r\n");
      out.write("\t\tbackground-image: url('../../images/code6.jpeg');\r\n");
      out.write("\t\tbackground-size: cover;\r\n");
      out.write("\t\ttext-shadow: black 0.2em 0.2em 0.2em;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<!-- 디렉티브 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"#\">자바52기</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\r\n");
      out.write("\t\t\t\t<li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">소개</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"dropdown\" href=\"#\">Front-End노트<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">HTML5</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">CSS</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">JavaScript</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"dropdown\" href=\"#\">Back-End노트<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Java</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">서블릿</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">JSP</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">Spring</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">안드로이드</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<!-- =========================== 온라인 시험 솔루션 실습 - 자격시험메뉴추가 =====================-->\r\n");
      out.write("\t\t\t\t<li class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-toggle\"\r\n");
      out.write("\t\t\t\t\tdata-toggle=\"dropdown\" href=\"#\">자격시험<span class=\"caret\"></span></a>\r\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">자격시험 접수</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\">자격시험 보기</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\t\t\t\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div id=\"loginForm\" class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<form class=\"navbar-form navbar-right\" action=\"/action_page.php\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"usrname\" size=\"10\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"아이디\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"psw\" size=\"10\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"비밀번호\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-dark\" onclick=\"loginAction()\">Login</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"jumbotron\">\r\n");
      out.write("\t\t\t<h1 class=\"text-center\">자바 52기</h1>\r\n");
      out.write("\t\t\t<p class=\"text-center\">자바 52기 수업노트 입니다.\r\n");
      out.write("\t\t\t<p class=\"text-center\">\r\n");
      out.write("\t\t\t\t<a class=\"btn-primary btn-lg\" href=\"lecture.html\" role=\"button\">강의\r\n");
      out.write("\t\t\t\t\t들어 볼까?</a>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- =========================== 메인 이미지 다음 사이트 소개=====================-->\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t<h4>코딩놀이의 특징</h4>\r\n");
      out.write("\t\t\t\t<p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-default\" data-target=\"#modal\" data-toggle=\"modal\">자세히\r\n");
      out.write("\t\t\t\t\t\t알아보기</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t<h4>코딩놀이의 특징</h4>\r\n");
      out.write("\t\t\t\t<p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-default\" href=\"instructor.html\">자세히 알아보기</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t<h4>코딩놀이의 특징</h4>\r\n");
      out.write("\t\t\t\t<p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<a class=\"btn btn-default\" href=\"lecture.html\">자세히 알아보기</a>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<!-- =========================== 메인 이미지 다음 사이트 소개=====================-->\r\n");
      out.write("\t\t<div class=\"pannel pannel-primary\">\r\n");
      out.write("\t\t\t<div class=\"pannel-heading\">\r\n");
      out.write("\t\t\t\t<h3 class=\"pannel-title\">\r\n");
      out.write("\t\t\t\t\t<span class=\"glyphicon glyphicon-pencil\"></span>&nbsp;&nbsp;최신 강의\r\n");
      out.write("\t\t\t\t\t목록\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"pannel-body\">\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"media-left\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"lecture.html?lectureName=C\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"../../images/c.jpeg\" width=\"50px\" height=\"50px\" alt=\"c언어\"></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"media-body\">\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"media-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"lecture.html?lectureName=C\">C언어 강의</a>&nbsp;<span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge\">New</span>\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\tC언어 프로그래밍 강의\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"media-left\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"lecture.html?lectureName=java\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"../../images/java.png\" width=\"50px\" height=\"50px\" alt=\"c언어\"></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"media-body\">\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"media-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"lecture.html?lectureName=C\">JAVA 강의</a>&nbsp;<span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge\">New</span>\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\tJAVA 프로그래밍 강의\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"media-left\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"lecture.html?lectureName=oracle\"><img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"../../images/oracle.png\" width=\"50px\" height=\"50px\"\r\n");
      out.write("\t\t\t\t\t\t\talt=\"c언어\"></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"media-body\">\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"media-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"lecture.html?lectureName=oracle\">Oracle 강의</a>&nbsp;<span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge\">New</span>\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\tOracle 데이터베이스 강의\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br> <br>\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<footer style=\"background-color: #000000; color: #ffffff;\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t<!-- 12개 범위에서 맞추어 준다. -->\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-2\" style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t\t<h5>Copyright &copy; 2019</h5>\r\n");
      out.write("\t\t\t\t\t<h5>김승수</h5>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-4\">\r\n");
      out.write("\t\t\t\t\t<h4>대표자 소개</h4>\r\n");
      out.write("\t\t\t\t\t<p>한국소프트인재개발원에서 자바과정을 담당하고 있습니다.</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t<h4 style=\"text-align: center;\">내비게이션</h4>\r\n");
      out.write("\t\t\t\t\t<div class=\"list-group\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"list-group-item\">소개</a> <a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"list-group-item\">강사진</a> <a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"list-group-item\">강의</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t<h4 style=\"text-align: center;\">SNS</h4>\r\n");
      out.write("\t\t\t\t\t<div class=\"list-group\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"list-group-item\">페이스북</a> <a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"list-group-item\">유튜브</a> <a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"list-group-item\">네이버 TV</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t\t<h4 style=\"text-align: center;\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"glyphicon glyphicon-ok\"></span>by &nbsp;김승수\r\n");
      out.write("\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
