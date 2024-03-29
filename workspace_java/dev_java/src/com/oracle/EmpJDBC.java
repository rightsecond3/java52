package com.oracle;
/*
 * 나는 저장 프로시저를 JAVA API를 활용하여 테스트 할 수 있다.
 * 나는 프로시저 호출시 IN속성, OUT속성을 처리하는 코드에 대해 말할 수 있다
 * 나는 프로시저에세 조회된 결과를 오라클 서버 밖으로 꺼낼 수 있다.
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class EmpJDBC {
	//Connection : 인터페이스
	Connection 		   con = null;//연결통로확보
	//CallableStatement : 인터페이스
	CallableStatement cstmt =null;//프로시저를 호출,요청
	OracleCallableStatement ocstmt = null; //커서사용
	//객체배열
	public DeptVO[] getmy_proc3() {
		DeptVO[] dvos = null;
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//예외가 발생할 가능성이 있는 코드
			//직접 인스턴스화 하지 않는 결합도가 낮은 코드
			con = dbMgr.getConnection();
			con.setAutoCommit(false);
			cstmt = con.prepareCall("{call my_proc(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1);
			ArrayList al = new ArrayList();//싱글스레드 안전한 자료구조
			Vector v = new Vector();//멀티스레드 안전한 자료구조
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				//벡터클래스 추가한 이유는 테이블의 로우수를 알 수 없으므로 
				//벡터클래스의 add할때마다 원소의 갯수가 카운트 된다.
				v.add(dvo);
				dvo = null;
			}
			//아래 객체배열을 생성할 때 사용하였다. v.size()
			dvos = new DeptVO[v.size()];
			//파라미터로 비어있는 객체배열을 넣어주면 벡터에 담긴 값들이 복제된다.
			v.copyInto(dvos);
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		} finally {
			try {
				if (cstmt!=null) {
					cstmt.close();
				}
				if (con!=null) {
					con.close();
				}
				if (ocstmt!=null) {
					ocstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dvos;
	}
	//ArrayList
	public ArrayList<DeptVO> getmy_proc2() {
		ArrayList<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//예외가 발생할 가능성이 있는 코드
			con = dbMgr.getConnection();
			con.setAutoCommit(false);
			cstmt = con.prepareCall("{call my_proc(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1); //ResultSet 커서조작
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				deptList.add(dvo);
				System.out.println(dvo.getDeptno()+" "+dvo.getDname()+" "+dvo.getLoc());
				dvo = null;
			}
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		} finally {
			try {
				if (cstmt!=null) {
					cstmt.close();
				}
				if (con!=null) {
					con.close();
				}
				if (ocstmt!=null) {
					ocstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return deptList;
	}
	public DeptVO getmy_proc() {
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//예외가 발생할 가능성이 있는 코드
			con = dbMgr.getConnection();
			con.setAutoCommit(false);
			cstmt = con.prepareCall("{call my_proc(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1); //ResultSet 커서조작
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				System.out.println(dvo.getDeptno()+" "+dvo.getDname()+" "+dvo.getLoc());
				dvo = null;
			}
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		} finally {
			try {
				if (cstmt!=null) {
					cstmt.close();
				}
				if (con!=null) {
					con.close();
				}
				if (ocstmt!=null) {
					ocstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dvo;
	}
	public void getProc_deptnoUpdate() {
		String msg = null;//프로시저의 out속성값 받아서 저장할 변수
		//DBConnectionMgr dbMgr = new DBConnectionMgr과 밑 행의 차이를 확실히 아는가?
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			//자바에세는 오토커밋이 디폴트
			con.setAutoCommit(false);
			cstmt = con.prepareCall("{call proc_deptnoUpdate(?,?)}");
			System.out.println("부서번호를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			int u_deptno = scan.nextInt();//사용자가 입력한 부서번호 받아오기
			cstmt.setInt(1, u_deptno);//1번째 물음표(IN속성 넣어주기)
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);//2번째 물음표(OUT속성 타입정해주기)
			//오라클서버에게 처리요청
			int result = cstmt.executeUpdate(); //성공=1, 실패=0
			msg = cstmt.getString(2);//2번째 msg 꺼내오기
			System.out.println(msg);
		} catch (Exception e) {
			//절대로 print안에 넣지 말것.
			//stack메모리 영역에 쌓여있는 에러메세지를 모두 출력해줌.
			e.printStackTrace();
		} finally { //에러가 발생하더라도 무조건 실행하는 코드
			//사원한 자원 반납할것. - 명시적으로
			//생성된 역순으로 반납처리 할것.
			try {
				if (cstmt!=null) {
					cstmt.close();
				}
				if (con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public String getProc_empnoUpdate() {
		String msg = null;
		//DBConnectionMgr dbMgr = new DBConnectionMgr과 밑 행의 차이를 확실히 아는가?
		//싱글톤 패턴으로 가져오기
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//Connection 인터페이스 con에 DBmgr의 getConnection 메소드의 con값을 넣어라
			con = dbMgr.getConnection();
			//오토커밋을 하지마라
			con.setAutoCommit(false);
			cstmt = con.prepareCall("{call proc_empnoUpdate(?,?)}");
			System.out.println("사원번호를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			int u_empno = scan.nextInt();//사용자가 입력한 사원번호 받아오기
			cstmt.setInt(1, u_empno);//1번째 물음표(IN속성 넣어주기)
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);//2번째 물음표(OUT속성 타입정해주기)
			//오라클서버에게 처리요청
			int result = cstmt.executeUpdate(); //성공=1, 실패=0
//			con.commit();//자바에서 오라클의 커밋을 대신 처리해주는 코드
			msg = cstmt.getString(2);//2번째 msg 꺼내오기
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());//e.getMessage() 오라클의 에러메세지를 그대로 보여줌
		}
		return msg;
	}
	public static void main(String[] args) {
		EmpJDBC ejdbc = new EmpJDBC();
//		ejdbc.getProc_empnoUpdate();
//		System.out.println(ejdbc.getProc_deptnoUpdate());
//		ejdbc.getProc_deptnoUpdate();
//		DeptVO dvo = ejdbc.getmy_proc();
		
		/* ArrayList 실행문
		ArrayList<DeptVO> deptList = ejdbc.getmy_proc2();
		
		for(DeptVO dept : deptList) {
			System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
		}
		for(int j=0; j<deptList.size(); j++) {
			DeptVO dvo = deptList.get(j);
			System.out.println(dvo.getDeptno()+" "+dvo.getDname()+" "+dvo.getLoc());
		}
		*/
		// 객체배열사용
		DeptVO[] dvos = ejdbc.getmy_proc3();
		for(DeptVO dept : dvos) {
			System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
		}
		System.out.println("=============================");
		for(int x=0;x<dvos.length;x++) {
			DeptVO dvo = dvos[x];
			System.out.println(dvo.getDeptno()+" "+dvo.getDname()+" "+dvo.getLoc());
		}
		
		
	}

}
