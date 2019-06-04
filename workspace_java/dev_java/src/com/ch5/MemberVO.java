package com.ch5;
/*
 * DVD대여관리시스템에서 필요한 회원테이블을 관리할 클래스 정의
 * 테이블 컬럼을 전역변수로 사용한다.
 * 단 접근제한자를 private으로 하여 외부에서 임의로 변조 못하도록 방지
 */
public class MemberVO { //VO(Value Object) : 값을 가지고있는 객체
	private String MEM_ID       =null;  //회원아이디, 전역변수
	private String MEM_PW       =null;  //회원비번
	private String MEM_NAME     =null;  //회원명
	private String MEM_ADDR     =null;  //회원주소
	private String MEM_ZIPCODE  =null;  //회원우편번호
	public MemberVO() {
	}
	//디폴트 생성자를 생성해주어야 파라미터 생성자 또한 생성할 수 있다.
	public MemberVO(int a) {
	}
	public MemberVO(String mem_id, String mem_pw
		,String mem_name, String mem_addr, String mem_zipcode) {
		this.MEM_ID = mem_id;
		this.MEM_PW = mem_pw;
		this.MEM_NAME = mem_name;
		this.MEM_ADDR = mem_addr;
		this.MEM_ZIPCODE = mem_zipcode;
	}
	//private 클래스를 다른 클래스에서도 쓸 수 있도록 바꿔주는 코드
	//getter - 읽기, 리턴타입 있다.
	public String getMEM_ID() {
		return MEM_ID;
	}
	//setter - 저장/쓰기, 파라미터가 있다. 리턴타입 없다.
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public String getMEM_PW() {
		return MEM_PW;
	}
	public void setMEM_PW(String mEM_PW) {
		MEM_PW = mEM_PW;
	}
	public String getMEM_NAME() {
		return MEM_NAME;
	}
	public void setMEM_NAME(String mEM_NAME) {
		MEM_NAME = mEM_NAME;
	}
	public String getMEM_ADDR() {
		return MEM_ADDR;
	}
	public void setMEM_ADDR(String mEM_ADDR) {
		MEM_ADDR = mEM_ADDR;
	}
	public String getMEM_ZIPCODE() {
		return MEM_ZIPCODE;
	}
	public void setMEM_ZIPCODE(String mEM_ZIPCODE) {
		MEM_ZIPCODE = mEM_ZIPCODE;
	}
}
