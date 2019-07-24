package com.helpme3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.multi.MultiLabelUI;

/*
 * 설정창의 몽톡 정보 클래스
 */
public class Setting_info extends JFrame {
	SettingView sv = null;

	JPanel jp_1 = new JPanel();
	JPanel jp_title = new JPanel();
	JLabel jl_title = new JLabel("몽톡 정보");
	JPanel jp_north = new JPanel();
	JPanel jp_mong = new JPanel();
	JPanel jp_mong_ver = new JPanel();
	JPanel jp_south = new JPanel();
	JTextArea jt_south = new JTextArea(25, 40);
	JScrollPane scrollPane = new JScrollPane(jt_south);
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	JLabel jl_mong = new JLabel();
	Icon img_mong = new ImageIcon(imgPath + "몽톡.png");
	JLabel jl_mong_ver = new JLabel("mongTalk.ver1");
	JLabel jl_mong_ver2 = new JLabel("최신버전입니다.");

	public Setting_info(SettingView sv) {
		System.out.println("1");
		this.sv = sv;
		initDisplay();
	}

	public void initDisplay() {
		// 타이틀 패널에 라벨 붙이기
		jp_title.setBackground(new Color(230, 137, 61));
		jp_title.add(jl_title);
		jl_title.setHorizontalAlignment(JLabel.LEFT);
		// 몽톡 정보부붙에 이미지, 라벨 붙이기
		jp_north.add(jp_mong);
		jp_mong.add(jl_mong);
		jp_mong.setBackground(Color.white);
		jl_mong.setIcon(img_mong);
		jl_mong.setBorder(new EmptyBorder(0, 50, 0, 0));
		jp_north.add(jp_mong_ver);
		jp_mong_ver.setBackground(Color.white);
		jp_mong_ver.setLayout(new GridLayout(2, 1));
		jp_mong_ver.add(jl_mong_ver);
		jl_mong_ver.setVerticalAlignment(JLabel.BOTTOM);
		jp_mong_ver.add(jl_mong_ver2);
		jl_mong_ver2.setVerticalAlignment(JLabel.TOP);

		// 텍스트 붙이기....
		jp_south.setBackground(Color.white);
		jp_south.add(scrollPane);
		jp_south.add(jt_south);
		jt_south.setBorder(BorderFactory.createBevelBorder(1));

		jt_south.setEditable(false);

		jp_1.add(jp_north);
		jp_1.add(jp_south);
		jp_1.add(jp_title);

		GroupLayout gl = new GroupLayout(jp_1);
		jp_1.setLayout(gl);
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup().addComponent(jp_title).addComponent(jp_north).addComponent(jp_south)

				));
		gl.setVerticalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup())
				.addComponent(jp_title, 30, 30, 30).addGroup(gl.createParallelGroup())
				.addComponent(jp_north, 70, 70, 70).addGroup(gl.createParallelGroup()).addComponent(jp_south));
		GroupLayout gl2 = new GroupLayout(jp_north);
		jp_north.setLayout(gl2);
		gl2.setHorizontalGroup(
				gl2.createSequentialGroup().addGroup(gl2.createParallelGroup().addComponent(jp_mong, 120, 120, 120))
						.addGroup(gl2.createParallelGroup().addComponent(jp_mong_ver)));
		gl2.setVerticalGroup(gl2.createSequentialGroup()
				.addGroup(gl2.createParallelGroup().addComponent(jp_mong).addComponent(jp_mong_ver)));

		this.add("Center", jp_1);
		// this.setLocation(200, 200);
		this.setSize(500, 600);
		// this.setResizable(false);
		this.setVisible(true);
	}

}
