package com.myDVD;

public class DVDVO {
	  private String serialnum     = null;//dvd번호  
	  private String genre         = null;//장르
	  private String mov_class     = null;//등급
	  private String mov_title     = null;//dvd제목
	  private String maker         = null;//배급사
	  private String nation        = null;//나라
	  private String leadingactor  = null;//주연배우
	  private String director      = null;//
	  private String mov_date      = null;//개봉날짜
	  private String v_date        = null;//dvd출시일
	  private String damage        = null;//파손여부
	  private String r_check       = null;//대여여부
	  private int    r_fee         = 0;   //대여료
	  //테이블에는 없지만 업무에 대한 구분을 위한 변수 선언
	  private String    command       = null;//->select,detail,insert,updatem,delete
	  //오라클서버에서 반환되는 값을 담을 변수 - 1:성공(입력,수정,삭제), 0:실패
	  private int    status        = -1;
	public String getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMov_class() {
		return mov_class;
	}
	public void setMov_class(String mov_class) {
		this.mov_class = mov_class;
	}
	public String getMov_title() {
		return mov_title;
	}
	public void setMov_title(String mov_title) {
		this.mov_title = mov_title;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getLeadingactor() {
		return leadingactor;
	}
	public void setLeadingactor(String leadingactor) {
		this.leadingactor = leadingactor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMov_date() {
		return mov_date;
	}
	public void setMov_date(String mov_date) {
		this.mov_date = mov_date;
	}
	public String getV_date() {
		return v_date;
	}
	public void setV_date(String v_date) {
		this.v_date = v_date;
	}
	public String getDamage() {
		return damage;
	}
	public void setDamage(String damage) {
		this.damage = damage;
	}
	public String getR_check() {
		return r_check;
	}
	public void setR_check(String r_check) {
		this.r_check = r_check;
	}
	public int getR_fee() {
		return r_fee;
	}
	public void setR_fee(int r_fee) {
		this.r_fee = r_fee;
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
}           
