package com.json;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.address.AddressVO;
import com.google.gson.Gson;
import com.util.DBConnectionMgr;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class JsonCreate {
	//물리적으로 떨어져 있는 서버에 연결통로 확보
	Connection con = null;
	//오라클 서버에 쿼리문을 전달할 객체 생성
	CallableStatement cstmt = null;//프로시저를 호출할 경우 사용
	//오라클 응답을 받아서 커서를 조작
	ResultSet rs = null;
	DBConnectionMgr dbMgr = null;
	//SYS_REFCURSOR를 지원하는 인터페이스 - ojdbc6.jar
	OracleCallableStatement ocstmt = null;
	
	public JsonCreate() {
		dbMgr = DBConnectionMgr.getInstance();//객체주입
		try {
			con = dbMgr.getConnection();
			//DML구문과 다르게 {}를 붙여야한다
			cstmt = con.prepareCall("{call proc_mkaddrtb(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();//execteQuery():ResultSet, executeUpdate():int(I,D,U)
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet cursor = ocstmt.getCursor(1);//OUT ref_addr
			List<AddressVO> memlist = new ArrayList<>();
			AddressVO aVO = null; 
			while(cursor.next()) {//true이면 값이 존재함
				aVO = new AddressVO();
				aVO.setId(cursor.getString("id"));
				aVO.setName(cursor.getString("name"));
				aVO.setAddress(cursor.getString("address"));
				aVO.setHp(cursor.getString("hp"));
				//반복문 안에서 인스턴스화가 진행되므로 오버라이트가 발생함
				//그 주소번지가 가리키는 정보를 보존하기 위해 list를 사용함.
				//오버라이트 되기전에 list에 계속 넣어준다.
				memlist.add(aVO);
			}
			//List -> JSON 형태로 변환
			Gson g = new Gson();
			String jsonMember = g.toJson(memlist);
			System.out.println(jsonMember);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}
	}
	public static void main(String[] args) {
		new JsonCreate();
	}

}
