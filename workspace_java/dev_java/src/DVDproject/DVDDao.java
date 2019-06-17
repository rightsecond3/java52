package DVDproject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;

public class DVDDao {
	Connection con          = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null; // 프로시저를 호출, 요청
	ResultSet         rs    = null;
	DBConnectionMgr   dbMgr = null;
	
	//파라미터로 끌고오자
	public List<DVDVO> getRent(DVDVO paVO) {
		System.out.println("Dao getRent 호출");
		String gubun = null;
		String combobox = paVO.getCombobox();
		String keyword  = paVO.getKeyword();
		if("DVD명".equals(combobox)) {
			gubun = "mov_title";
		} else if("이름".equals(combobox)) {
			gubun = "memname"; 
		} else if("대여날짜".equals(combobox)) {
			gubun = "r_date";
		}
		List<DVDVO> list = new ArrayList<DVDVO>();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r_date,memname,mov_title,phonenum,address,returndate  ");
		sql.append("  FROM rental r, mem m, dvd d, rendetail rd                  ");
		sql.append(" WHERE m.memid = r.memid                                     ");
		sql.append("    AND rd.serialnum = d.serialnum                           ");
		sql.append("    AND r.r_num = rd.r_num                                   ");
		sql.append("    AND "+gubun+" LIKE '%' || ? || '%' ");
		sql.append(" ORDER BY r_date DESC         				");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			System.out.println(gubun);
			System.out.println(keyword);
			//pstmt.setString(1, gubun);
			//PreparedStatement는 컬럼정보에 대해서는 ? 처리를 해주지않는다.
			//컬럼정보는 PreparedStatement의 구역이 아니다.
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			DVDVO raVO = null;
			while(rs.next()) {
				raVO = new DVDVO();
				raVO.setR_date(rs.getString("r_date"));
				raVO.setMemname(rs.getString("memname"));
				raVO.setMov_title(rs.getString("mov_title"));
				raVO.setPhonenum(rs.getString("phonenum"));
				raVO.setAddress(rs.getString("address"));
				raVO.setReturndate(rs.getString("returndate"));
				list.add(raVO);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}
}
