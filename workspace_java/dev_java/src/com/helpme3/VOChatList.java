package com.helpme3;

import java.util.List;
import java.util.Vector;
/*
 * network의 Room 클래스를 대체함
 */
public class VOChatList {
	//해당 채팅방에 들어있는 사람들의 스레드
	List<ServerThread> userList = new Vector<>();
	//그 사람들의 pk 이름 값들
	List<String> nameList = new Vector<String>();
	private String clist_code    = null; //채팅리스트 코드
	private String clist_yourid  = null; //상대방 코드들
	private String clist_count   = null; //채팅방 인원수
	private String clist_name    = null; //채팅방 이름
	private String clist_gubun   = null;  //채팅방 갠톡 단톡 구분
	private String clist_bcolor  = null; //채팅방 배경색
	private String clist_img     = null; //채팅방 프로필 사진
	private String mem_id        = null; //회원 아이디(방 만든사람)_FK:[MEM]
	private String command       = null; //컨트롤계층에서 분기할 커맨드
	
	
	public String getClist_code() {
		return clist_code;
	}
	public void setClist_code(String clist_code) {
		this.clist_code = clist_code;
	}
	public String getClist_yourid() {
		return clist_yourid;
	}
	public void setClist_yourid(String clist_yourid) {
		this.clist_yourid = clist_yourid;
	}
	public String getClist_count() {
		return clist_count;
	}
	public void setClist_count(String clist_count) {
		this.clist_count = clist_count;
	}
	public String getClist_name() {
		return clist_name;
	}
	public void setClist_name(String clist_name) {
		this.clist_name = clist_name;
	}
	public String getClist_gubun() {
		return clist_gubun;
	}
	public void setClist_gubun(String clist_gubun) {
		this.clist_gubun = clist_gubun;
	}
	public String getClist_bcolor() {
		return clist_bcolor;
	}
	public void setClist_bcolor(String clist_bcolor) {
		this.clist_bcolor = clist_bcolor;
	}
	public String getClist_img() {
		return clist_img;
	}
	public void setClist_img(String clist_img) {
		this.clist_img = clist_img;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	
}
