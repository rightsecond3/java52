package com.ch3;
/*
 * 자바 중간고사 시험 결과
 * 정지우 : 85
 * 유승기 : 80
 * 이경애 : 82.5
 * 
 * 총점을 구하는 메소드를 선언하시오
 * 메소드 이름 : getTotal
 * 
 * 평균을 구하는 메소드를 선언하시오
 * 메소드 이름 : getAverage
 * 
 * 메소드 선언시 파라미터와 리턴타입을 선택하는 기준은 뭘까?
 * 
 * 출력결과 
 * 총점은 ? 입니다.
 * 평균은 ? 입니다.
 */
public class quiz0513_1 {
	public double getTotal(int a, int b, double c) {
		double tot = 0.0;
		tot = a + b + c;
		return tot;
	}
	public double getAverage(double tot, int inwon) {
		double avg = 0.0;
		avg = tot/inwon;
		return avg;

	}
	public static void main(String[] args) {
		quiz0513_1 method = new quiz0513_1();
		double tot = method.getTotal(85, 80, 82.5);
		int inwon = 3;
		double avg = method.getAverage(tot, inwon);
		System.out.println("총점은 "+tot+"입니다.");
		System.out.println("평균은 "+avg+"입니다.");
	}
}
