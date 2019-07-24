package com.helpme3;

public class VOGroupLog {
	private int    glog_rno      = 0;    // 그룹로그순번_PK : 복합키
	private String gcode_code    = null; // 그룹코드_FK[GroupCode]_PK :복합키
	private String glog_time     = null; // 작성시간
	private String glog_date     = null; // 작성날짜
	private String glog_contents = null; // 작성내용
	private String glog_writer   = null; // 작성자
	
	public int getGlog_rno() {
		return glog_rno;
	}
	public void setGlog_rno(int glog_rno) {
		this.glog_rno = glog_rno;
	}
	public String getGcode_code() {
		return gcode_code;
	}
	public void setGcode_code(String gcode_code) {
		this.gcode_code = gcode_code;
	}
	public String getGlog_time() {
		return glog_time;
	}
	public void setGlog_time(String glog_time) {
		this.glog_time = glog_time;
	}
	public String getGlog_date() {
		return glog_date;
	}
	public void setGlog_date(String glog_date) {
		this.glog_date = glog_date;
	}
	public String getGlog_contents() {
		return glog_contents;
	}
	public void setGlog_contents(String glog_contents) {
		this.glog_contents = glog_contents;
	}
	public String getGlog_writer() {
		return glog_writer;
	}
	public void setGlog_writer(String glog_writer) {
		this.glog_writer = glog_writer;
	}
	
}
