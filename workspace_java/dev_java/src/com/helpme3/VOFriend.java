package com.helpme3;

public class VOFriend {
	private String fri_fid    = null; //상대방 아이디_PK
	private String fri_fnick  = null; //상대방 닉네임
	private String mem_id     = null; //내 아이디_Mem테이블 FK_PK_[복합키]
	
	public String getFri_fid() {
		return fri_fid;
	}
	public void setFri_fid(String fri_fid) {
		this.fri_fid = fri_fid;
	}
	public String getFri_fnick() {
		return fri_fnick;
	}
	public void setFri_fnick(String fri_fnick) {
		this.fri_fnick = fri_fnick;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
}
