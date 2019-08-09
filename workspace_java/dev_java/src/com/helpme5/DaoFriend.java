package com.helpme5;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DaoFriend {
	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;
	
	// FRIEND : 친구 추가
	public String addFriend(VOFriend pVO) {
		String result = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_addfriend(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getFri_fid());
			cstmt.registerOutParameter(++i, OracleTypes.VARCHAR);
			cstmt.execute();
			result = cstmt.getString(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// FRIENDLIST : 친구목록
	public List<Map<String, Object>> friendList(String mem_id) {
		List<Map<String, Object>> rList = new ArrayList<>();
		Map<String, Object> rMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_friendlist(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, mem_id);
			cstmt.setString(++i, "");
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while (rs.next()) {
				rMap = new LinkedHashMap<String, Object>();
				rMap.put("mem_id", rs.getString("mem_id"));
				rMap.put("fri_fnick", rs.getString("fri_fnick"));
				rMap.put("mem_status", rs.getString("mem_status"));
				rMap.put("mem_img", rs.getString("mem_img"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}
	// CHANGEFRINICK
	public void changeFriNick(VOFriend pVO) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_changefrinick(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getFri_fid());
			cstmt.setString(++i, pVO.getFri_fnick());
			int result = cstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// DELETEFRIEND : 친구삭제
	public void deleteFriend(VOFriend pVO) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_deletefriend(?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getFri_fid());
			int result = cstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// SEARCHFRIEND : 친구 조건 검색
	public List<Map<String, Object>> searchFriend(VOFriend pVO) {
		List<Map<String, Object>> rList = new ArrayList<>();
		Map<String, Object> rMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_friendlist(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getKeyword());
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while(rs.next()) {
				rMap = new LinkedHashMap<String, Object>();
				rMap.put("mem_id", rs.getString("mem_id"));
				rMap.put("fri_fnick", rs.getString("fri_fnick"));
				rMap.put("mem_status", rs.getString("mem_status"));
				rMap.put("mem_img", rs.getString("mem_img"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}
}
