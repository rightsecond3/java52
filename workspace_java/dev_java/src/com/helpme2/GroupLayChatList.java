package com.helpme2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupLayChatList extends JFrame {
	JPanel jp_img = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_time = new JPanel();
	JLabel jl_img = new JLabel("프사");
	JLabel jl_name = new JLabel("이름");
	JLabel jl_msg = new JLabel("마지막메세지");
	JLabel jl_time = new JLabel("시간");
	
	
	public void initDistplay() {
		
		jp_img.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_time.setLayout(new BorderLayout());
		
		jl_img.setHorizontalAlignment(JLabel.CENTER);
		jl_name.setHorizontalAlignment(JLabel.LEFT);
		jl_msg.setHorizontalAlignment(JLabel.LEFT);
		jl_time.setHorizontalAlignment(JLabel.RIGHT);
		
		jp_second.setLayout(new GridLayout(2,1));
		jp_img.add(jl_img);
		jp_second.add(jl_name);
		jp_second.add(jl_msg);
		jp_time.add(jl_time);
		
		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		gl.setAutoCreateGaps(true);
		gl.setAutoCreateGaps(true);
		this.setLayout(new BorderLayout());
		//수평 그룹
		gl.setHorizontalGroup(
				//순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup()
					.addComponent(jp_img, 70, 70, 70)
					.addComponent(jp_second, 300, 300, GroupLayout.DEFAULT_SIZE)
					.addComponent(jp_time, 70, 70, 70)
				);
		//수직 그룹
		gl.setVerticalGroup(
				//순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jp_img, 80, 80, GroupLayout.PREFERRED_SIZE)
							.addComponent(jp_second, 80, 80, GroupLayout.PREFERRED_SIZE)
							.addComponent(jp_time, 80, 80, GroupLayout.PREFERRED_SIZE)
							)
				);
		this.add("Center", jp_center);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		GroupLayChatList ge = new GroupLayChatList();
		ge.initDistplay();
	}

}
