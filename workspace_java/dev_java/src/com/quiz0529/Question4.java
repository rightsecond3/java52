package com.quiz0529;

public class Question4 {
	 public void testIfA() {
		 if(testIfB("True")) {
			 System.out.println("True");
		 } else {
			 System.out.println("Not true");
		 }
	 }
	 public Boolean testIfB(String str) {
		//XXX.valueof():()안의 값을 XXX로 형전환시켜줌, 래퍼클래스기억
		 return Boolean.valueOf(str);
	 }
	 /* 17-18-19-4-5-11-12
	  * 
	  */
	public static void main(String[] args) {
		Question4 q4 = new Question4();
		q4.testIfA();
	}

}
