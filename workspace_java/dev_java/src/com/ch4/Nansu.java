package com.ch4;

import java.util.Random;
import java.util.Scanner;

/*
 * 연습문제2
 * 0부터 9사이의 난수를 채번하여 그 숫자를 맞추는 게임을 구현해보세요
 * 기회는 5번까지만 제공하고
 * 5번 동안 맞추지 못하면 넌 바보라고 출력하시오.
 * 힌트는 낮춰라, 높여라로 한다.
 * Random r = new Random();
 * int nansu = r.nextInt(10);
 * java.lang 폴더 안에 있는 클래스는 따로 import 해주지 않아도 괜찮음
 * Scanner scan = new Scanner(System.in);
 * ->위에 마우스 커서를 올려 놓고 import를 누르면 알아서 위에 추가된다
 */
public class Nansu {

	public static void main(String[] args) {
		int cnt=1;
		Scanner scan = new Scanner(System.in);
		Random r = new Random(); //인스턴스화, r:인스턴스변수
		int nansu = r.nextInt(10); //0부터9까지의 난수 생성
		for(cnt=1;cnt<=5;cnt++) {
			System.out.println("숫자를 입력하세요 : "+cnt+"번째입니다. 기회는 다섯번!");
			int i = scan.nextInt();
			if(i==nansu) {
				System.out.println("정답입니다.");
				break; //정답일 경우 밖으로 나감
			 //System.exit(0); ->가상머신과 연결고리를 끊음
			}else if(nansu>i) {
				System.out.println("높여라");
			}else if(nansu<i) {
				System.out.println("낮춰라");
			}
		}if(cnt==6) {
			System.out.println("너는 멍청이");
		}
	}

}
