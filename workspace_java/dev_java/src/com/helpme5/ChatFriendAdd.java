package com.helpme5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ChatFriendAdd extends JDialog implements ActionListener{
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center) {
		@Override
		public void setBorder(Border border) {
		}
	};
	JButton jbtn_add = new JButton("친구 초대");
	List<String> friends = new ArrayList<>();
	Login login = null;
	String clist_code = null;
	////////////생성자
	public ChatFriendAdd(Login login,List<Map<String, Object>> List, String clist_code) {
		this.clist_code = clist_code;
		this.login = login;
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		gr.setRows(List.size());
		jp_center.setLayout(gr);
		List<Map<String, Object>> tList = new Vector<>();
		jbtn_add.addActionListener(this);
		//////////////서버에서 받은 친구 목록 List를 담기
		tList = List;
		/////////////받은 친구 목록으로 for문 돌려서 패널 넣기
		for (int i = 0; i < tList.size(); i++) {
			ChatFriendAddPanel f = new ChatFriendAddPanel(tList.get(i),this);
			jp_center.add(f);
			jp_south.add(jbtn_add);
		}
		this.add("Center", jp_center);
		this.add("South", jp_south);
		this.pack();
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(jbtn_add==obj) {
			String list = "";
			for(int i =0;i<friends.size();i++) {/////////아이디 사이에 ,넣기 위해 돌리는 for문
				if(i==friends.size()-1) {		/////////String에 담을때 마지막부분에 , 안넣을라고 만든 if			
					list = list+friends.get(i);
				}else {				///////////String에 담을때 서버에서 자르기 위한 , 넣기 위한 부분
					list = list+friends.get(i)+",";
				}
			}
			try {				
				login.oos.writeObject(Protocol.ROOM_ADD
						             +Protocol.seperator+clist_code
						             +Protocol.seperator+list
						             +Protocol.seperator+login.mem_id
						             );
				this.dispose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
