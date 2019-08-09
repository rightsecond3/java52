package com.basic;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		String msg = "A|B";
		StringTokenizer stz = new StringTokenizer(msg, "|");
		String a = stz.nextToken();
		System.out.println(a);
		String b = null;
		while(stz.hasMoreTokens()) {
			b = stz.nextToken();
		}
		if(b==null) {
			b = "빈문자열";
		}
		System.out.println(b);
	}

}