package com.baseball;

import javax.swing.JFrame;

public class BaseBallGameView extends JFrame {
	JButton jbtn_new = new JButton("새 게임");
	public static void main(String[] args) {
		//객체를 생성하고 생성자를 호출하고 싶을 때 쓰는 코드
		new BaseBallGameView();
	}

}
