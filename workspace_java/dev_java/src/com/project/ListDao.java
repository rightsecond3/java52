package com.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;

public class ListDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	
	public List<ListVO> getList(ListVO paVO) {
		String gubun = null;
		String keyword = paVO.getKeyword();
		if("제목".equals(paVO.getCombobox())) {
			gubun = "mov_title";
		} else if("국가".equals(paVO.getCombobox())) {
			gubun = "nation";
		} else if("대여료".equals(paVO.getCombobox())) {
			gubun = "r_fee";
		}
		List<ListVO> list = new ArrayList<>();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT serialnum,genre,mov_class,mov_title,maker ");
	    sql.append(" ,nation,leadingactor,director,mov_date,v_date   ");
	    sql.append(" ,damage,r_check,r_fee");
	    sql.append("  FROM DVD                      ");
	    sql.append("  WHERE "+gubun+" LIKE '%'|| ? ||'%' ");
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			ListVO raVO = null;
			while(rs.next()) {
				raVO = new ListVO();
				raVO.setSerialnum(rs.getString("serialnum"));
				raVO.setGenre(rs.getString("genre"));
				raVO.setMov_class(rs.getString("mov_class"));
				raVO.setMov_title(rs.getString("mov_title"));
				raVO.setMaker(rs.getString("maker"));
				raVO.setNation(rs.getString("nation"));
				raVO.setLeadingactor(rs.getString("leadingactor"));
				raVO.setDirector(rs.getString("director"));
				raVO.setMov_date(rs.getString("mov_date"));
				raVO.setV_date(rs.getString("v_date"));
				raVO.setDamage(rs.getString("damage"));
				raVO.setR_check(rs.getString("r_check"));
				raVO.setR_fee(rs.getInt("r_fee"));
				list.add(raVO);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {//사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}

	public ListVO Insert(ListVO paVO) {
		ListVO raVO = new ListVO();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		int status = 0;
		try {
			sql.append(" INSERT INTO dvd(serialnum,genre,mov_class,mov_title ");
		    sql.append(" ,maker,nation,leadingactor,director,mov_date,v_date ");
		    sql.append(" ,damage,r_check,r_fee) ");
		    sql.append("        VALUES(?,?,?,?,?,?,?,?,?,? ");
		    sql.append("       ,?,?,?) ");
		    con = dbMgr.getConnection(); 
		    pstmt = con.prepareStatement(sql.toString());
		    int i = 0;
		    pstmt.setString(++i, paVO.getSerialnum());
		    pstmt.setString(++i, paVO.getGenre());
		    pstmt.setString(++i, paVO.getMov_class());
		    pstmt.setString(++i, paVO.getMov_title());
		    pstmt.setString(++i, paVO.getMaker());
		    pstmt.setString(++i, paVO.getNation());
		    pstmt.setString(++i, paVO.getLeadingactor());
		    pstmt.setString(++i, paVO.getDirector());
		    pstmt.setString(++i, paVO.getMov_date());
		    pstmt.setString(++i, paVO.getV_date());
		    pstmt.setString(++i, paVO.getDamage());
		    pstmt.setString(++i, paVO.getR_check());
		    pstmt.setInt(++i, paVO.getR_fee());
		    //mraVO에 입력성공 실패 값을 반환해준다.
		    status = pstmt.executeUpdate();
		    raVO.setStatus(status);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;
	}

	public ListVO Update(ListVO paVO) {
		System.out.println("Dao");
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE dvd SET genre=?,mov_class=?,mov_title=? ");
		sql.append(" ,maker=?,nation=?,leadingactor=?,director=?,mov_date=? ");
		sql.append(" ,v_date=?,damage=?,r_check=?,r_fee=? ");
		sql.append(" 	  WHERE serialnum=?          ");
		ListVO raVO = new ListVO();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, paVO.getGenre());
			pstmt.setString(++i, paVO.getMov_class());
			pstmt.setString(++i, paVO.getMov_title());
			pstmt.setString(++i, paVO.getMaker());
			pstmt.setString(++i, paVO.getNation());
			pstmt.setString(++i, paVO.getLeadingactor());
			pstmt.setString(++i, paVO.getDirector());
			pstmt.setString(++i, paVO.getMov_date());
			pstmt.setString(++i, paVO.getV_date());
			pstmt.setString(++i, paVO.getDamage());
			pstmt.setString(++i, paVO.getR_check());
			pstmt.setInt(++i, paVO.getR_fee());
			pstmt.setString(++i, paVO.getSerialnum());//u_memid가 memid에 담겨있음
			status = pstmt.executeUpdate();
			raVO.setStatus(status);
			System.out.println(status);
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;                                                            
	}

	public ListVO Delete(ListVO paVO) {
		StringBuilder sql = new StringBuilder();
		ListVO raVO = new ListVO();
		sql.append(" DELETE FROM dvd WHERE serialnum=? ");
		dbMgr = DBConnectionMgr.getInstance();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, paVO.getSerialnum());
			status = pstmt.executeUpdate();
			raVO.setStatus(status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;
	}

}
