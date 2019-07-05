/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.20
 * Generated at: 2019-07-03 01:37:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ajax.picture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.google.gson.Gson;

public final class pictureInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.google.gson.Gson");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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

	/*
	* pictureMain.html 문서에서 ajax 처리 메소드에서 호출하는
	* url 뒤에 query string 문자열 값을 읽어오는 메소드.
	*/
	String p_no = request.getParameter("p_no");
    List<Map<String,Object>> picList = new ArrayList<>();
	Map<String,Object> picInfo = new HashMap<>();
	picInfo.put("p_no",1);
	picInfo.put("p_img","picture1.jpg");
	picInfo.put("p_info","다람쥐");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",2);
	picInfo.put("p_img","picture2.jpg");
	picInfo.put("p_info","고양이");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",3);
	picInfo.put("p_img","picture3.jpg");
	picInfo.put("p_info","몽몽이");
	picList.add(picInfo);
	
	picInfo = new HashMap<>();
	picInfo.put("p_no",4);
	picInfo.put("p_img","picture4.jpg");
	picInfo.put("p_info","판다너구리");
	picList.add(picInfo);
	//선택하는 그림의 아이디에 대응하는 값만 가져오기
	//json 포맷으로 넘겨야 하고 그 후 스크립트로 다시 파싱해야 하므로 동일한 구조로 만들어야함
	//그러면 파싱하는 부분의 코드는 수정을 안해도 되니깐
	/*
	위에서는 모든 건을 다 조회하였다
	그러나 그림 제목에 오버했을 때 td태그의 id속성의 값을 읽어서 그 값을 쿼리 스트링으로 넘겼다.
	pictureInfo.jsp?p_no=? -> ?뒤에 문장 : 쿼리 스트링
	*/
    List<Map<String,Object>> picDetail = new ArrayList<>();
	Map<String,Object> picDetailMap = null;
	for(int i=0;i<picList.size();i++) { //4번 반복
		Map<String,Object> rmap = picList.get(i); //한건 식 꺼냄
		if(p_no.equals(rmap.get("p_no").toString())) { //비교 - p_no로
			//한건 씩 꺼낸 맵의 주소번지를 새로운 주소번지 대입하고
			picDetailMap = rmap; //4건을 가진 map 중에서 p_no가 같은 한개 맵만 주소번지를 저장
			picDetail.add(picDetailMap); //리스트에 담아줌
		}
	}
	//구글에서 제공하는 오픈 API를 사용하여 JSON포맷으로 꺼내기
	Gson g = new Gson();
	String result = g.toJson(picDetail);
	//picList가 아닌 Json포맷으로 변형된 result를 넘겨야 된다.
	out.print(result);

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
