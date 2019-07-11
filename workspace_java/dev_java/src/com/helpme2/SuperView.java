package com.helpme2;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SuperView extends JFrame implements ActionListener {
	// 선언부
	JLabel jl_friend = new JLabel();
	JPanel jp_super = new JPanel();
	JLabel jl_search = new JLabel("검색기능");
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
	public SuperView() {
		initDisplay();
	}

	// 화면구현
	public void initDisplay() {
		//이벤트 처리
		jbtn_friend.addActionListener(this);
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
		//refreshFriend(); //친구목록
		//창이 닫힐 때 자원반납하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp_super.setLayout(new BorderLayout());
		jp_super.add("North",jl_search);
		jp_super.add("Center",jsp_friend);
		//this.add("Center", jsp_friend);
		this.add("Center",jp_super);
		this.add("North", jp_first);
		this.setSize(500, 600);
		this.setVisible(true);
	}
	//** 친구 목록 메소드
	public void refreshFriend() {
		GridLayout gl = new GridLayout();
		jp_center.setLayout(gl);
		Dao dao = new Dao();
		List<testVO> tList = new Vector<>();
		tList = dao.test();
		testVO tVO = new testVO();
		jl_friend.setText("친구 : "+tList.size());
		//친구 수가 적을 경우 그리드 레이아웃이 화면을 다 분활하는 것을 방지
		if(tList.size()<10) {
			gl.setRows(10);
		} else {
			gl.setRows(tList.size());
		}
		//DB에 있는 값 들로 친구 목록 초기화
		for(int i = 0; i < tList.size(); i++) {
			FriendGroupLayout frl = new FriendGroupLayout();
			tVO = tList.get(i);
			frl.jl1.setIcon(new ImageIcon(imgPath+"default.png"));
			frl.jl2.setText(tVO.getMem_name());
			frl.jl3.setText(tVO.getMem_email());
			jp_center.add(frl);
		}
	}
	//** 이벤트 처리부
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtn_friend==obj) {
			refreshFriend();
		}
	}


}
