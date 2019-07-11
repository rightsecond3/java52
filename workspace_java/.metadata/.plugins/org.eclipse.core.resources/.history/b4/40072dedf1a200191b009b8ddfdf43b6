package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ChatView extends JPanel {
	///선언부
	//* 검색
	JPanel jp_search = new JPanel();
	JButton jbtn_search = new JButton("검색");
	JTextField jtf_search = new JTextField(20) {
		public void setBorder(Border border) {}
	};
	//* 채팅목록
	JPanel jp_chat = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_chat) {
		public void setBorder(Border border) {}
	};
	
	public ChatView() {
		jp_search.setBackground(new Color(220, 111, 0));
		jp_search.setLayout(new FlowLayout(FlowLayout.LEFT));
		jtf_search.setBackground(new Color(215, 132, 48));
		jp_search.add(jtf_search);
		jp_search.add(jbtn_search);
		//* GroupLayout 넣기
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		gr.setRows(10);
		jp_chat.setLayout(gr);
		for (int i=0;i<10;i++) {
			ChatGroup fg = new ChatGroup();
			jp_chat.add(fg);
		}
		this.add("North", jp_search);
		this.add("Center", jsp);
	}
	
}
