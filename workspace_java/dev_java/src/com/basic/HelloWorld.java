package com.basic;
//Ctrl+S : 저장된후 즉시 컴파일(이클립스)
//한글에서 코딩을 해도 된다 안된다->안된다
public class HelloWorld {
	// 나는 클래스 입니다.
	// 클래스 이름은 HelloWorld입니다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub 여기는 메인 메소드 입니다. 이름 뒤에 ()가 있다. 동사형
		// 명사형을 쓸 수 있다.
		// 변수 선언하기
		// 대입연산자가 있다. =
		// 같다 1==1 참(true)
		// 자바에서는 여러가지 타입을 제공함.
		// 오라클에 저장된 정보가 여러가지임
		// SELECT ename, sal FROM emp
		// 변수를 선언했고 대입연산자를 사용해서 그 변수에 800(값)을 저장했어요
		// 정수를 담을때는 타입은 반드시 int를 사용한다
		int sal = 800;
		//sal = 300;
		// 변수 sal안에 담겨있는 800 숫자 출력해보기(화면)
		// System - 너 PC를 가리킴
		// out - 명사형, 출력을 내보낼때 사용
		// println() - 메소드 - 화면 출력
		System.out.println(sal); //800
		System.out.println(sal+10); //810
		sal = sal+10;
		System.out.println(sal-10); //800 
		System.out.println(sal+100); //910
		System.out.println(sal+200); //10010
		//아래 코드는 변수를 사용하지 않았다.
		System.out.println(500); //500변수이다:상수이다
		System.out.println(501); //501변수이다:상수이다
		System.out.println(502); //502변수이다:상수이다
		//a
		//name="SMITH"
			
		

	}

}
