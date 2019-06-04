package com.myquiz0529;
//3번 라인에 독립적으로 삽입된 두 개의 코드 조각 중 출력 4247을 생성하는 것은 무엇인가? (2개 선택)
public class myQ15 {

	public static void main(String[] args) {
	
		StringBuffer s = new StringBuffer("4247");
		s.delete(0,3).replace( 1,3, "24").delete(4,6);
		

//		
//		StringBuilder s = new StringBuilder("124456789");
//		s.substring(3,6).delete( 1 ,2).insert( 1, "24");
//		

		
		System.out.println(s);
	}

}
