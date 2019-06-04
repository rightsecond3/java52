package com.ch2;

public class SungJuckApp2_1 {
		int tot;
		void hap(int jumsu1, int jumsu2, int jumsu3) {
			tot = jumsu1 + jumsu2 + jumsu3;
			
		}
		void average(int tot, int inwon) {
			double avg = 0.0;
			avg = tot/(double)inwon;
			System.out.println("평균은 "+avg+"입니다.");
		}
		public static void main(String[] args) {
			SungJuckApp2_1 sa2 = new SungJuckApp2_1();
			sa2.hap(70, 80, 90);
			sa2.average(sa2.tot, 3);
		}
	}
