package com.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomGame {
	
	public static void main(String[] args) {
		//BufferdReader : 보조 스트림(단독 사용 불가, 반드시 기반스트림과 연계)
		//InputStreamReader : 기반 스트림(단독 읽기 혹은 쓰기 가능)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("0~9 사이의 숫자를 입력하세요.");
		try {
			int user = Integer.parseInt(br.readLine());
			if(user>10) {
				System.out.println("0~9 사이의 숫자를 입력하세요.");
			} else {
				System.out.println("사용자가 입력한 값  : "+user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
