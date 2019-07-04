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

public class RentDao {
	Connection 		con   = null;
	PreparedStatement 	pstmt = null;
	CallableStatement cstmt =null;
	ResultSet          rs    = null;
	DBConnectionMgr    dbMgr = null;

	public List<Map<String, Object>> getRentMap(RentVO paVO) {
		String gubun = null;
		String keyword = paVO.getKeyword();
		if("대여번호".equals(paVO.getCombobox())) {
			gubun = "r_num";
		} else if("이름".equals(paVO.getCombobox())) {
			gubun = "memname";
		} else if("대여일".equals(paVO.getCombobox())) {
			gubun = "r_date";
		}
		List<Map<String, Object>> list = new ArrayList();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT r_num ,memid,memname,r_date,returndate,duedate,phonenum,latefee ");
		sql.append("   FROM MEM natural join Rental                 ");
		sql.append("  WHERE " +gubun+ " LIKE '%' || ? ||'%'                                                  ");
		sql.append("  ORDER BY r_num ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			Map<String,Object> rMap = null;			
			while (rs.next()) {
				rMap = new HashMap();
				rMap.put("r_num", rs.getString("r_num"));
				rMap.put("memid", rs.getString("memid"));
				rMap.put("memname", rs.getString("memname"));
				rMap.put("r_date", rs.getString("r_date"));
				rMap.put("returndate", rs.getString("returndate"));
				rMap.put("duedate", rs.getString("duedate"));
				rMap.put("phonenum", rs.getString("phonenum"));
				rMap.put("latefee", rs.getString("latefee"));
				list.add(rMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		
		return list;
	}

	public RentVO delete(RentVO paVO) {
		dbMgr = DBConnectionMgr.getInstance();
		RentVO raVO = new RentVO();
		String u_rnum = paVO.getR_num();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_renDelete(?)}");
			cstmt.setString(1, u_rnum);
			status = cstmt.executeUpdate();
			raVO.setStatus(status);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, cstmt);
		}
		return raVO;
	}

	public RentVO Insert(RentVO rpaVO) {
		RentVO rraVO = new RentVO();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		sql.append(" INSERT INTO rental(r_num,r_date,returndate,latefee  ");
		sql.append(" 		          ,duedate,memid)                    ");
		sql.append(" 	VALUES(?,TO_CHAR(SYSDATE,'YYYY-MM-DD'),?,?       ");
		sql.append("			,?,?)                                    ");
		try {
		    con = dbMgr.getConnection(); 
		    pstmt = con.prepareStatement(sql.toString());
		    int i = 0;
		    pstmt.setString(++i, rpaVO.getR_num());
		    pstmt.setString(++i, rpaVO.getReturndate());
		    pstmt.setInt(++i, rpaVO.getLatefee());
		    pstmt.setString(++i, rpaVO.getDuedate());
		    pstmt.setString(++i, rpaVO.getMemid());
		    status = pstmt.executeUpdate();
		    rraVO.setStatus(status);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rraVO;
	}

	public RentVO update(RentVO rpaVO) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE rental SET returndate=?  ");
		sql.append(" 		,latefee=?,duedate=?,memid=?     ");
		sql.append(" 		WHERE r_num=?                    ");
		RentVO rraVO = new RentVO();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, rpaVO.getReturndate());
			pstmt.setInt(++i, rpaVO.getLatefee());
			pstmt.setString(++i, rpaVO.getDuedate());
			pstmt.setString(++i, rpaVO.getMemid());
			pstmt.setString(++i, rpaVO.getR_num());
			status = pstmt.executeUpdate();
			rraVO.setStatus(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return rraVO;
	}

}
