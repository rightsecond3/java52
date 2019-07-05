package com.project;

public class RentVO {
	private String r_num       = null;// 렌탈번호
	private String r_date      = null;// 렌탈한날짜
	private String returndate  = null;// 반납일
	private int    latefee     = 0;   // 연체료
	private String duedate     = null;// 반납예정일
	private String memid       = null; // -> MEM테이블의 memid를 외래키로 받아옴.
	
	/////***** 업무에 대한 구분을 위한 변수 선언 *****//////
	private String command     = null;// select|insert|update|delete
	/////***** 오라클서버에서 반환되는 값을 담을 변수 *****//////
	private int    status      = -1;
	/////***** 사용자가 입력한 키워드 값을 담을 변수 *****/////
	private String keyword     = null;
	/////***** 사용자가 선택한 콤보박스 값을 담을 변수 *****/////
	private String combobox     = null;
	
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getLatefee() {
		return latefee;
	}
	public void setLatefee(int latefee) {
		this.latefee = latefee;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCombobox() {
		return combobox;
	}
	public void setCombobox(String combobox) {
		this.combobox = combobox;
	}
}