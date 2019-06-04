package com.ch4;
/*
 * 등비수열은 각 항의 앞에 일정한 수를 곱해서
 * 이루어지는 수열을 말합니다.
 * a1항에서 a7항까지의 수열을 출력하세요.
 * a1 a2 a3  a4  a5   a6  a7
 * --------------------------
 * 2  6  18  54  162  486 1458
 */
public class dungbee {

	public static void main(String[] args) {
		int i=2;
		for(int cnt=1; cnt<8; cnt++) {
			System.out.println("현재등비수열의 "+cnt+" 항은 "+i);
			i=i*3;
		}
		
	}

}
