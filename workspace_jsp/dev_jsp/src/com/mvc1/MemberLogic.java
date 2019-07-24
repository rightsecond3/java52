package com.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vo.MemberVO;
import com.vo.ZipCodeVO;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	MemberDao mDao = new MemberDao();
	ZipCodeDao zDao = new ZipCodeDao();
	
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("memberInsert 호출 성공");
		int result = 0;
		result = mDao.memberInsert(pMap);
		return result;
	}
	//* 조회 메소드
	public List<Map<String, Object>> memberList() {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = mDao.memberList();
		return memList;
	}
	public List<ZipCodeVO> zipcodeList(ZipCodeVO zVO) {
		logger.info("zipcodeList 호출 성공");
		List<ZipCodeVO> zipcodeList = null;
		zipcodeList = zDao.zipcodeList(zVO);
		return zipcodeList;
	}
	public int memberDelete(String mem_id) {
		logger.info("Logic memberDelete 호출 성공");
		int result = 0;
		result = mDao.memberDelete(mem_id);
		return result;
	}
	public int memberUpdate(MemberVO mVO) {
		logger.info("Logic memberUpdate 호출 성공");
		int result = 0;
		result = mDao.memberUpdate(mVO);
		return result;
	}
	// 온라인 시험 서비스 로그인
	public String login(MemberVO mVO) {
		logger.info("Logic login 메소드 호출 성공");
		//화면 전달될 메시지 값
		/*
		 * 1.아이디와 비번 일치 - mem_name님 환영합니다.
		 * 2.아이디가 존재할 떄 - 아이디가 존재합니다.
		 * 2.아이디가 존재하지 않을 때 - 아이디가 존재하지 않습니다.
		 * 3.비번이 틀렸을 때 - 비밀번호가 틀립니다.
		 */
		String mem_name = null;
		mem_name = mDao.isId(mVO);
		if(mem_name.equals("아이디가 존재합니다.")) {
			mem_name = mDao.login(mVO);
		} else {
			mem_name = "아이디가 존재하지 않습니다.";
		}
		return mem_name;
	}

}
