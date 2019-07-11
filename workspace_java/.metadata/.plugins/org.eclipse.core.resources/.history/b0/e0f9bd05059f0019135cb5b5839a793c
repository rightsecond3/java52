package com.helpme2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.util.DBConnectionMgr_helpme;

public class Dao {
	DBConnectionMgr_helpme dbMgr  = null;
	Connection con                = null;
	PreparedStatement pstmt       = null;
	ResultSet rs                  = null;
	
	public List<testVO> test() {
		List<testVO> tList = new Vector<testVO>();
		dbMgr = DBConnectionMgr_helpme.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT mem_id, mem_name, mem_email   ");
		sql.append("   FROM chat_member                   ");
		sql.append("   ORDER BY mem_name ASC              ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			testVO tVO = null;
			while(rs.next()) {
				tVO = new testVO();
				tVO.setMem_id(rs.getString("mem_id"));//프사
				tVO.setMem_name(rs.getString("mem_name")); //이름
				tVO.setMem_email(rs.getString("mem_email"));//상메
				tList.add(tVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tList;
	}
}
