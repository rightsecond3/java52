package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DaoServer {
	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;

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

	// 개인톡 더블클릭 시
	public VOChatList getRoomCreate(VOChatList pVO) {
		System.out.println("Dao getRoomCreate");
		String mem_id = pVO.getMem_id();
		String your_id = pVO.getClist_yourid();
		VOChatList rVO = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_newroom(?,?,?)}");
			cstmt.setString(1, mem_id);
			cstmt.setString(2, your_id);
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while (rs.next()) {
				rVO = new VOChatList();
				rVO.setClist_code(rs.getString("clist_code"));
				rVO.setClist_yourid(rs.getString("clist_yourid"));
				rVO.setClist_count(rs.getString("clist_code"));
				rVO.setClist_name(rs.getString("clist_name"));
				rVO.setClist_gubun(rs.getString("clist_gubun"));
				rVO.setClist_img(rs.getString("clist_img"));
				rVO.setMem_id(rs.getString("mem_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt, rs, ocstmt);
		}
		return rVO;
	}

	// * VOCList에 담는것
	public List<VOChatList> getcList() {
		dbMgr = DBConnectionMgr_helpme.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT clist_code, clist_yourid, clist_count, clist_name, ");
		sql.append("        clist_gubun, clist_img, mem_id                     ");
		sql.append("   FROM chatlist                                           ");
		List<VOChatList> rList = new Vector<VOChatList>();
		VOChatList rVO = null;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rVO = new VOChatList();
				rVO.setClist_code(rs.getString("clist_code"));
				rVO.setClist_yourid(rs.getString("clist_yourid"));
				rVO.setClist_count(rs.getString("clist_count"));
				rVO.setClist_name(rs.getString("clist_name"));
				rVO.setClist_gubun(rs.getString("clist_gubun"));
				rVO.setClist_img(rs.getString("clist_img"));
				rVO.setMem_id(rs.getString("mem_id"));
				rList.add(rVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, pstmt, rs);
		}
		return rList;
	}

	// * 서버가 닫힐 때 리스트와 로그 싹 다 날리기
	public void serverClosing() {
		try {
			System.out.println("serverClosing");
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_serverexit()}");
			int result = cstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt);
		}
	}

	// MESSAGE
	public Map<String, Object> insMsg(Map<String, Object> pMap) {
		Map<String, Object> rMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_loginsert(?,?,?,?,?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pMap.get("writer").toString());
			cstmt.setString(++i, pMap.get("content").toString());
			cstmt.setString(++i, pMap.get("date").toString());
			cstmt.setString(++i, pMap.get("time").toString());
			cstmt.setString(++i, pMap.get("clist_code").toString());
			cstmt.setString(++i, pMap.get("imogi").toString());
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(7);
			while (rs.next()) {
				rMap = new LinkedHashMap<String, Object>();
				rMap.put("mem_img", rs.getString("mem_img"));
				rMap.put("mem_nick", rs.getString("mem_nick"));
				rMap.put("clog_writer", rs.getString("clog_writer"));
				rMap.put("clog_time", rs.getString("clog_time"));
				rMap.put("clist_code", rs.getString("clist_code"));
				rMap.put("clog_contents", rs.getString("clog_contents"));
				rMap.put("clog_imo", rs.getString("clog_imo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt, rs, ocstmt);
		}
		return rMap;
	}

	// * 아이디 중복
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

	// * FRIENDLIST
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

	// 친구 추가
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
			System.out.println("Dao" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 친구 닉네임 변경
	public void changeFriNick(VOFriend pVO) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_changefrinick(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getFri_fid());
			cstmt.setString(++i, pVO.getFri_fnick());
			int result = cstmt.executeUpdate();
			System.out.println("changeFriNick 결과 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 친구 삭제
	public void deleteFriend(VOFriend pVO) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_deletefriend(?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getFri_fid());
			int result = cstmt.executeUpdate();
			System.out.println("deleteFreind의 결과 : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
