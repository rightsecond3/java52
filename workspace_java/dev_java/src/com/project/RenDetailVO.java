package com.project;

public class RenDetailVO {
	private String r_detailnum = null;// 랜탈디테일번호
	private String serialnum   = null; //-> DVD테이블의 왜래키
	private String r_num       = null; //-> RENTAL테이블의 왜래키
	private String u_rnum = null; // RENTAL테이블에서 선택한 렌탈번호를 기억하는 변수
	////UPDATE시 WHERE절에 넣을 RENDETAIL NUMBER 선언 ////
	private String u_detailnum     = null;
	/////***** 업무에 대한 구분을 위한 변수 선언 *****//////
	private String command     = null;// select|insert|update|delete
	/////***** 오라클서버에서 반환되는 값을 담을 변수 *****//////
	private int    status      = -1;
	/////***** 사용자가 입력한 키워드 값을 담을 변수 *****/////
	private String keyword     = null;
	/////***** 사용자가 선택한 콤보박스 값을 담을 변수 *****/////
	private String combobox     = null;
	
	public String getR_detailnum() {
		return r_detailnum;
	}
	public void setR_detailnum(String r_detailnum) {
		this.r_detailnum = r_detailnum;
	}
	public String getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	public String getR_num() {
		return r_num;
	}
	public void setR_num(String r_num) {
		this.r_num = r_num;
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
	public String getU_rnum() {
		return u_rnum;
	}
	public void setU_rnum(String u_rnum) {
		this.u_rnum = u_rnum;
	}
	public String getU_detailnum() {
		return u_detailnum;
	}
	public void setU_detailnum(String u_detailnum) {
		this.u_detailnum = u_detailnum;
	}
}
