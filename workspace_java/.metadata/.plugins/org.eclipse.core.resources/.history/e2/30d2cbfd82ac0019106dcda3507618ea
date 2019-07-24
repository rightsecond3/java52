package com.helpme3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*
 * 로그인 다음
 */
public class MainView extends JFrame implements ActionListener {
	//// 선언부
	// 검색창 north, 그룹레이아웃한 그리드 레이아웃 센터에 붙히시면 됩니다.
	JPanel jp_view = new JPanel();
	JLabel jl_friend = new JLabel("    친구 : ");
	JPanel jp_first = new JPanel();
	JPanel jp_first_south = new JPanel();
	JButton jbtn_friend = new JButton();
	JButton jbtn_talk = new JButton();
	JButton jbtn_set = new JButton();
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	String img[] = { "users.png", "cloud.png", "settings.png" };
	JButton imgFiles[] = { jbtn_friend, jbtn_talk, jbtn_set };

	JPanel jp_center = new JPanel();
	FriendView frl = null;
	String mem_id = null;
	
	// *** 생성자 ***//
	public MainView(String mem_id) {
		this.mem_id = mem_id;
		initDisplay();
		friend();
	}

	// 화면구현
	public void initDisplay() {
		// 이벤트 처리
		jbtn_friend.addActionListener(this);
		jbtn_talk.addActionListener(this);
		jbtn_set.addActionListener(this);
		// 화면 붙히기
		for (int i = 0; i < img.length; i++) {
			ImageIcon img_1 = new ImageIcon(imgPath + img[i]);
			Image originImg = img_1.getImage();
			Image changedImg = originImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			imgFiles[i].setIcon(new ImageIcon(changedImg));
			imgFiles[i].setBorderPainted(false);
			imgFiles[i].setFocusPainted(false);
			imgFiles[i].setContentAreaFilled(false);
		}
		jbtn_friend.setBackground(Color.white);
		jbtn_talk.setBackground(Color.white);
		jbtn_set.setBackground(Color.white);
		jp_first_south.setBackground(Color.white);
		// jp_first.setBackground(new Color(229, 153, 90));
		jp_first.setBackground(Color.white);

		jp_first.setLayout(new GridLayout(2, 1));
		jp_first.add(jl_friend);
		jp_first.add(jp_first_south);
		jp_first_south.setLayout(new GridLayout(1, 3));
		jp_first_south.add(jbtn_friend);
		jp_first_south.add(jbtn_talk);
		jp_first_south.add(jbtn_set);

		// 창이 닫힐 때 자원반납하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add("Center", jp_view);
		this.add("North", jp_first);
		this.setSize(500, 600);
		this.setMinimumSize(new Dimension(500, 600));
		this.setVisible(true);

	}

	public void friend() {
		Container cont = this.getContentPane();
		if (jp_view != null) {
			cont.remove(jp_view);
			jp_view = null;
		}
		jp_view = new FriendView(mem_id);
		this.add("Center", jp_view);
		cont.revalidate();
		cont.repaint();
	}

	// ** 이벤트 처리부
	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		///////////////////////////////// 친구목록으로 바꾸기/////////////////
		if (obj == jbtn_friend) {
			friend();
		} else if (jbtn_talk == obj) {
			Container cont = this.getContentPane();
			if (jp_view != null) {
				cont.remove(jp_view);
				jp_view = null;
			}
			jp_view = new ChatListView();
			this.add("Center", jp_view);
			cont.revalidate();
			cont.repaint();
		} else if (obj == jbtn_set) {
			if (jbtn_set == obj) {
				Container cont = this.getContentPane();
				if (jp_view != null) {
					cont.remove(jp_view);
					jp_view = null;
				}
				jp_view = new SettingView();
				this.add(jp_view);
				cont.revalidate();
				cont.repaint();
			}
		}
	}

//	public static void main(String[] args) {
//		MainView mv = new MainView();
//		mv.initDisplay();
//	}
}
