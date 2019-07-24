package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/*
 * 다오
 */
public class ChatDao {

	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;

	// ** 로그인 처리
	public String login(String memid, String mempw) {
		String mem_id = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_chatlogin(?,?,?)}");
			cstmt.setString(1, memid);
			cstmt.setString(2, mempw);
			// out 파라미터 메소드
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			// 실행 요청 메소드 호출
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while (rs.next()) {
				mem_id = rs.getString("mem_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//ocstmt close하는 메소드 생성
		}
		return mem_id;
	}

	// ** 친구목록
	public List<Map<String, Object>> friend(String mem_id) {
		List<Map<String, Object>> tList = new Vector<>();
		dbMgr = DBConnectionMgr_helpme.getInstance();
		StringBuilder sql = new StringBuilder();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_friendlist(?, ?)}");
			cstmt.setString(1, mem_id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(2);
			Map<String, Object> rMap = null;
			while (rs.next()) {
				rMap = new LinkedHashMap<>();
				rMap.put("mem_img", rs.getString("mem_img"));// 프사
				rMap.put("mem_nick", rs.getString("mem_nick")); // 이름
				rMap.put("mem_status", rs.getString("mem_status"));// 상메
				rMap.put("mem_id", rs.getString("mem_id"));//
				tList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tList;
	}

	// ** 채팅방 목록 박기
	public List<Map<String, Object>> getChatMap() {
		List<Map<String, Object>> list = new Vector<>();
		dbMgr = DBConnectionMgr_helpme.getInstance();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_chatlist(?,?)}");
			cstmt.setString(1, "jvm");
			// out 파라미터 메소드
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			// 실행 요청 메소드 호출
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(2);
			Map<String, Object> rMap = null;
			while (rs.next()) {
				rMap = new LinkedHashMap<>();
				rMap.put("clist_img", rs.getString("clist_img"));
				rMap.put("clist_name", rs.getString("clist_name"));
				rMap.put("clog_contents", rs.getString("clog_contents"));
				rMap.put("clog_time", rs.getString("clog_time"));
				list.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	//** 친구목록 더블클릭 이벤트시 갠톡 단톡 구분하여 채팅창 띄우기
	public VOChatList getNewRoom(String mem_id, String your_id) {
		VOChatList pVO = new VOChatList();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_newroom(?,?,?)}");
			cstmt.setString(1, mem_id);
			cstmt.setString(2, your_id);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.execute();
			String result = cstmt.getString(3);
			pVO.setClist_gubun(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pVO;
	}

}
