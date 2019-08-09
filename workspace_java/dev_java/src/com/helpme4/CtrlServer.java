package com.helpme4;

import java.util.List;
import java.util.Map;

public class CtrlServer {
	//* 선언부
	LogicServer sLogic = new LogicServer();
	LogicMember memLogic = new LogicMember();
	LogicFriend friLogic = new LogicFriend();
	LogicRoom roomLogic = new LogicRoom();
	LogicMessage msgLogic = new LogicMessage();
	LogicSetting setLogic = new LogicSetting();
	
	public VOMem login(VOMem pVO) {
		VOMem rVO = null;
		rVO = memLogic.login(pVO);
		return rVO;
	}
	public List<VOChatList> roomCreate(VOChatList pVO) {
		List<VOChatList> rList = null;
		rList = roomLogic.getRoomCreate(pVO);
		return rList;
	}
	//서버열때 해당 server.chatlist 아마도 안씀
	public List<VOChatList> send(String command) {
		List<VOChatList> rList = null;
		//rList = sLogic.getcList();
		return rList;
	}
	//* 메시지를 보낼때 룸캐스팅으로 보내주는 거
	public List<Map<String, Object>> send(Map<String, Object> pMap) {
		List<Map<String, Object>> rList = null;
		rList = msgLogic.insMsgLogic(pMap); 
		return rList;
	}
	//* 아이디 중복 검사
	public String overLap(String mem_id) {
		String temp = memLogic.overLap(mem_id);
		return temp;
	}
	//* JOIN : 회원가임
	public String join(Map<String, Object> pMap) {
		String mem_id = null;
		mem_id = memLogic.join(pMap);
		return mem_id;
	}
	// FREINDLIST, GroupList : 단톡방 생성 시 친구 추가할 목록 부르기
	public List<Map<String, Object>> friendList(String mem_id) {
		List<Map<String, Object>> rList = null;
		rList = friLogic.friendList(mem_id);
		return rList;
	}
	// 친구추가
	public String addFriend(VOFriend pVO) {
		String result = friLogic.addFriend(pVO);
		return result;
	}
	// 친구 닉네임 변경
	public void changeFriNick(VOFriend pVO) {
		friLogic.changeFriNick(pVO);
	}
	public void deleteFriend(VOFriend pVO) {
		friLogic.deleteFriend(pVO);
	}
	// SEARCHFRIEND : 친구목록 조건검색 
	public List<Map<String, Object>> searchFriend(VOFriend pVO) {
		List<Map<String, Object>> rList = null;
		rList = friLogic.searchFriend(pVO);
		return rList;
	}
	// ADDGROUP : 단톡방 생성
	public VOChatList createGroup(VOChatList pVO) {
		pVO = roomLogic.createGroup(pVO);
		return pVO;
	}
	// ****************** 박상범 수정 ****************** //
	public List<VOChatList> getList() {
		List<VOChatList> nList = null;
		nList = sLogic.getList();
		return nList;
	}
	// ****************** 박상범 수정 끝 ****************** //
	// CHATLIST : 모든 방 리스트 가져오기
	public List<Map<String, Object>> chatList(String mem_id) {
		List<Map<String, Object>> chatList = null;
		chatList = roomLogic.chatList(mem_id);
		return chatList;
	}
	// CHATLOG
	public List<Map<String, Object>> chatLog(String mem_id, String clist_code) {
		List<Map<String, Object>> logList = null;
		logList = roomLogic.chatLog(mem_id, clist_code);
		return logList;
	}
	// ROOM_IN
	public List<Map<String, Object>> roomIn(String mem_id, String clist_code) {
		List<Map<String, Object>> rList = null;
		rList = roomLogic.roomIn(mem_id, clist_code);
		return rList;
	}
	// ** 단톡방에서 대화방 친구 목록 ROOM_INLIST
	public List<Map<String, Object>> roomInList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = null;
		rList = roomLogic.roomInList(clist_code, login_id);
		return rList;
	}
	// ROOM_ADDLIST : 톡방에 초대할 때 톡방에 있는 사람들 제외한 목록 가져오기
	public List<Map<String, Object>> roomAddList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = null;
		rList = roomLogic.roomAddList(clist_code, login_id);
		return rList;
	}
	// ROOMADD
	public Map<String, Object> roomAddPerson(String clist_code, String addPerson, String login_id) {
		Map<String, Object> rMap = null;
		rMap = roomLogic.roomAddPerson(clist_code, addPerson, login_id);
		return rMap;
	}
	// ROOMADD
	public List<Map<String, Object>> selyourid(String r_clistcode, String login_id) {
		List<Map<String, Object>> rList = null;
		rList = roomLogic.selyourid(r_clistcode, login_id);
		return rList;
	}
	// ROOM_OUT : 톡방 나가기
	public void exitRoom(String clist_code, String login_id) {
		roomLogic.exitRoom(clist_code, login_id);
	}
	// SETTING : 세팅창 눌렀을때
	public VOMem setting(String login_id) {
		VOMem rmVO = null;
		rmVO = setLogic.setting(login_id);
		return rmVO;
	}
	public void setNick(String login_id, String changeNick) {
		setLogic.setNick(login_id, changeNick);
	}
	public void setStatus(String login_id, String changeStatus) {
		setLogic.setStatus(login_id, changeStatus);
	}
	public void setImg(String login_id, String changeImg) {
		setLogic.setImg(login_id, changeImg);
	}
	// 채팅방 그룹 검색
	public List<Map<String, Object>> roomSearch(VOChatList pVO) {
		List<Map<String, Object>> rList = null;
		rList = roomLogic.roomSearch(pVO);
		return rList;
	}
	// 채팅방 이름 변경
	public void roomChangeName(VOChatNick pVO) {
		roomLogic.roomChangeName(pVO);
	}
}
