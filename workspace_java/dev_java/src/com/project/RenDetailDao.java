package com.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.DBConnectionMgr;

public class RenDetailDao {
	Connection 		con   = null;
	PreparedStatement 	pstmt = null;
	CallableStatement cstmt =null;
	ResultSet          rs    = null;
	DBConnectionMgr    dbMgr = null;
	
	public List<Map<String, Object>> getDetMap(RenDetailVO paVO) {
		String gubun = null;
		String keyword = paVO.getKeyword();
		String u_rnum = paVO.getU_rnum();
		if("대여상세번호".equals(paVO.getCombobox())) {
			gubun = "r_detailnum";
		} else if("시리얼번호".equals(paVO.getCombobox())) {
			gubun = "serialnum";
		} else if("DVD명".equals(paVO.getCombobox())) {
			gubun = "mov_title";
		}
		List<Map<String, Object>> list = new ArrayList();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT r_num||'_'||r_detailnum, serialnum,mov_title,r_fee||'원'  ");
		sql.append("   FROM dvd natural join rendetail ");
		sql.append("  WHERE   "+gubun+" LIKE '%' || ? ||'%'         ");
		sql.append("  AND r_num = ?        ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			pstmt.setString(2, u_rnum);
			rs = pstmt.executeQuery();
			Map<String,Object> rMap = null;			
			while (rs.next()) {
				rMap = new HashMap();
				rMap.put("r_num||'_'||r_detailnum", rs.getString("r_num||'_'||r_detailnum"));
				rMap.put("serialnum", rs.getString("serialnum"));
				rMap.put("mov_title", rs.getString("mov_title"));
				rMap.put("r_fee", rs.getString("r_fee||'원'"));
				list.add(rMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	public RenDetailVO Insert(RenDetailVO rdpaVO) {
		RenDetailVO rdraVO = new RenDetailVO();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		try {
			sql.append(" INSERT INTO rendetail(r_detailnum,serialnum,r_num) ");
			sql.append("    VALUES(?,?,?)                                   ");
		    con = dbMgr.getConnection(); 
		    pstmt = con.prepareStatement(sql.toString());
		    int i = 0;
		    pstmt.setString(++i, rdpaVO.getR_detailnum());
		    pstmt.setString(++i, rdpaVO.getSerialnum());
		    pstmt.setString(++i, rdpaVO.getR_num());
		    status = pstmt.executeUpdate();
		    rdraVO.setStatus(status);
		    System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rdraVO;
	}

	public RenDetailVO delte(RenDetailVO rdpaVO) {
		dbMgr = DBConnectionMgr.getInstance();
		RenDetailVO rdraVO = new RenDetailVO();
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM rendetail WHERE r_num=? AND r_detailnum=? ");
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, rdpaVO.getR_num());
			pstmt.setString(2, rdpaVO.getR_detailnum());
			status = pstmt.executeUpdate();
			rdraVO.setStatus(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rdraVO;
	}

	public RenDetailVO Update(RenDetailVO rdpaVO) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE rendetail SET r_detailnum=?,serialnum=?  ");
		sql.append(" 		WHERE r_num=? AND r_detailnum=?                  ");
		RenDetailVO rdraVO = new RenDetailVO();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, rdpaVO.getR_detailnum());
			pstmt.setString(++i, rdpaVO.getSerialnum());
			pstmt.setString(++i, rdpaVO.getR_num());
			pstmt.setString(++i, rdpaVO.getU_detailnum());
			status = pstmt.executeUpdate();
			rdraVO.setStatus(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rdraVO;
	}

}
