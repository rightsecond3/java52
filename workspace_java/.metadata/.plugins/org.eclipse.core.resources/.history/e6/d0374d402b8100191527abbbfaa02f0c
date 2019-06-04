package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class P170_1 extends JFrame{
	String title;
	JButton jbtn = new JButton("전송");
	
	public P170_1() {
		initDisplay();
	}//디폴트 생성자
	public P170_1(String title) {
		this.title=title;
		//주의 : title을 먼저 초기화하고 화면을 출력해야함.
		initDisplay();
	}
	public void initDisplay() {
		//디폴트 생성자는 없으면 JVM이 대신 추가
		//생성자가 하나라도 있으면 대신 생성해주지 않음.
		P170_1Event pEvent = new P170_1Event(this);//this->P170_1
		//P170_1Event pEvent = new P170_1Event(jbtn);
		jbtn.addActionListener(pEvent);
		this.add("North", jbtn);
		this.setTitle(title);//JFrame을 상속 받았기 때문에 this로 대체 가능
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		P170_1 p2 = new P170_1("Hello");
	}
}