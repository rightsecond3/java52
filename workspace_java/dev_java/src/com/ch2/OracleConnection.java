package com.ch2;
/*
 * 모든 클래스안에는 메인메소드가 있어야 하나?
 */
public class OracleConnection {
	final String _IP = "192.168.0.4";
	final int PORT = 1521; //상수
	String user = "scott";
	String pw = "tiger";
	void test() {
		user = "haha"; //전변의 값을 변경하는 코드
		//_IP = "192.168.0.6"; -> 상수여서 에러
	}

}
