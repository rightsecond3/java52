package com.basic;

import java.util.StringTokenizer;

public class StzTest {

	public static void main(String[] args) {
		String msg = "jvm,kyeong ";
		StringTokenizer stz = new StringTokenizer(msg, ",");
		String jvm = null;
		String kyeong = null;
		int i =0;
		while(stz.hasMoreTokens()) {
			System.out.println("i : "+ ++i);
			jvm = stz.nextToken();
			kyeong = stz.nextToken();
		}
		System.out.println(jvm+", "+kyeong);
	}

}
