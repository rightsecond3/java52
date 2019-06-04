package com.quiz0529;
//오토박싱과 switch
public class Question5 {

	public static void main(String[] args) {
		Question5 q5 = new Question5();
		int i2 = 10;
		Integer i3 = new Integer(100);
		i2 = i3;//오토박싱
		System.out.println(i2);//i2-100출력
		Integer i = new Integer(1) + new Integer(2);//i-3
		switch(i) {
		case 3: System.out.println("three");
			break;
		default: System.out.println("other");
			break;
		 }

	}

}
