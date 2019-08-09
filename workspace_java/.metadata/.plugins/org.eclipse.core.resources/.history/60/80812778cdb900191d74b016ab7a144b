package com.helpme4;

import java.util.List;
import java.util.Map;

public class LogicFriend {
	DaoFriend fDao = new DaoFriend();
	
	// FRIEND : 친구 추가
	public String addFriend(VOFriend pVO) {
		String result = fDao.addFriend(pVO);
		return result;
	}
	// FRIENDLIST : 친구목록
	public List<Map<String, Object>> friendList(String mem_id) {
		List<Map<String, Object>> rList = null;
		rList = fDao.friendList(mem_id);
		return rList;
	}
	// CHANGEFRINICK : 친구닉네임변경
	public void changeFriNick(VOFriend pVO) {
		fDao.changeFriNick(pVO);
	}
	// DELETEFRIEND : 친구삭제
	public void deleteFriend(VOFriend pVO) {
		fDao.deleteFriend(pVO);
	}
	// SEARCHFRIEND : 친구목록 조건 검색
	public List<Map<String, Object>> searchFriend(VOFriend pVO) {
		List<Map<String, Object>> rList = null;
		rList = fDao.searchFriend(pVO);
		return rList;
	}
	
}
