package com.myquiz0529;

public class myQ11 {

	public static void main(String[] args) {
		 for (int i=0;i<= 10;i++){
			if(i>6)
				break;
		}
		System.out.println(i);  //오류-for문안에서 초기화한 i여서 for문 밖에서는 사용할 수 없다.
	}

}

