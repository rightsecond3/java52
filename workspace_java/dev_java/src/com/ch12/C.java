package com.ch12;
/*
 * ArrayList는 프로시저와 연계처리
 * 메신저 프로그램에서 대화목록을 관리하거나 톡방목록을 관리할 때
 * 빵가게에서 빵 정보를 담을 때
 * 도서관에서 도서 정보를 담을 때
 * 생각해보기
 * 1)전역변수에서 선언하고 생성할 때와 생성자 안에서 생성할 때 차이점
 * 지금상황 - 차이가 없다.
 * 2)ArrayList 선언하고 생성했을 때 메모리는 할당이 되지만 아무런 정보도 갖고 있지 않다.
 * 3)주소번지.주소번지 패턴에 대해서 이해하고 있나? - 제네릭 활용 가능
 * :두번 주소번지에 접근해야 값을 확인할 수 있다.
 * ArrayList<ChatVO>
 * a)ArrayList-> b)ChatVO-> c)전역변수(nickName, age)
 * a,b - 주소번지, c - 실제 필요한 값 저장
 */
public class C {
	public static void main(String[] args) {
		new A();
	}
	//printStackTrace()
}
