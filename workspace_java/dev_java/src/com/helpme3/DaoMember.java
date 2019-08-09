package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DaoMember {
	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;
	
	// JOIN : 회원가입
	public String join(Map<String, Object> pMap) {
		String mem_id = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_join(?,?,?,?,?,?,?)}");
			cstmt.setString(1, pMap.get("mem_id").toString());
			cstmt.setString(2, pMap.get("mem_name").toString());
			cstmt.setString(3, pMap.get("mem_pw").toString());
			cstmt.setString(4, pMap.get("mem_nick").toString());
			cstmt.setString(5, pMap.get("mem_hp").toString());
			cstmt.setString(6, pMap.get("mem_birth").toString());
			cstmt.registerOutParameter(7, OracleTypes.VARCHAR);
			cstmt.execute();
			mem_id = cstmt.getString(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_id;
	}
	// OVERLAP : 아이디 중복
	public String overLap(String mem_id) {
		dbMgr = DBConnectionMgr_helpme.getInstance();
		String temp = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_overlap(?,?)}");
			cstmt.setString(1, mem_id);
			cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
			cstmt.execute();
			temp = cstmt.getString(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	// LOGIN
	public VOMem login(VOMem pVO) {
		VOMem rVO = null;
		String mem_id = pVO.getMem_id();
		String mem_pw = pVO.getMem_pw();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_chatlogin(?,?,?)}");
			cstmt.setString(1, mem_id);
			cstmt.setString(2, mem_pw);
			// out 파라미터 메소드
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			// 실행 요청 메소드 호출
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while (rs.next()) {
				rVO = new VOMem();
				rVO.setMem_id(rs.getString("mem_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt, rs, ocstmt);
		}
		return rVO;
	}
}
