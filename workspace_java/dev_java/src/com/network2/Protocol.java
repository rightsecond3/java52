package com.network2;

public class Protocol {
	public static final int WAIT = 100;//대기상태
	public static final int ROOM_CREATE = 110;//톡방개설
	/*
	 * 기존에 사용중인 사람들의 정보는 공유되고 있지만
	 * 그 후의 사용자들은 목록정보를 받을 수 없다.
	 */
	public static final int ROOM_LIST = 120;//톡방이름목록
	/*
	 * ROOM_IN과 ROOM_INLIST 동일한 효과를 누린다.
	 * 후에 들어온 사용자들의 목록을 추가 하기 위해 ROOM_INLIST를 설계
	 */
	public static final int ROOM_IN = 130;//톡방 입장
	public static final int ROOM_INLIST = 140;//톡방에 있는 사람 목록
	public static final int ROOM_OUT = 190;//톡방 나가기
	public static final int MESSAGE = 200;//일반대화
	public static final int WHISPER = 210;//1:1
	public static final int CHANGE = 300;//대화명변경
	public static final int EXIT = 500;//종료
	//메세지 열에서 값에 대한 구분자를 선언
	public static String seperator="|";
}
