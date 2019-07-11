package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MainView extends JFrame implements ActionListener {
	//// 선언부
	//검색창 north, 그룹레이아웃한 그리드 레이아웃 센터에 붙히시면 됩니다.
	JLabel jl_friend = new JLabel("    친구 : ");
	JPanel jp_first = new JPanel();
	JPanel jp_first_south = new JPanel();
	JButton jbtn_friend = new JButton();
	JButton jbtn_talk = new JButton();
	JButton jbtn_set = new JButton();
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	String img[] = { "friend.jpg", "talk.jpg", "setting.jpg" };
	JButton imgFiles[] = { jbtn_friend, jbtn_talk, jbtn_set };

	JPanel jp_center = new JPanel();
	JScrollPane jsp_friend = new JScrollPane(jp_center,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//*** 생성자 ***//
	public MainView() {
	}

	// 화면구현
	public void initDisplay() {
		//이벤트 처리
		jbtn_friend.addActionListener(this);
		jbtn_talk.addActionListener(this);
		//화면 붙히기
		for (int i = 0; i < img.length; i++) {
			imgFiles[i].setIcon(new ImageIcon(imgPath + img[i]));
			imgFiles[i].setBorderPainted(false);
			imgFiles[i].setFocusPainted(false);
			imgFiles[i].setContentAreaFilled(true);
		}
		jbtn_friend.setBackground(Color.white);
		jbtn_talk.setBackground(Color.white);
		jbtn_set.setBackground(Color.white);
		jp_first_south.setBackground(Color.white);
		jp_first.setBackground(new Color(229, 153, 90));
		
		jp_first.setLayout(new GridLayout(2, 1));
		jp_first.add(jl_friend);
		jp_first.add(jp_first_south);
		jp_first_south.setLayout(new GridLayout(1, 3));
		jp_first_south.add(jbtn_friend);
		jp_first_south.add(jbtn_talk);
		jp_first_south.add(jbtn_set);
		jp_center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//창이 닫힐 때 자원반납하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add("North", jp_first);
		this.setSize(500, 600);
		this.setVisible(true);
	}

	//** 이벤트 처리부
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtn_talk == obj) {
			Container cont = this.getContentPane();
			if(jp_center!=null) {
				cont.remove(jp_center);
			}
			ChatView fv = new ChatView();
			this.add("Center", fv);
			cont.revalidate();
			cont.repaint();
		}
	}
	public static void main(String[] args) {
		MainView mv = new MainView();
		mv.initDisplay();
	}
}
