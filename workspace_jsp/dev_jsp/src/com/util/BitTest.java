package com.util;

public class BitTest {
	public static void main(String[] args) {
		int n = 150;
		System.out.println(Integer.toBinaryString(n));
		byte b = (byte) n;
		System.out.println(b);
		System.out.println(b & 0xff);
	}
}
