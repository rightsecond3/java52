package com.project;

public class RentDetailVO {
	private String r_detailnum = null;// 랜탈디테일번호
	private String serialnum   = null; // -> DVD테이블의 왜래키
	private String r_num       = null; // -> RENTAL테이블의 왜래키
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
}
