package com.mvc2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
import com.vo.BoardMasterVO;
import com.vo.BoardSubVO;

public class BoardDao {
	//* 선언부
	Logger logger = Logger.getLogger(BoardDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	
	//* 생성자
	public BoardDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		List<Map<String, Object>> boardList = new ArrayList<Map<String,Object>>();
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList", bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	public int boardSAdd(BoardSubVO bsVO) {
		logger.info("boardSAdd 호출성공");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardSAdd", bsVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int boardMAdd(BoardMasterVO bmVO) {
		logger.info("boardMAdd 호출성공");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("boardMAdd", bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int boardSUpd(BoardSubVO bsVO) {
		logger.info("boardSUpd 호출성공");
		return 0;
	}

	public int boardMUpd(BoardMasterVO bmVO) {
		logger.info("boardMUpd 호출성공");
		return 0;
	}

	public int boardSDel(BoardSubVO bsVO) {
		logger.info("boardSDel 호출성공");
		return 0;
	}

	public int boardMDel(BoardMasterVO bmVO) {
		logger.info("boardMDel 호출성공");
		return 0;
	}
	// 전체 레코드 수를 가져오는 메소드
	public int getTotal(BoardMasterVO bmVO) {
		logger.info("getTotal 호출성공");
		int total = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			total = sqlSession.selectOne("getTotal", bmVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	// 
	public int getBmno() {
		logger.info("getBmno 호출성공");
		int bm_no = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			bm_no = sqlSession.selectOne("getBmno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_no;
	}

	public int getBmgroup() {
		logger.info("getBmgroup 호출성공");
		int bm_group = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			bm_group = sqlSession.selectOne("getBmgroup");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bm_group;
	}

	public int bmStepUpdate(BoardMasterVO bmVO) {
		logger.info("getStepUpdate 호출성공");
		int result = 0;
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("bmStepUpdate", bmVO);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



}
