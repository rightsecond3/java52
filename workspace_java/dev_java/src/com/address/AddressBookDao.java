package com.address;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBConnectionMgr;


public class AddressBookDao implements AddressBookInterface {
	java.sql.Connection          con   = null; 
	java.sql.PreparedStatement   pstmt = null;
	java.sql.ResultSet           rs    = null;
	com.util.DBConnectionMgr     dbMgr = null;
	
	//** 상세조회 **//
	@Override
	public AddressVO getAddressDetail(AddressVO paVO) {
		System.out.println("DAO getAddressDetail 호출성공");
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, gender, hp ");
	    sql.append("      ,birthday, comments, regdate   ");
	    sql.append("  FROM mkaddrtb                      ");
	    sql.append("  WHERE id = ? ");
	    AddressVO raVO = null;
	    try {
	    	// 물리적으로 떨어진 DB에 통로를 생성
			con = dbMgr.getConnection();
			// sql문을 String으로 바꿔서 전달 해라
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, paVO.getId());
			// pstmt의 sql 쿼리문을 실행시켜줘라
			rs = pstmt.executeQuery();
			// rs.previous() 쓰지 않는 이유는 오라클 커서가 항상 (디폴트) top에 있으니까
			// rs.next()는 커서를 다음으로 이동시켜주라는 뜻
			// VO는 한행만 담을 수 있는 장애를 가지고 있다.
			if(rs.next()) {
				raVO = new AddressVO();
				//리턴값으로 받을 전체 조회 데이터는 raVO에 넣어준다.
				raVO.setId(rs.getString("id")); 
				raVO.setName(rs.getString("name")); 
				raVO.setGender(rs.getString("gender")); 
				raVO.setBirthday(rs.getString("birthday")); 
				raVO.setHp(rs.getString("hp")); 
				raVO.setRegdate(rs.getString("regdate")); 
				raVO.setComments(rs.getString("comments"));
				raVO.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			// 예외가 발생할 경우 stack영역에 메세지를 쌓아두는데 이 정보를 출력하는 메소드
			// 꼭 기억해둘것. 클래스명과 라인번호 정보까지고 얻을 수 있음.
			// 주의 : pringln()안에 사용하지 말것.
			// Exception에 대한 history정보까지 출력해줌.
			e.printStackTrace();
		} finally { // 사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return raVO;
	}
	
	//** 입력 **//
	@Override
	public AddressVO addressInsert(AddressVO paVO) {
		System.out.println("DAO addressInsert 호출성공");
		AddressVO raVO = null;
		raVO = new AddressVO();
		dbMgr=com.util.DBConnectionMgr.getInstance();
		// +연산자를 써도 String 객체가 새로 생성되지 않음
		StringBuilder sql = new StringBuilder();
		int status = 0; // 0이면 입력 실패, 1이면 입력성공
		try {
			sql.append("INSERT INTO mkaddrtb VALUES(?,?,?,?,?,?,?,TO_CHAR(sysdate,'YYYY-MM-DD')) ");
			// db의 정보를 보내는 통로
			con = dbMgr.getConnection();
			// sql문을 전송
			pstmt = con.prepareStatement(sql.toString());
			int i=0;
			// 물음표의 위치가 setString의 
			pstmt.setString(++i, paVO.getId());
			pstmt.setString(++i, paVO.getName());
			pstmt.setString(++i, paVO.getAddress());
			pstmt.setString(++i, paVO.getHp());
			pstmt.setString(++i, paVO.getGender());
			pstmt.setString(++i, paVO.getBirthday());
			pstmt.setString(++i, paVO.getComments());
			// DML 구문의 UPDATE, DELETE, INSERT문 리턴받기
			// 입력된 후에 오라클 서버로 부터 응답 받은 값 - int
			status = pstmt.executeUpdate();
			//Dao계층에서 처리된 결과를 리턴타입인 raVO(AddressVO)에 담자
			System.out.println(status);
			raVO.setStatus(status); //AddressVO status변수에 1저장
		} catch (SQLException se) { //ORA-XXXX
			System.out.println(se.toString()); //sql 에러문을 보여줌
			System.out.println(sql.toString()); // sql문을 보여줌
		} catch (Exception e){
			System.out.println(e.toString());
		} finally { // 에러가 나던 말던 무조건 닫아줘라
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;
	}

	@Override
	public AddressVO addressUpdate(AddressVO paVO) {
		System.out.println("DAO addressUpdate 호출성공");
		return null;
	}
	//** 삭제 **//
	@Override
	public AddressVO addressDelete(AddressVO paVO) {
		System.out.println("DAO addressDelete 호출성공");
		//DML구문 작성시 절대 String 사용 불가
		//String은 + 연산자로 붙혔을 때마다 객체가 새로 생성되서 메모리 누수
		//문자열을 여러 행 붙일 때는 반드시 StringBuilder - 싱글스레드 안전 - 속도빠름
		//혹은 StringBuffer를 사용할 것 - 멀티스레드 안전 - 속도느림 - why? 동기화 처리
		//이해코드 com.basic.StringTest.java
		StringBuilder sql = new StringBuilder();
		AddressVO raVO = new AddressVO();
		sql.append(" DELETE FROM mkaddrtb WHERE id=? ");
		dbMgr = DBConnectionMgr.getInstance();
		int status = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, paVO.getId());
			status = pstmt.executeUpdate();
			raVO.setStatus(status);
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt);
		}
		return raVO;
	}

	@Override
	public List<AddressVO> getAddress() {
		System.out.println("DAO getAddress 호출성공");
		// 조회한 결과 n건을 담기위한 객체 생성
		// 테이블의 정보는 계속 변하기 때문에 배열은 값이 고정이기 때문에
		// Vector를 사용한다.
		// 조회한 결과를 받아줘야하기 때문에 그냥 인스턴스화 한다.
		List<AddressVO> list = new ArrayList<AddressVO>();
		dbMgr = DBConnectionMgr.getInstance();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, gender, hp ");
	    sql.append("      ,birthday, comments, regdate   ");
	    sql.append("  FROM mkaddrtb                      ");
	    try {
	    	// 물리적으로 떨어진 DB에 통로를 생성
			con = dbMgr.getConnection();
			// sql문을 String으로 바꿔서 전달 해라
			pstmt = con.prepareStatement(sql.toString());
			// pstmt의 sql 쿼리문을 실행시켜줘라
			rs = pstmt.executeQuery();
			// rs.previous() 쓰지 않는 이유는 오라클 커서가 항상 (디폴트) top에 있으니까
			// rs.next()는 커서를 다음으로 이동시켜주라는 뜻
			// VO는 한행만 담을 수 있는 장애를 가지고 있다.
			AddressVO raVO = null;
			while(rs.next()) {
				//리턴값으로 받을 전체 조회 데이터는 raVO에 넣어준다.
				raVO = new AddressVO();
				raVO.setId(rs.getString("id")); 
				raVO.setName(rs.getString("name")); 
				raVO.setGender(rs.getString("gender")); 
				raVO.setBirthday(rs.getString("birthday")); 
				raVO.setHp(rs.getString("hp")); 
				raVO.setRegdate(rs.getString("regdate")); 
				raVO.setComments(rs.getString("comments"));
				raVO.setAddress(rs.getString("address"));
				list.add(raVO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally { // 사용한 자원 반납하기 . con, pstmt, rs
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return list;
	}
//	public static void main(String args[]) {
//		new AddressBookDao().addressInsert(null);
//	}

}