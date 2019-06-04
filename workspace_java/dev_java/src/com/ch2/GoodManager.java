package com.ch2;

public class GoodManager {

	public static void main(String[] args) {
		OracleConnection oc = new OracleConnection();
		System.out.println(oc._IP);
		System.out.println(oc.PORT);
		System.out.println(oc.user);
		System.out.println();
		SungJuckApp2_1 sa2 = new SungJuckApp2_1();
		System.out.println(sa2.tot);
	}

}
