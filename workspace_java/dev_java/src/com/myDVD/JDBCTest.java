package com.myDVD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import oracle.net.aso.e;

public class JDBCTest {

	public static void main(String[] args) {
		StringBuilder sb_sql = new StringBuilder();
		try {
			sb_sql.append("SELECT genre, mov_title, maker  ");
			sb_sql.append("  FROM dvd                      ");
			Class.forName(RSOracleServer._DRIVER);//제조사 정보 수집
			//물리적으로 떨어져 있는 서버와 연결통로
			Connection con = DriverManager.getConnection(RSOracleServer._URL
					,RSOracleServer._USER, RSOracleServer._PW);
			//오라클로 보낼 전령 역활
			PreparedStatement pstmt = con.prepareStatement(sb_sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			DVDVO dvos[] = null;
			DVDVO dvo = null;
			Vector v = new Vector();
			while(rs.next()) {
				dvo = new DVDVO();
				dvo.setDvd_genre(rs.getString("genre"));
				dvo.setDvd_title(rs.getString("mov_title"));
				dvo.setDvd_maker(rs.getString("maker"));
				v.add(dvo);
			}
			//테이블이 몇건이 있는지 while문이 끝나야 알 수 있다.
			dvos = new DVDVO[v.size()];
			//Vector안에 담긴 정보를 DVDVO배열안에 복제하는 메소드 호출
			//copyInto메소드의 소유주는 Vector클래스이고
			//파라미터에는 정보를 담을 배열의 주소번지를 써줌.
			v.copyInto(dvos);
			for(int i=0;i<dvos.length;i++) {
				DVDVO dVO = dvos[i];
				System.out.println(dVO.getDvd_genre()+","+dVO.getDvd_title());
			}
		} catch (Exception e) {
			System.out.println("Exception "+e.toString());
		}
	}

}
