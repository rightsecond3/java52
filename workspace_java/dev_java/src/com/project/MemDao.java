package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;

public class MemDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	
	public List<MemVO> getList(MemVO mpaVO) {
		String gubun = null;
		String keyword = mpaVO.getKeyword();
		if("아이디".equals(mpaVO.getCombobox())) {
			gubun = "memid";
		} else if("이름".equals(mpaVO.getCombobox())) {
			gubun = "memname";
		} else if("등록일".equals(mpaVO.getCombobox())) {
			gubun = "resistdate";
		}
		List<MemVO> list = new ArrayList<>();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT memid, memname, tel, phonenum, zipcode ");
	    sql.append("      ,address, resistdate, mempw   ");
	    sql.append("  FROM mem                      ");
	    sql.append("  WHERE "+gubun+" LIKE '%'|| ? ||'%' ");
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			MemVO mraVO = null;
			while(rs.next()) {
				mraVO = new MemVO();
				mraVO.setMemid(rs.getString("memid"));
				mraVO.setMemname(rs.getString("memname"));
				mraVO.setTel(rs.getString("tel"));
				mraVO.setPhonenum(rs.getString("phonenum"));
				mraVO.setZipcode(rs.getString("zipcode"));
				mraVO.setAddress(rs.getString("address"));
				mraVO.setResistdate(rs.getString("resistdate"));
				mraVO.setMempw(rs.getString("mempw"));
				list.add(mraVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {//사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	public MemVO memInsert(MemVO mpaVO) {
		MemVO mraVO = new MemVO();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		sql.append(" INSERT INTO mem(memid,memname,tel,phonenum,zipcode    ");
		sql.append("              ,address,mempw,resistdate)            ");
		sql.append("        VALUES(?,?,?,?,?,?                 ");
		sql.append("       ,?,TO_CHAR(SYSDATE,'YYYY-MM-DD')) ");
		try {
		    con = dbMgr.getConnection(); 
		    pstmt = con.prepareStatement(sql.toString());
		    int i = 0;
		    pstmt.setString(++i, mpaVO.getMemid());
		    pstmt.setString(++i, mpaVO.getMemname());
		    pstmt.setString(++i, mpaVO.getTel());
		    pstmt.setString(++i, mpaVO.getPhonenum());
		    pstmt.setString(++i, mpaVO.getZipcode());
		    pstmt.setString(++i, mpaVO.getAddress());
		    pstmt.setString(++i, mpaVO.getMempw());
		    //mraVO에 입력성공 실패 값을 반환해준다.
		    status = pstmt.executeUpdate();
		    mraVO.setStatus(status);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return mraVO;
	}

	public MemVO memUpdate(MemVO mpaVO) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE mem SET memname=?                                       ");
		sql.append(" 	  ,tel=?,phonenum=?,zipcode=?,address=?,mempw=? ");
		sql.append(" 	  WHERE memid=?                                         ");
		MemVO mraVO = new MemVO();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, mpaVO.getMemname());
			pstmt.setString(++i, mpaVO.getTel());
			pstmt.setString(++i, mpaVO.getPhonenum());
			pstmt.setString(++i, mpaVO.getZipcode());
			pstmt.setString(++i, mpaVO.getAddress());
			pstmt.setString(++i, mpaVO.getMempw());
			pstmt.setString(++i, mpaVO.getMemid());//u_memid가 memid에 담겨있음
			status = pstmt.executeUpdate();
			mraVO.setStatus(status);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return mraVO;                                                            
	}

	public MemVO memDelete(MemVO mpaVO) {
		StringBuilder sql = new StringBuilder();
		MemVO mraVO = new MemVO();
		sql.append(" DELETE FROM mem WHERE memid=? ");
		dbMgr = DBConnectionMgr.getInstance();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mpaVO.getMemid());
			status = pstmt.executeUpdate();
			mraVO.setStatus(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return mraVO;
	}

	public MemVO getMemDetail(MemVO mpaVO) {
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT memid,memname,tel,phonenum,zipcode,address,resistdate,mempw  ");
		sql.append("   FROM mem                                                          ");
		sql.append("  WHERE memid = ?                                                  ");
		MemVO mraVO = null;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mpaVO.getMemid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mraVO = new MemVO();
				mraVO.setMemid(rs.getString("memid"));
				mraVO.setMemname(rs.getString("memname"));
				mraVO.setTel(rs.getString("tel"));
				mraVO.setPhonenum(rs.getString("phonenum"));
				mraVO.setZipcode(rs.getString("zipcode"));
				mraVO.setAddress(rs.getString("address"));
				mraVO.setResistdate(rs.getString("resistdate"));
				mraVO.setMempw(rs.getString("mempw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return mraVO;
	}

}
