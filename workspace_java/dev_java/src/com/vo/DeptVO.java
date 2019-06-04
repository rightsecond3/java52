package com.vo;

public class DeptVO {
	private int deptno=0;
	private String dname ="";//NullPinterException을 피하기 위한 방법
	private String loc   ="";//null이 스텐다드
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
