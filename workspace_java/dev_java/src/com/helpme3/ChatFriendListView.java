package com.helpme3;

/*
 * 채팅창 친구 목록 뷰
 */
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatFriendListView extends JFrame {
	// 선언부
	JPanel jp_center = new JPanel();
	JLabel jl_img = new JLabel();
	JLabel jl_rname = new JLabel("방이름");
	JLabel jl_num = new JLabel("명수");
	JLabel jl_pro = new JLabel("프로필사진");
	JLabel jl_name = new JLabel("이름");
	JButton jbtn = new JButton("추가");

	JPanel jp_north = new JPanel();
	JPanel jp_right = new JPanel();
	JPanel jp_second = new JPanel();
	JPanel jp_img = new JPanel();
	JPanel jp_rname = new JPanel();
	JPanel jp_num = new JPanel();
	JPanel jp_pro = new JPanel();
	JPanel jp_name = new JPanel();
	JPanel jp_list = new ChatFriendListGroup();

	public void initDisplay() {
		// 이미지 붙이기
		ImageIcon img = new ImageIcon("C:\\workspace_java\\dev_java\\src\\images\\lion11.png");
		ImageIcon img1 = new ImageIcon("C:\\workspace_java\\dev_java\\src\\images\\plus.png");
		Image origin = img1.getImage();
		Image changedImg = origin.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		jbtn.setBorderPainted(false);
		jbtn.setFocusPainted(false);
		jbtn.setContentAreaFilled(false);
		jbtn.setIcon(new ImageIcon(changedImg));
		jl_img.setIcon(new ImageIcon(img.toString()));
		jp_img.add(jl_img);
		jp_rname.add(jl_rname);
		jp_num.add(jl_num);
		jp_pro.add(jl_pro);
		jp_name.add(jl_name);
		// 위쪽패널
		jp_second.setLayout(new GridLayout(1, 2));
		jp_second.add(jl_num);
		jp_second.add(jbtn);
		jp_right.setLayout(new GridLayout(2, 1));
		jp_right.add(jl_rname);
		jp_right.add(jp_second);
		jp_north.setLayout(new GridLayout(1, 2));
		jp_north.add(jp_img);
		jp_north.add(jp_right);

		this.add("Center", jp_list);
		this.add("North", jp_north);
		this.setSize(366, 600);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ChatFriendListView cflv = new ChatFriendListView();
		cflv.initDisplay();
	}
}
