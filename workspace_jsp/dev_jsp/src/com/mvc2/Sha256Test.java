package com.mvc2;

import com.util.Sha256Util;

public class Sha256Test {

	public static void main(String[] args) {
		String pw = "123";
		String result = Sha256Util.applySha256(pw);
		System.out.println(result);
	}

}
