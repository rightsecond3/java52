package com.basic;

import java.util.StringTokenizer;

public class StzTest {

	public static void main(String[] args) {
		String msg = "jvm,kyeong, ";
		StringTokenizer stz = new StringTokenizer(msg, ",");
		while(stz.hasMoreTokens()) {
			System.out.println("토큰 : "+stz.nextToken());
		}
	}

}
