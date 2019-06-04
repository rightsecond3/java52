package com.ch2;
//이 코드는 메인 메소드의 파라미터인 String[] args에 대해 알아보기 위함이다.
//메인메소드는 클래스 안에 있는 모든 코드들 중에서 가장 우선순위가 높다.
//메소드를 부른적이 없지만 항상 호출이 된다.
//메인메소드는 개발자가 호출하는 메소드가 아닙니다 . - 누가-> 가상머신이 호출(JVM- jdk1.8)
//print메소드는 개발자가 호출하는 메소드가 맞다.
//메소드를 선언하는 것과 호출하는 것의 코드의 차이점
//선언{}, 호출();
//메인메소드를 호출 하는건 가상머신이 자동으로 함 - 콜백메소드라함.[PC가 알아서 호출]
/*
 * 이클립스가 없다면 컴파일을 요철하는 명령어를 직접 작성해야 함
 * javac MainTest.java -> MainTest.class(기계어)
 * 실행
 * java MainTest 이순신 유승기
 */
public class MainTest {

	public static void main(String[] args) {
		//파라미터에 있는 변수의 이름은 args이고
		//타입은 배열임._String[]
		//배열의 시작이 0인 이유 args와 args[0]의 주소번지가 같기때문
		//배열 한칸 : 4byte
		//args->229540, args[0]->229544, args[1]->229548
		String name =args[0];
		name = args[1];
		System.out.println(args[0]);
		System.out.println(args[1]);
	}

}
