package com.project;

public class MemVO {
	private String memid         = null;// 회원아이디
	private String memname       = null;// 회원이름
	private String tel           = null;// 회원집번호
	private String phonenum      = null;// 회원핸드폰번호
	private String zipcode       = null;// 회원도시명코드
	private String address       = null;// 회원주소
	private String resistdate    = null;// 회원등록일
	private String mempw         = null;// 회원비밀번호
	/////***** 업무에 대한 구분을 위한 변수 선언 *****//////
	private String command     = null;// select|insert|update|delete
	/////***** 오라클서버에서 반환되는 값을 담을 변수 *****//////
	private int    status      = -1;
	/////***** 사용자가 입력한 키워드 값을 담을 변수 *****/////
	private String keyword     = null;
	/////***** 사용자가 선택한 콤보박스 값을 담을 변수 *****/////
	private String combobox     = null;

	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getResistdate() {
		return resistdate;
	}
	public void setResistdate(String resistdate) {
		this.resistdate = resistdate;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
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
