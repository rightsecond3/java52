package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;

public class SettingView extends JPanel implements ActionListener {
	// 전체 패널
	JPanel jp_profile = new JPanel();
	JPanel jp_setting = new JPanel();

	/// jp_profile에 붙는 패널
	JPanel jp_pro_picture = new JPanel();
	JPanel jp_pro_introduce = new JPanel();

	JButton jbtn_picture = new JButton();// 프로필 사진
	String imgpic = "lion55.png"; // 프로필 사진
	JLabel jl_picture_nick = new JLabel("nickname", JLabel.LEFT);
	JLabel jl_picture_id = new JLabel("id", JLabel.LEFT);

	//// jp_setting 에 붙는 버튼
	JButton jbtn_nickname = new JButton();// 닉네임
	JButton jbtn_font = new JButton();// 글자
	JButton jbtn_bg = new JButton();// 배경
	JButton jbtn_pimage = new JButton();// 프사
	JButton jbtn_info = new JButton();// 몽톡정보
	JButton jbtn_notice = new JButton();// 몽톡정보

	// 버튼에 붙는 패널
	JPanel jp_nickname = new JPanel();
	JPanel jp_font = new JPanel();
	JPanel jp_bg = new JPanel();
	JPanel jp_pimage = new JPanel();
	JPanel jp_info = new JPanel();
	JPanel jp_notice = new JPanel();

	// 버튼 패널에 붙는 이미지와 라벨
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	ImageIcon img_nick = new ImageIcon(imgPath + "nickname.png");
	JLabel jl_nick = new JLabel("닉네임 변경", img_nick, JLabel.CENTER);
	ImageIcon img_font = new ImageIcon(imgPath + "font.png");
	JLabel jl_font = new JLabel("폰트 변경", img_font, JLabel.CENTER);
	ImageIcon img_bg = new ImageIcon(imgPath + "bg.png");
	JLabel jl_bg = new JLabel("배경 변경", img_bg, JLabel.CENTER);
	ImageIcon img_pimage = new ImageIcon(imgPath + "pimage.png");
	JLabel jl_pimage = new JLabel("프로필 이미지 변경", img_pimage, JLabel.CENTER);
	ImageIcon img_info = new ImageIcon(imgPath + "info.png");
	JLabel jl_info = new JLabel("몽톡 정보", img_info, JLabel.CENTER);
	ImageIcon img_notice = new ImageIcon(imgPath + "notice.png");
	JLabel jl_notice = new JLabel("공지사항", img_notice, JLabel.CENTER);

	public SettingView() {
		// 패널_프로필 구역 나누기
		jp_profile.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_profile.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		jp_profile.setBackground(Color.white);
		jp_profile.add(jp_pro_picture);
		// jp_pro_picture.setMinimumSize(new Dimension(100,700));

		// 패널_프로필_사진에 프사 버튼 추가
		jp_pro_picture.setBackground(Color.white);
		jp_pro_picture.add(jbtn_picture);
		// jbtn_picture.setVerticalAlignment(JButton.LEFT);
		jbtn_picture.setBackground(Color.white);
		jbtn_picture.setIcon(new ImageIcon(imgPath + imgpic));
		jbtn_picture.setBorderPainted(false);
		jbtn_picture.setFocusPainted(false);
		jbtn_picture.setContentAreaFilled(true);

		// 패널_프로필_소개 구역에 라벨 붙이기
		jp_profile.add(jp_pro_introduce);
		jp_pro_introduce.setLayout(new GridLayout(2, 1));
		jp_pro_introduce.setBackground(Color.white);
		jp_pro_introduce.add(jl_picture_id);
		jl_picture_id.setFont(new Font("명조", Font.CENTER_BASELINE, 20));
		jp_pro_introduce.add(jl_picture_nick);
		jl_picture_nick.setFont(new Font("명조", Font.CENTER_BASELINE, 20));
		jl_picture_id.setVerticalAlignment(JLabel.BOTTOM);
		jl_picture_nick.setVerticalAlignment(JLabel.TOP);

		// 세팅 구역에 버튼 붙이기
		jp_setting.setLayout(new GridLayout(6, 1));
		jp_setting.setBackground(Color.white);
		jp_setting.add(jbtn_nickname);
		jp_setting.add(jbtn_font);
		jp_setting.add(jbtn_bg);
		jp_setting.add(jbtn_pimage);
		jp_setting.add(jbtn_info);
		jp_setting.add(jbtn_notice);
		// 세팅 구역 버튼에 패널 붙이기. -닉네임
		jbtn_nickname.add(jp_nickname);
		jbtn_nickname.setBackground(Color.white);
		jbtn_nickname.setFocusPainted(false);
		jbtn_nickname.setContentAreaFilled(false);
		jp_nickname.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_nickname.setBackground(Color.white);
		jp_nickname.add(jl_nick);
		// 세팅 구역 버튼에 패널 붙이기. -폰트
		jbtn_font.add(jp_font);
		jbtn_font.setBackground(Color.white);
		jbtn_font.setContentAreaFilled(false);
		jp_font.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_font.setBackground(Color.white);
		jp_font.add(jl_font);
		// 세팅 구역 버튼에 패널 붙이기. -배경
		jbtn_bg.add(jp_bg);
		jbtn_bg.setBackground(Color.white);
		jbtn_bg.setContentAreaFilled(false);
		jp_bg.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_bg.setBackground(Color.white);
		jp_bg.add(jl_bg);
		// 세팅 구역 버튼에 패널 붙이기. -프로필 이미지 변경
		jbtn_pimage.add(jp_pimage);
		jbtn_pimage.setBackground(Color.white);
		jbtn_pimage.setContentAreaFilled(false);
		jp_pimage.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_pimage.setBackground(Color.white);
		jp_pimage.add(jl_pimage);
		// 세팅 구역 버튼에 패널 붙이기. -몽톡 정보
		jbtn_info.add(jp_info);
		jbtn_info.setBackground(Color.white);
		jbtn_info.setContentAreaFilled(false);
		jp_info.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_info.setBackground(Color.white);
		jp_info.add(jl_info);

		// 세팅 구역 버튼에 패널 붙이기. -공지사항
		jbtn_notice.add(jp_notice);
		jbtn_notice.setBackground(Color.white);
		jbtn_notice.setContentAreaFilled(false);
		jp_notice.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_notice.setBackground(Color.white);
		jp_notice.add(jl_notice);
		jp_profile.setMaximumSize(new Dimension(500, 20));
		this.setLayout(new GridLayout(2, 1));
		this.add(jp_profile);
		this.add(jp_setting);

		jp_profile.setMaximumSize(new Dimension(500, 70));

		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup().addComponent(jp_profile).addComponent(jp_setting)));
		gl.setVerticalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup()).addComponent(jp_profile)
				.addGroup(gl.createParallelGroup()).addComponent(jp_setting));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
