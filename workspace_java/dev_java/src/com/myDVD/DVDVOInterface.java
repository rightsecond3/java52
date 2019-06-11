package com.myDVD;

public interface DVDVOInterface {
	//상세조회 처리를 위한 추상메소드 선언
	public DVDVO getDVDDetail(DVDVO paVO);
	//입력처리를 위한 추상메소드 선언
	public DVDVO getDVDInsert(DVDVO paVO);
	//수정처리를 위한 추상 메소드 선언
	public DVDVO getDVDUpdate(DVDVO paVO);
	//삭제처리를 위한 추상메소드 선언
	public DVDVO getDVDDelte(DVDVO paVO);
}
