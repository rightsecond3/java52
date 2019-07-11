package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ChatDao {

	DBConnectionMgr_helpme  dbMgr  = null;
	Connection              con    = null;
	CallableStatement       cstmt  = null;//query
	PreparedStatement       pstmt  = null;//procedure
	OracleCallableStatement ocstmt = null;//refcursor
	ResultSet               rs     = null;
	
	//** 로그인 처리
	public String login(String memid, String mempw) {
		String nick = null;
		try {
			con = DBConnectionMgr_helpme.getConnection();
			cstmt = con.prepareCall("{call proc_chatlogin(?,?,?)}");
			cstmt.setString(1, memid);
			cstmt.setString(2, mempw);
			//out 파라미터 메소드
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			//실행 요청 메소드 호출
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while(rs.next()) {
				nick = rs.getString("mem_nick");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nick;
	}

}
