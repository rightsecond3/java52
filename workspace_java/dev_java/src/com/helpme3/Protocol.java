package com.helpme3;
/*
 * 프로토콜
 */
public class Protocol {
	public static final int JOIN = 10; //회원가입
	public static final int OVERLAP = 20; //중복검사
	public static final int ADDFRIEND = 30; //친구추가
	public static final int FRIENDLIST = 40; //친구목록
	public static final int CHANGEFRINICK = 50; //친구닉네임변경
	public static final int DELETEFRIEND = 60; //친구삭제
	public static final int SEARCHFRIEND = 70; //조건검색
	public static final int GROUPLIST = 80; //단톡방 생성
	public static final int ADDGROUP = 90; //단톡방 생성
	public static final int LOGIN = 100; //로그인
	public static final int ROOM_CREATE = 110; //톡방개설
	public static final int ROOM_LIST = 120; //톡방이름목록
	public static final int ROOM_IN = 130; //톡방 입장
	public static final int ROOM_INLIST = 140; //톡방에 있는 사람 목록
	public static final int ROOM_ADDLIST = 150; //톡방에 있는 사람 목록
	public static final int ROOM_ADD = 160; //톡방에 있는 사람 목록
	public static final int ROOM_OUT = 190; //톡방 나가기
	public static final int MESSAGE = 200; //일반대화
	public static final int WHISPER = 210; //1:1
    public static final int CHATLOG = 230; //챗창 로그 불러오기
    public static final int CHANGE = 300; //대화명변경
    public static final int CHATLIST = 310; //모든 방 가져오는거
	public static final int EXIT = 500; //종료
	public static String seperator="|"; //구분자
}
