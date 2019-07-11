package com.helpme3;

public class VOChatLog {
	private int    clog_rno       = 0;    //순번_PK
	private String clog_date      = null; //작성날짜
	private String clog_time      = null; //작성시간
	private String clog_contents  = null; //작성내용
	private String clog_writer    = null; //작성자
	private String clist_code      = null; //채팅방코드_FK(MyTalk)
	
	public int getClog_rno() {
		return clog_rno;
	}
	public void setClog_rno(int clog_rno) {
		this.clog_rno = clog_rno;
	}
	public String getClog_date() {
		return clog_date;
	}
	public void setClog_date(String clog_date) {
		this.clog_date = clog_date;
	}
	public String getClog_time() {
		return clog_time;
	}
	public void setClog_time(String clog_time) {
		this.clog_time = clog_time;
	}
	public String getClog_contents() {
		return clog_contents;
	}
	public void setClog_contents(String clog_contents) {
		this.clog_contents = clog_contents;
	}
	public String getClog_writer() {
		return clog_writer;
	}
	public void setClog_writer(String clog_writer) {
		this.clog_writer = clog_writer;
	}
	public String getClist_code() {
		return clist_code;
	}
	public void setClist_code(String clist_code) {
		this.clist_code = clist_code;
	}
	

}
