package com.oracle;

import java.sql.Connection;

import com.util.DBConnectionMgr;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		DBConnectionMgr dbMgr2 = DBConnectionMgr.getInstance();
		DBConnectionMgr dbMgr3 = new DBConnectionMgr();//-> 답 중 하나긴 하나 결합도가 높아지므로 권장하지 않는다.
		System.out.println(dbMgr);//생성을 해주지 않아도 객체가 생성됨
		System.out.println(dbMgr2);//1과 같은 주소번지 -> 싱글톤이기 때문
		System.out.println(dbMgr3);//1과 다른 주소번지
		con = dbMgr.getConnection();
		System.out.println(con);
	}

}
