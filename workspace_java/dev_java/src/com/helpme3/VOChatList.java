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
	private String clist_code    = null;
	private String clist_yourid  = null;
	private String mem_id        = null;
	private String clist_count   = null;
	private String clist_img     = null;
	private String clist_name    = null;
	private String clist_gubun   = null;
	private String command       = null; //컨트롤계층에서 분기할 커맨드
	private String result        = null; // 새창 아니면 clist_code
	
	
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
