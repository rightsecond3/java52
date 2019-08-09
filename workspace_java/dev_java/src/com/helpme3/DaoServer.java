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
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_serverexit()}");
			int result = cstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// dbMgr.freeConnection(con, cstmt);
		}
	}

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
			while(rs.next()) {
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

	//*************************** 박상범 수정
	public List<VOChatList> getList() {
		List<VOChatList> nList = new Vector<>();
		VOChatList nameListVO = null;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_getlist(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement) cstmt;
			rs = ocstmt.getCursor(1);
			while(rs.next()) {
				nameListVO = new VOChatList();
				nameListVO.setClist_code(rs.getString("clist_code"));
				nameListVO.setClist_count(rs.getString("clist_count"));
				nameListVO.setClist_gubun(rs.getString("clist_gubun"));
				nameListVO.setClist_img(rs.getString("clist_img"));
				nameListVO.setClist_name(rs.getString("clist_name"));
				nameListVO.setClist_yourid(rs.getString("clist_yourid"));
				nameListVO.setMem_id(rs.getString("mem_id"));
				nameListVO.setAddNameList(rs.getString("addnamelist"));
				nList.add(nameListVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nList;
	}
	//*************************** 박상범 수정
	// MESSAGE : 클라의 로그에 박기위해 가져 오는 셀렉트문
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
	//ADDGROUP을 한 후 CHATNICK에 따로따로 상대가 설정한 닉네임으로 넣어주기 위한 메소드
	public void insertchatnick(VOChatList pVO, String chatid) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO chatnick(chat_nick,clist_code,chat_id) ");
		sql.append(" VALUES(?,?,?) ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			///////////////수정 삭제
			System.out.println("님과의 대화방 테스트"+pVO.getClist_name());
			pstmt.setString(++i, pVO.getClist_name());
			pstmt.setString(++i, pVO.getClist_code());
			pstmt.setString(++i, chatid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// CHATLIST
	public List<Map<String, Object>> chatList(String mem_id) {
		List<Map<String, Object>> chatList = new ArrayList<Map<String,Object>>();
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
			while(rs.next()) {
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
	// CHATLOG
	public List<Map<String, Object>> chatLog(String mem_id, String clist_code) {
		List<Map<String, Object>> logList = new ArrayList<Map<String,Object>>();
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
			while(rs.next()) {
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

	public List<Map<String, Object>> roomIn(String mem_id, String clist_code) {
		List<Map<String, Object>> rList = new Vector<Map<String,Object>>();
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
			while(rs.next()) {
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

	public List<Map<String, Object>> roomInList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = new ArrayList<Map<String,Object>>();
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
			while(rs.next()) {
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

	public List<Map<String, Object>> roomAddList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = new ArrayList<Map<String,Object>>();
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
			while(rs.next()) {
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
			System.out.println("Dao roomAddPerson : "+msg_title);
			rMap.put("gubun", gubun);
			rMap.put("r_clistcode", r_clistcode);
			rMap.put("msg_title", msg_title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rMap;
	}

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

	public List<Map<String, Object>> selyourid(String r_clistcode, String login_id) {
		List<Map<String, Object>> rList = new ArrayList<Map<String,Object>>();
		Map<String, Object> rMap = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT chat_id                ");
		sql.append("   FROM chatnick                 ");
		sql.append("  WHERE clist_code = ?          ");
		sql.append("   AND chat_id != ?              ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, r_clistcode);
			pstmt.setString(2, login_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rMap = new HashMap<String, Object>();
				rMap.put("yourid", rs.getString("chat_id"));
				rList.add(rMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	public void exitRoom(String clist_code, String login_id) {
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_exitroom(?,?)}");
			cstmt.setString(1, login_id);
			cstmt.setString(2, clist_code);
			int result = cstmt.executeUpdate();
			System.out.println("DaoServer_eixtRoom result : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VOMem setting(String login_id) {
		VOMem rmVO = new VOMem();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT mem_nick, mem_status, mem_img ");
		sql.append("   FROM mem                           ");
		sql.append("  WHERE mem_id = ?                    ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, login_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rmVO.setMem_nick(rs.getString("mem_nick"));
				rmVO.setMem_status(rs.getString("mem_status"));
				rmVO.setMem_img(rs.getString("mem_img"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rmVO;
	}

	public void setNick(String login_id, String changeNick) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE mem SET mem_nick = ? WHERE mem_id = ?");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, changeNick);
			pstmt.setString(2, login_id);
			int result = pstmt.executeUpdate();
			System.out.println("sDao_SETNICK : 업데이트 "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setStatus(String login_id, String changeStatus) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE mem SET mem_status = ? WHERE mem_id = ?");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, changeStatus);
			pstmt.setString(2, login_id);
			int result = pstmt.executeUpdate();
			System.out.println("sDao_setStatus : 업데이트 "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImg(String login_id, String changeImg) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE mem SET mem_img = ? WHERE mem_id = ?");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, changeImg);
			pstmt.setString(2, login_id);
			int result = pstmt.executeUpdate();
			System.out.println("sDao_setImg : 업데이트 "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
