package com.mvc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	
	//*** 생성자
	public MemberDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public String currentTime() {
		//DML 호출 뿐 아니라 커밋과 롤백도 처리 가능하다
		/*
		 * SELECT 할 때
		 * sqlSession.selectList("아이디", 파라미터) => List로 반환
		 * sqlSession.selectOne() ==> 여기서 One은 Object
		 * sqlSession.selectMap() ==> Map으로 반환
		 * insert 할 때 => 리턴 타입 : Object
		 * sqlSession.inisert("아이디", 파라미터);
		 * update 할 때 => 리턴 타입 : int
		 * sqlSession.update("아이디", 파라미터);
		 * delete 할 때 => 리턴타입 : int
		 * sqlSession.delete("아이디", 파라미터);
		 * 
		 * 과제
		 * MemberDao를 단위 테스트 할 수 있는 클래스를 선언하고
		 * currentTime 메소드를 호출하여 현재 시간 정보(오라클 서버가 제공하는)를
		 * 출력하는 문장을 작성해보자
		 */
		String time = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			time = sqlSession.selectOne("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	/*
	 * 입력, 수정, 삭제시 주의 사항
	 * 자바에서 JDBC API를 활용할 때는 con.setAutoCommit(true)가 디폴트
	 * 따라서 별도로 끄지 않으면 커밋이 되었으나
	 * myBatis에서는 false가 디폴트 이므로 반드시 커밋 처리 할 것.
	 * 관찰하기
	 * 요청 파라미터의 이름과 메소드 이름 그리고 myBatis의 아이디는 무조건 통일하여 사용할 것
	 */
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//insert는 반환타입이 Object이기 때문에 update 사용
			result = sqlSession.update("memberInsert",pMap);
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//* 조회 처리
	public List<Map<String, Object>> memberList() {
		/*
		 * 웹페이지는 Exception이 발생하면 화면을 확인할 수 가 없다.
		 * 따라서 에러 상황을 파악하는데 화면이 필요할 때는 초기화를 반드시 해줘야함.
		 */
		List<Map<String, Object>> memList = new ArrayList<>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//알아서 member.xml의 resultType으로 나온 값을 List에 add해줌
			memList = sqlSession.selectList("memberList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memList;
	}
	public int memberDelete(String mem_id) {
		logger.info("Dao memberDelete 호출 성공");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.delete("memberDelete", mem_id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int memberUpdate(MemberVO mVO) {
		logger.info("Dao memberUpdate 호출 성공");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//알아서 해당하는 값으로 getter setter 해서 넣고 뺀다.
			result = sqlSession.update("memberUpdate", mVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 온라인 시험 솔루션 아이디 비번 : 로그인
	public String login(MemberVO mVO) {
		logger.info("Dao login");
		String mem_name = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("login", mVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;
	}
	// 온라인 시험 아이디 존재 여부 : 로그인
	public String isId(MemberVO mVO) {
		logger.info("Dao isID");
		String mem_name = null;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			mem_name = sqlSession.selectOne("isId", mVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem_name;
	}
	/*
	 * 저장 프로시저의 특이사항은 파라미터로 넘긴 주소번지의 OUT속성의 값이 담긴다는 사실이
	 */
	public MemberVO proc_login(MemberVO pmVO) {
		logger.info("Dao proc_login");
		//* 프로시저를 사용할 경우 OUT 속성 또한 파라미터로 넘긴 주소번지에 담긴다.
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("proc_login", pmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;
	}
	/*******************************************************
	 * 리턴타입과 파라미터 타입이 서로 같은 객체이다.
	 * 커서 사용시 조인이 있을 때는 VO 타입은 배제함.
	 * 왜냐하면 테이블 2개 이상이므로 파라미터에 두 개를 처리 할 수 없다.
	 * @param pmVO
	 * @return
	 *******************************************************/
	//public Map(String, Object) my_proc(Map<String, Object> pMap) {
	public MemberVO my_proc(MemberVO pmVO) {
		logger.info("Dao my_proc");
		//* 프로시저를 사용할 경우 OUT 속성 또한 파라미터로 넘긴 주소번지에 담긴다.
		try {
			/*
			 * sqlSessionFactory.oppenSession()에서의 NullPointerExeption
			 * 원시적인 방법에서는 문제해결이 비교적 쉽다.
			 * 1) 커넥션 설정 부분
			 * 2) xml문서의 경로
			 * 3) 같은 아이디가 존재할 때
			 * 4) 아이디 대소문자를 구분하지 않았을 때
			 * 5) parameter #1, #2, #3 : 물음표자리에 값이 안들어오는 경우 -> 부적합한 열 유형
			 */
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("my_proc", pmVO);
			logger.info(pmVO);
			logger.info(pmVO.getMem_id());
			logger.info(pmVO.getMem_name());
			logger.info(pmVO.getMem_pw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmVO;
	}
	public Map<String, Object> my_proc2(Map<String, Object> pMap) {
		logger.info("Dao my_proc");
		//* 프로시저를 사용할 경우 OUT 속성 또한 파라미터로 넘긴 주소번지에 담긴다.
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			sqlSession.selectOne("my_proc", pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pMap;
	}
}
