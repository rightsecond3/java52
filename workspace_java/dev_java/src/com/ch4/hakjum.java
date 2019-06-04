package com.ch4; //P96
/*
 * 학점을 계산하는 자바를 만들어보자
 * jumsu가 Int 형이기 때문에 85/10 = 8.5가 아닌 8이나오므로
 * 아래와 같은 조건식으로 작성할 수 있다.
 */
import java.util.Scanner;

import javax.swing.JFram;
import javax.swing.JOptionPane;

public class hakjum extends JFram{

	public static void main(String[] args) {
		System.out.println("당신의 자바점수를 입력하세요.");
		Scanner scan = new Scanner(System.in); //Scanner 사용
		int jumsu = scan.nextInt(); //리턴타입이 Int이다
		System.out.println("당신이 입력한 점수는"+jumsu+"입니다.");
		char hakjum = 'Z';
	if(jumsu/10==9 || jumsu/10==10) {
		hakjum = 'A';
		System.out.println("당신의 학점은 "+hakjum+"입니다.");
	}else if(jumsu/10==8) {
		hakjum = 'B';
		System.out.println("당신의 학점은 "+hakjum+"입니다.");
	}else if(jumsu/10==7) {
		hakjum = 'C';
		System.out.println("당신의 학점은 "+hakjum+"입니다.");
	}else if(jumsu/10==6) {
		hakjum = 'D';
		System.out.println("당신의 학점은 "+hakjum+"입니다.");
	}else if(jumsu/10==5 || jumsu/10==4 || jumsu/10==3
			|| jumsu/10==2|| jumsu/10==1|| jumsu/10==0){
		hakjum = 'F';
		System.out.println("당신의 학점은 "+hakjum+"입니다.");
	}else {
		System.out.println("오류 : 0~100까지의 점수만 입력해주세요");
	}
	//static으로 선언된 메소드를 호출할때는 인스턴스화 없이도 사용 가능하다.
	hakjum hakjum = new hakjum();
	JOptionPane.showMessageDialog
	(hakjum, "당신의 학점은"+hakjum+" 입니다.");
}
}
