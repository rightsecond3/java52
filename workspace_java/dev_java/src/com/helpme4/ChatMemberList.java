package com.helpme4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ChatMemberList extends JDialog {
/////////////선언부
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center) {
		@Override
		public void setBorder(Border border) {
		}
	};
	List<String> friends = new ArrayList<>();
	Login login = null;

////////////생성자
	public ChatMemberList(Login login,List<Map<String, Object>> List) {
	this.login = login;
	this.setLayout(new BorderLayout());
	GridLayout gr = new GridLayout();
	gr.setRows(List.size());
	jp_center.setLayout(gr);
	List<Map<String, Object>> tList = new Vector<>();
	//////////////서버에서 받은 친구 목록 List를 담기
	tList = List;
	/////////////받은 친구 목록으로 for문 돌려서 패널 넣기
	for (int i = 0; i < tList.size(); i++) {
		ChatMemberListPanel f = new ChatMemberListPanel(tList.get(i),this);
		jp_center.add(f);
	}
	this.add("Center", jp_center);
	this.add("South", jp_south);
	this.pack();
	this.setVisible(true);
	}

}
