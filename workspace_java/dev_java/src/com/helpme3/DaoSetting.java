package com.helpme3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DBConnectionMgr_helpme;

import oracle.jdbc.OracleCallableStatement;

public class DaoSetting {
	DBConnectionMgr_helpme dbMgr = null;
	Connection con = null;
	CallableStatement cstmt = null;// query
	PreparedStatement pstmt = null;// procedure
	OracleCallableStatement ocstmt = null;// refcursor
	ResultSet rs = null;
	
	// SETTING
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
