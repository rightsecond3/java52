package com.helpme3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CtrlServer {
	private static final String _MESSAGE = "message";
	private static final String _JOIN    = "join";
	
	LogicServer sLogic = new LogicServer();
	
	public VOMem send(VOMem pVO) {
		VOMem rVO = null;
		rVO = sLogic.login(pVO);
		return rVO;
	}
	public List<VOChatList> send(VOChatList pVO) {
		List<VOChatList> rList = null;
		rList = sLogic.getRoomCreate(pVO);
		return rList;
	}
	//서버열때 해당 server.chatlist
	public List<VOChatList> send(String command) {
		List<VOChatList> rList = null;
		rList = sLogic.getcList();
		return rList;
	}
	//* 메시지를 보낼때 룸캐스팅으로 보내주는 거
	public List<Map<String, Object>> send(Map<String, Object> pMap) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.insMsgLogic(pMap); 
		return rList;
	}
	//* 아이디 중복 검사
	public String overLap(String mem_id) {
		String temp = sLogic.overLap(mem_id);
		return temp;
	}
	//* 회원가입
	public String join(Map<String, Object> pMap) {
		String mem_id = null;
		mem_id = sLogic.join(pMap);
		return mem_id;
	}
	//* FriendList
	public List<Map<String, Object>> friendList(String mem_id) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.friendList(mem_id);
		return rList;
	}
	// 친구추가
	public String addFriend(VOFriend pVO) {
		String result = sLogic.addFriend(pVO);
		return result;
	}
	// 친구 닉네임 변경
	public void changeFriNick(VOFriend pVO) {
		sLogic.changeFriNick(pVO);
	}
	public void deleteFriend(VOFriend pVO) {
		sLogic.deleteFriend(pVO);
	}
	// 친구목록 조건검색 
	public List<Map<String, Object>> searchFriend(VOFriend pVO) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.searchFriend(pVO);
		return rList;
	}
	//
	public VOChatList createGroup(VOChatList pVO) {
		pVO = sLogic.createGroup(pVO);
		return pVO;
	}
	// ****************** 박상범 수정 ****************** //
	public List<VOChatList> getList() {
		List<VOChatList> nList = null;
		nList = sLogic.getList();
		return nList;
	}
	// ****************** 박상범 수정 끝 ****************** //
	public List<Map<String, Object>> chatList(String mem_id) {
		List<Map<String, Object>> chatList = null;
		chatList = sLogic.chatList(mem_id);
		return chatList;
	}
	public List<Map<String, Object>> chatLog(String mem_id, String clist_code) {
		List<Map<String, Object>> logList = null;
		logList = sLogic.chatLog(mem_id, clist_code);
		return logList;
	}
	public List<Map<String, Object>> roomIn(String mem_id, String clist_code) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.roomIn(mem_id, clist_code);
		return rList;
	}
	// ** 단톡방에서 대화방 친구 목록
	public List<Map<String, Object>> roomInList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.roomInList(clist_code, login_id);
		return rList;
	}
	public List<Map<String, Object>> roomAddList(String clist_code, String login_id) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.roomAddList(clist_code, login_id);
		return rList;
	}
	// ROOMADD
	public Map<String, Object> roomAddPerson(String clist_code, String addPerson, String login_id) {
		Map<String, Object> rMap = null;
		rMap = sLogic.roomAddPerson(clist_code, addPerson, login_id);
		return rMap;
	}
	public List<Map<String, Object>> selyourid(String r_clistcode, String login_id) {
		List<Map<String, Object>> rList = null;
		rList = sLogic.selyourid(r_clistcode, login_id);
		return rList;
	}
	public void exitRoom(String clist_code, String login_id) {
		sLogic.exitRoom(clist_code, login_id);
	}
}
