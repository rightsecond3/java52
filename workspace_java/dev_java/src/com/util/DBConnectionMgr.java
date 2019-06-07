package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionMgr {
	//오라클서버가 제공하는 드라이버 클래스 정보를 담기
	public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String _URL = "jdbc:oracle:thin:@192.168.0.211:1521:orcl11";
	public static final String _USER = "scott";
	public static final String _PW = "tiger";
	static DBConnectionMgr dbMgr = null;
	//EmpJDBC.java에서 직접 인스턴스화 하지않는다.(결합도 낮아진다)
	//결합도가 낮고 응집도가 높은 것이 좋다.
	//싱글톤 패턴
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
//	public static void main(String[] args) {
//		System.out.println(DBConnectionMgr.getConnection()); 
//	}
}
