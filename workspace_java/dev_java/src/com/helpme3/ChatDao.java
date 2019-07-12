package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ChatDao {

	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;

	// ** 로그인 처리
	public String login(String memid, String mempw) {
		String nick = null;
		try {
			con = DBConnectionMgr_helpme.getConnection();
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
				nick = rs.getString("mem_nick");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nick;
	}

	// ** 채팅방 목록 박기
	public List<Map<String, Object>> getChatMap() {
		List<Map<String, Object>> list = new Vector<>();
		dbMgr = DBConnectionMgr_helpme.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT clist_img, clist_name, clog_contents, clog_time, clist_code ");
		sql.append("   FROM chatlog natural join mem natural join chatlist  ");
		sql.append("  WHERE clog_rno =                                      ");
		sql.append("        (                                               ");
		sql.append("        SELECT MAX(clog_rno)                            ");
		sql.append("          FROM chatlog                                  ");
		sql.append("         WHERE clist_code = ?                           ");
		sql.append("         )                                              ");
		sql.append("     OR clog_rno =                                      ");
		sql.append("        (                                               ");
		sql.append("        SELECT MAX(clog_rno)                            ");
		sql.append("          FROM chatlog                                  ");
		sql.append("         WHERE clist_code = ?                           ");
		sql.append("         )                                              ");
		sql.append("  ORDER BY clog_time  desc                              ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "jvm0");
			pstmt.setString(2, "jvm1");
			rs = pstmt.executeQuery();
			Map<String, Object> rMap = null;
			while (rs.next()) {
				rMap = new LinkedHashMap<>();
				rMap.put("clist_img", rs.getString("clist_img"));
				rMap.put("clist_name", rs.getString("clist_name"));
				rMap.put("clog_contents", rs.getString("clog_contents"));
				rMap.put("clog_time", rs.getString("clog_time"));
				rMap.put("clist_code", rs.getString("clist_code"));
				list.add(rMap);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}

}
