package com.helpme4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import com.google.gson.Gson;
////////////////채팅창안에서 친구초대 하려고 목록 불러올때 FriendGroupList보고 이해하기 똑같음
public class ChatGroupList extends JDialog implements ActionListener {
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center) {
		@Override
		public void setBorder(Border border) {
		}
	};
	JButton jbtn_add = new JButton("단톡방 개설");
	List<String> friends = new ArrayList<>();
	Login login = null;
	public ChatGroupList(Login login,List<Map<String, Object>> List) {
		this.login = login;
		jbtn_add.addActionListener(this);
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		gr.setRows(List.size());
		jp_center.setLayout(gr);
		List<Map<String, Object>> tList = new Vector<>();
		tList = List;
		for (int i = 0; i < tList.size(); i++) {
			ChatGroupListpanel f = new ChatGroupListpanel(tList.get(i),this);
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
		if(obj==jbtn_add) {
			String list = "";
			String status = "단톡";
			for(int i =0;i<friends.size();i++) {
				if(i==friends.size()-1) {					
					list = list+friends.get(i);
				}else {				
					list = list+friends.get(i)+",";
				}
			}
			try {
				login.oos.writeObject(Protocol.ROOM_CREATE_GROUP
							+Protocol.seperator+login.mem_id
							+Protocol.seperator+list+ Protocol.seperator + status);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}


}
