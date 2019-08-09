package com.helpme4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DaoMessage {
	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;
	
	// INSERTMESSAGE
	public void insMsg(Map<String, Object> pMap) {
		Map<String, Object> rMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_insertmessage(?,?,?,?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pMap.get("writer").toString());
			cstmt.setString(++i, pMap.get("content").toString());
			cstmt.setString(++i, pMap.get("date").toString());
			cstmt.setString(++i, pMap.get("time").toString());
			cstmt.setString(++i, pMap.get("clist_code").toString());
			cstmt.setString(++i, pMap.get("imogi").toString());
			cstmt.executeUpdate();
			System.out.println("insertmessage clist_code : "+pMap.get("clist_code"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt, rs, ocstmt);
		}
	}
	// MESSAGE : 클라의 로그에 박기위해 가져 오는 셀렉트문
	// 각자 상대방들이 보는 그 사람의 닉네임을 가져오기 위함.
	public List<Map<String, Object>> selMessage(Map<String, Object> pMap) {
		List<Map<String, Object>> rList = new ArrayList<Map<String,Object>>();
		Map<String, Object> rMap = new HashMap<String, Object>();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_selmessage(?,?)}");
			int i = 0;
			cstmt.setString(++i, pMap.get("clist_code").toString());
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(i);
			while(rs.next()) {
				rMap = new HashMap<String, Object>();
				rMap.put("chat_id", rs.getString("chat_id"));
				rMap.put("fri_fnick", rs.getString("fri_fnick"));
				rMap.put("mem_img", rs.getString("mem_img"));
				rMap.put("clist_code", rs.getString("clist_code"));
				rMap.put("clog_time", rs.getString("clog_time"));
				rMap.put("clog_contents", rs.getString("clog_contents"));
				rMap.put("clog_imo", rs.getString("clog_imo"));
				rMap.put("clog_writer", rs.getString("clog_writer"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}
}
