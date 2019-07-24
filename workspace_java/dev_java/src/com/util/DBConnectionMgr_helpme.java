package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.jdbc.OracleCallableStatement;
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
public class DBConnectionMgr_helpme {
	//오라클서버가 제공하는 드라이버 클래스 정보를 담기
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	//1)드라이버 연결 방식(thin:멀티 tier에서 사용하는데 적합, oci)
	//2)서버의 네트워크 정보 - 1521(디폴트) - SID명
	//3)사용자 이름과 패스워드
	public static final String _URL = "jdbc:oracle:thin:@192.168.0.211:1521:orcl11";
	public static final String _USER = "HELP_ME";
	public static final String _PW = "1q2w3e4r!";
	//하나의 객체로 사용하기 위해 static으로 선언하였다.
	//복제본 아닌 원본 하나를 사용하기 위해서 null체크 객체 생성
	static DBConnectionMgr_helpme dbMgr = null;
	//EmpJDBC.java에서 직접 인스턴스화 하지않는다.(결합도 낮아진다)
	//결합도가 낮고 응집도가 높은 것이 좋다.
	
	public static DBConnectionMgr_helpme getInstance() {
		if(dbMgr ==  null) {
			dbMgr = new DBConnectionMgr_helpme();
		}
	return dbMgr;
	}
	//연결통로 - Tomcat서버와 오라클서버 연결
	public static Connection getConnection() {
		Connection con = null;
		try {
			//외부의 클래스이름을 로딩 - 오라클서버에 대한 정보를 얻기 - ojdbc6.jar buildpath 메뉴
			Class.forName(_DRIVER);// 드라이버 클래스 메모리 로딩
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
	//** REF_CURSOR를 쓸때 **//
	public void freeConnection(Connection con, CallableStatement cstmt, ResultSet rs, OracleCallableStatement ocstmt) {
		try {
			if (ocstmt!=null) {
				ocstmt.close();
			}
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
			e.printStackTrace();
		}
	}
}