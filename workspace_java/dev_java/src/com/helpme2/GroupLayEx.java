package com.helpme2;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GroupLayEx extends JFrame {
	JPanel jp_center = new JPanel();
	JPanel jp_1 = new JPanel();
	JPanel jp_2 = new JPanel();
	JPanel jp_3 = new JPanel();
	JPanel jp_4 = new JPanel();
	JPanel jp_5 = new JPanel();
	JPanel jp_6 = new JPanel();
	JLabel jl_1 = new JLabel("1");
	JLabel jl_2 = new JLabel("2");
	JLabel jl_3 = new JLabel("3");
	JLabel jl_4 = new JLabel("4");
	JLabel jl_5 = new JLabel("5");
	JLabel jl_6 = new JLabel("6");
	
	
	public void initDistplay() {
		jp_1.add(jl_1);
		jp_2.add(jl_2);
		jp_3.add(jl_3);
		jp_4.add(jl_4);
		jp_5.add(jl_5);
		jp_6.add(jl_6);
		GroupLayout gl = new GroupLayout(jp_center);
		jp_center.setLayout(gl);
		gl.setAutoCreateGaps(true);
		gl.setAutoCreateGaps(true);
		this.setLayout(new BorderLayout());
		//수평 그룹
		gl.setHorizontalGroup(
				//순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup()
					//평행한 그룹을 만듦 1 밑에 4 - 컬럼
					.addGroup(gl.createParallelGroup(Alignment.LEADING)
							.addComponent(jp_1)
							.addComponent(jp_4))
					//평행한 그룹을 만듦 2 밑에 5
					.addGroup(gl.createParallelGroup(Alignment.LEADING)
							.addComponent(jp_2)
							.addComponent(jp_5))
					//평행한 그룹을 만듦 - 3 밑에 6
					.addGroup(gl.createParallelGroup(Alignment.LEADING)
							.addComponent(jp_3)
							.addComponent(jp_6))
				);
		//수직 그룹
		gl.setVerticalGroup(
				//순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup()
					//평행 수직 그룹을 만듦 - 1번째 로우
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)	
							.addComponent(jp_1)
							.addComponent(jp_2)
							.addComponent(jp_3))
					// 2번째 로우
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jp_4)
							.addComponent(jp_5)
							.addComponent(jp_6))
				);
		this.add("Center", jp_center);
		this.setSize(400, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		GroupLayEx ge = new GroupLayEx();
		ge.initDistplay();
	}

}
