package com.quiz0529;
//생성자와 this
/*
 * this : 자기자신의 주소번지, this() : 자기자신 생성자호출
 * 생성자도 메소드 오버로딩의 규칙을 준수한다
 * 리턴타입(void, int, Question3)이 있다면 메소드이다.
 */
public class Question3_2 {
	 int bootch;
	 String snootch;
	
	 public Question3_2() {  // 
	 this("snootchy");   // 
	 System.out.print("first ");  // 
	 }
	
	 public Question3_2(String snootch) {  // 3
	 this(420, "snootchy");  // 4 :
	 System.out.print("second ");  // 
	 }
	
	 public Question3_2(int bootch, String snootch) {  // 5
	 this.bootch = bootch;  // 6 : 420
	 this.snootch = snootch;  // 7 : snootchy
	 System.out.print("third ");  // 8 : third
	 }
	 /*
	  * 30-31-12-17-22[420,"snootchy"-초기화]-25(third출력)
	  * 19(second출력)-14(first출력)-33(snootchy 420출력)
	  */
	 public static void main(String[] args) {
	 Question3_2 b = new Question3_2();
	 System.out.print(b.snootch +" " + b.bootch);  //
	 }
}