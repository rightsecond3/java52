package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P170_1Event implements ActionListener{
	P170_1 p170_1 = null; //클래스, 배열, 인터페이스도 데이터 타입이다.
	//P170_1 클래스에서 생성된 버튼을 사용하고 싶다.
	//어떡하지?
	public P170_1Event(P170_1 p170_1) {
		this.p170_1 = p170_1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//전송
		if("전송".equals(label)) {
			p170_1.jbtn.setText("보내기"); //p170_1에 P170_1의 객체가 저장되어있기 때문에 사용가능
		}
	}
}