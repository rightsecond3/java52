package com.ch5;
/*
 * 인스턴스화 할 때 반드시 생성자를 확인해야한다.
 * 생성자를 활용할 수 있어야 한다.
 * API를 볼 때 가장 먼저 생성자를 확인할 것.
 * 
 */
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFram {

	public static void main(String[] args) {
		//JFrame은 디폴트가 BorderLayout입니다.(동,서,남,북,중앙)
		JFrame jf = new JFrame();
		JButton jbtn_east = new JButton();
		jbtn_east.setText("동쪽");//생성자를 활용하지 않고 setter로 설정
		JButton jbtn_center = new JButton("중앙");//생성자를 선택하여 인스턴스화함. 곧 생성자 활용
		jf.add("East",jbtn_east);
		jf.add("Center",jbtn_center);
		jf.setSize(400, 300);
		jf.setVisible(true);
	}
}
