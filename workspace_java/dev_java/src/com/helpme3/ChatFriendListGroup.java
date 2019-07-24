package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 채팅방속 친구목록의 그룹레이아웃 생성자 이용 어쩌구
 */
public class ChatFriendListGroup extends JPanel {
	JPanel jp_img = new JPanel();
	JPanel jp_name = new JPanel();
	JLabel jl_img = new JLabel("프사", JLabel.CENTER);
	JLabel jl_name = new JLabel("이름", JLabel.LEFT);
	Map<String, Object> map = new HashMap<>();

	public ChatFriendListGroup() {
		initDisplay();
	}

	public void initDisplay() {

		jp_img.setLayout(new BorderLayout());
		jp_name.setLayout(new BorderLayout());
		jp_img.add(jl_img);
		jp_name.add(jl_name);

		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		// 수평 그룹
		gl.setHorizontalGroup(
				// 순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup().addComponent(jp_img, 70, 70, 70)
						// DEFAULT_SIZE : 늘리면 늘리는 만큼 늘어남
						.addComponent(jp_name, 300, 300, GroupLayout.DEFAULT_SIZE));
		// 수직 그룹
		gl.setVerticalGroup(
				// 순차적으로 그룹을 붙히겠다
				gl.createSequentialGroup()
						.addGroup(gl.createParallelGroup(Alignment.BASELINE)
								.addComponent(jp_img, 80, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(jp_name, 80, 80, GroupLayout.PREFERRED_SIZE)));
	}
}
