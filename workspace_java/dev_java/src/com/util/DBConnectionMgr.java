package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * 오라클은 동시 접속자들을 세션으로 관리하는데
 * 일정 개수의 세션을 넘어서면 서버 접속 불가 - 강제로 연결 끊음
 * 자바단에서 사용한 자원 반드시 반납할 것 - 자바튜닝 권고사항
 * 물리적으로 떨어져 있는 오라클 서버에 접속할 때 - Connection
 * 연결 통로를 통해서 DML구문을 가져가고 요청한다. PreparedStatement, CallableStatement(프로시저)
 * SELECT => 트랜잭션처리 대상이 아님 - 테이블에 변화가 없다.
 * pstmt.excuteQuery(); -> 오라클 서버에 select문 요청
 * , return - ResultSet -> Cursor조작 : rs.next();, rs.First(), rs.isLast(), rs.absoulut(3);
 * INSERT, UPDATE, DELETE => 트랜잭션 처리 대상 - 물리적인 변화를 받음
 * pstmt.executeUpdate() : return - int
 */

//서버 ip 20번 , id : rightsecond ,pw : rstiger 내 ip 211
public class DBConnectionMgr {
	//오라클서버가 제공하는 드라이버 클래스 정보를 담기
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String _URL = "jdbc:oracle:thin:@192.168.0.211:1521:orcl11";
	public static final String _USER = "scott";
	public static final String _PW = "tiger";
	static DBConnectionMgr dbMgr = null;
	//EmpJDBC.java에서 직접 인스턴스화 하지않는다.(결합도 낮아진다)
	//결합도가 낮고 응집도가 높은 것이 좋다.
	public static DBConnectionMgr getInstance() {
		if(dbMgr ==  null) {
			dbMgr = new DBConnectionMgr();
		}
	return dbMgr;
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
		} catch (ClassNotFoundException ce) {
			System.out.println("드라이버 클래스를 찾을 수 없다.");
		} catch(Exception e) {
			System.out.println("오라클 서버 연결 실패!!!.");
		}
		return con;
	}
	//** 사용한 자원 반납하기 - 오라클 세션과 관련있으므로 반드시 할것. **//
	//** 커서가 필요없는 경우 **///
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt!=null) { // 자원반납은 객체 생성의 역순으로 해줘야 한다.
				pstmt.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//** 커서가 필요한 경우 ***///
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (pstmt!=null) { // 자원반납은 객체 생성의 역순으로 해줘야 한다.
				pstmt.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//** 커서가 필요 없는 경우 **// - UPDATE, DELETE, INSERT
	public void freeConnection(Connection con, CallableStatement cstmt) {
		try {
			if (cstmt!=null) { // 자원반납은 객체 생성의 역순으로 해줘야 한다.
				cstmt.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	//** 커서가 필요한 경우 **// - SELECT
	public void freeConnection(Connection con, CallableStatement cstmt, ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (cstmt!=null) { // 자원반납은 객체 생성의 역순으로 해줘야 한다.
				cstmt.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}