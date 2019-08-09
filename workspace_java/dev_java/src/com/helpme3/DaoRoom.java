package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class DaoRoom {
	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;

	// ADDGROUP
	public VOChatList createGroup(VOChatList pVO) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_newroom2(?,?,?,?,?)}");
			int i = 0;
			cstmt.setString(++i, pVO.getMem_id());
			cstmt.setString(++i, pVO.getClist_yourid());
			cstmt.setString(++i, pVO.getClist_gubun());
			cstmt.registerOutParameter(++i, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			String result = cstmt.getString(4);
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(5);
			while (rs.next()) {
				pVO.setClist_code(rs.getString("clist_code"));
				pVO.setClist_yourid(rs.getString("clist_yourid"));
				pVO.setClist_count(rs.getString("clist_count"));
				pVO.setClist_name(rs.getString("clist_name"));
				pVO.setClist_gubun(rs.getString("clist_gubun"));
				pVO.setClist_img(rs.getString("clist_img"));
				pVO.setMem_id(rs.getString("mem_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pVO;
	}

	// ADDGROUP을 한 후 CHATNICK에 따로따로 상대가 설정한 닉네임으로 넣어주기 위한 메소드
	public void insertchatnick(VOChatList pVO, String chatid) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO chatnick(chat_nick,clist_code,chat_id) ");
		sql.append(" VALUES(?,?,?) ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			/////////////// 수정 삭제
			System.out.println("님과의 대화방 테스트" + pVO.getClist_name());
			pstmt.setString(++i, pVO.getClist_name());
			pstmt.setString(++i, pVO.getClist_code());
			pstmt.setString(++i, chatid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 개인톡 더블클릭 시 ROOMCREATE
	public List<VOChatList> getRoomCreate(VOChatList pVO) {
		String mem_id = pVO.getMem_id();
		System.out.println(mem_id);
		String your_id = pVO.getClist_yourid();
		System.out.println(your_id);
		String gubun = pVO.getClist_gubun();
		List<VOChatList> rList = new ArrayList<VOChatList>();
		VOChatList rVO = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_newroom2(?, ?, ?, ?, ?)}");
			cstmt.setString(1, mem_id);
			cstmt.setString(2, your_id);
			cstmt.setString(3, gubun);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(5);
			while (rs.next()) {
				rVO = new VOChatList();
				rVO.setResult(cstmt.getString(4)); // 새창, clist
				rVO.setClist_code(rs.getString("clist_code"));
				rVO.setClist_count(rs.getString("clist_count"));
				rVO.setClist_name(rs.getString("chat_nick"));
				rVO.setClist_gubun(rs.getString("clist_gubun"));
				rVO.setClist_img(rs.getString("clist_img"));
				rVO.setMem_id(rs.getString("chat_id"));
				rList.add(rVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt, rs, ocstmt);
		}
		return rList;
	}

	// ROOM_IN
	public List<Map<String, Object>> roomIn(String mem_id, String clist_code) {
		List<Map<String, Object>> rList = new Vector<Map<String, Object>>();
		Map<String, Object> rMap = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT clist_code, chat_id, chat_nick  ");
		sql.append(" FROM(SELECT clist_code, chat_id        ");
		sql.append("      FROM chatnick                     ");
		sql.append("      WHERE clist_code = ?)             ");
		sql.append("     ,(SELECT chat_nick                 ");
		sql.append("       FROM chatnick                    ");
		sql.append("       WHERE clist_code = ?             ");
		sql.append("      AND chat_id = ?)                  ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, clist_code);
			pstmt.setString(2, clist_code);
			pstmt.setString(3, mem_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rMap = new HashMap<String, Object>();
				rMap.put("clist_code", rs.getString("clist_code"));
				rMap.put("chat_id", rs.getString("chat_id"));
				rMap.put("chat_nick", rs.getString("chat_nick"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	// ROOM_INLIST
	public List<Map<String, Object>> roomInList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = new ArrayList<Map<String, Object>>();
		Map<String, Object> rMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_roominlist(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, login_id);
			cstmt.setString(++i, clist_code);
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(i);
			while (rs.next()) {
				rMap = new HashMap<String, Object>();
				rMap.put("fri_fid", rs.getString("fri_fid"));
				rMap.put("fri_fnick", rs.getString("fri_fnick"));
				rMap.put("mem_img", rs.getString("mem_img"));
				rMap.put("clist_code", rs.getString("clist_code"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	// ROOM_ADDLIST : 톡방에 초대할 때 톡방에 있는 사람들 제외한 목록 가져오기
	public List<Map<String, Object>> roomAddList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = new ArrayList<Map<String, Object>>();
		Map<String, Object> rMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_roomaddlist(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, login_id);
			cstmt.setString(++i, clist_code);
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(i);
			while (rs.next()) {
				rMap = new HashMap<String, Object>();
				rMap.put("fri_fid", rs.getString("fri_fid"));
				rMap.put("fri_fnick", rs.getString("fri_fnick"));
				rMap.put("mem_img", rs.getString("mem_img"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	// ROOM_ADD : 톡방에 초대하기
	public Map<String, Object> roomAddPerson(String clist_code, String addPerson, String login_id) {
		Map<String, Object> rMap = new HashMap<String, Object>();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_addperson2(?,?,?,?,?,?)}");
			int i = 0;
			cstmt.setString(++i, login_id);
			cstmt.setString(++i, clist_code);
			cstmt.setString(++i, addPerson);
			cstmt.registerOutParameter(++i, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(++i, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(++i, OracleTypes.VARCHAR);
			cstmt.execute();
			String gubun = cstmt.getString(4);
			String r_clistcode = cstmt.getString(5);
			String msg_title = cstmt.getString(6);
			System.out.println("Dao roomAddPerson : " + msg_title);
			rMap.put("gubun", gubun);
			rMap.put("r_clistcode", r_clistcode);
			rMap.put("msg_title", msg_title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rMap;
	}
	// ROOMADD : 나를 제외한 사람들 닉네임가져오기 단톡방 만들기
	public List<Map<String, Object>> selyourid(String r_clistcode, String login_id) {
		List<Map<String, Object>> rList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		Map<String, Object> rMap = null;
		sql.append(" SELECT  chat_id       ");
		sql.append(" FROM chatnick         ");
		sql.append(" WHERE clist_code = ?  ");
		sql.append(" AND chat_id != ?      ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, r_clistcode);
			pstmt.setString(2, login_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rMap = new HashMap<String, Object>();
				rMap.put("yourid", rs.getString("chat_id"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	// ROOM_ADD : 해당 사람들 인서트 해주기
	public void insPerson(String r_clistcode, String people) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("call proc_insperson(?,?)");
			cstmt.setString(1, r_clistcode);
			cstmt.setString(2, people);
			cstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ROOM_OUT : 톡방 나가기
	public void exitRoom(String clist_code, String login_id) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_exitroom(?,?)}");
			cstmt.setString(1, login_id);
			cstmt.setString(2, clist_code);
			int result = cstmt.executeUpdate();
			System.out.println("DaoServer_eixtRoom result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CHATLOG : 채팅방 로그 불러오기
	public List<Map<String, Object>> chatLog(String mem_id, String clist_code) {
		List<Map<String, Object>> logList = new ArrayList<Map<String, Object>>();
		Map<String, Object> logMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_chatlog4(?,?,?)}");
			int i = 0;
			cstmt.setString(++i, mem_id);
			cstmt.setString(++i, clist_code);
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(3);
			while (rs.next()) {
				logMap = new HashMap<String, Object>();
				logMap.put("clog_writer", rs.getString("clog_writer"));
				logMap.put("fri_fnick", rs.getString("fri_fnick"));
				logMap.put("fri_fid", rs.getString("fri_fid"));
				logMap.put("clist_code", rs.getString("clist_code"));
				logMap.put("clog_imo", rs.getString("clog_imo"));
				logMap.put("clog_contents", rs.getString("clog_contents"));
				logMap.put("clog_time", rs.getString("clog_time"));
				logMap.put("mem_img", rs.getString("mem_img"));
				logList.add(logMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logList;
	}

	// CHATLIST : 모든 채팅방 리스트 가져오기
	public List<Map<String, Object>> chatList(String mem_id) {
		List<Map<String, Object>> chatList = new ArrayList<Map<String, Object>>();
		Map<String, Object> cMap = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_chatlist(?,?)}");
			int i = 0;
			cstmt.setString(++i, mem_id);
			cstmt.registerOutParameter(++i, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(2);
			while (rs.next()) {
				cMap = new HashMap<String, Object>();
				cMap.put("clist_code", rs.getString("clist_code"));
				cMap.put("chat_nick", rs.getString("chat_nick"));
				cMap.put("clist_img", rs.getString("clist_img"));
				cMap.put("clog_contents", rs.getString("clog_contents"));
				cMap.put("clog_time", rs.getString("clog_time"));
				cMap.put("clist_yourid", rs.getString("clist_yourid"));
				chatList.add(cMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chatList;
	}

}