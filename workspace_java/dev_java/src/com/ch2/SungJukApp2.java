package com.ch2;
public class SungJukApp2 {
	int hap(int jumsu1, int jumsu2, int jumsu3) {
		int tot = 0;
		tot = jumsu1 + jumsu2 + jumsu3;
		return tot;
	}
	void average(int tot, int inwon) {
		double avg = 0.0;
		avg = tot/(double)inwon;
		System.out.println("평균은 "+avg+"입니다.");
	}
	public static void main(String[] args) {
		SungJukApp2 sa2 = new SungJukApp2();
		int tot = sa2.hap(70, 80, 90);
		sa2.average(tot, 3);
	}
}
