<%@page import="java.sql.Types"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.util.DBConnectionMgr"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.CallableStatement"%>
<%
	String mem_id = request.getParameter("mem_id");
	String mem_pw = request.getParameter("mem_pw");
	String msg = null;
	try{
	//물리적으로 떨어져 있는 서버에 연결 통로 확보
	Connection con = DBConnectionMgr.getConnection();
	//프로시저를 오라클 서버에 전달해 줄 클래스 필요
	CallableStatement cstmt = con.prepareCall("{call proc_login3(?,?,?)}");
	cstmt.setString(1, mem_id);
	cstmt.setString(2, mem_pw);
	cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
	int result = cstmt.executeUpdate();
	//OUT속성의 경우 파라미터 타입안에 값이 담김. - 리턴타입을 활용하지 않고.. -MyBatis
	msg = cstmt.getString(3);
	} catch(Exception e) {
		e.printStackTrace();
	}
	out.clear();//버퍼캐시에 있는 값을 비운다.
	//out.flush() : 버퍼에 쌓지 않고 즉시 보낼 때 - 8kb
	out.print(msg);
%>