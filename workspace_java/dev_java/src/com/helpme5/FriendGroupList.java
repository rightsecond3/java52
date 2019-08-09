package com.helpme5;

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

//////////////////단톡방 초대하기 위한 친구목록 다이얼로그 
public class FriendGroupList extends JDialog implements ActionListener {
	/////////////선언부
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
	////////////생성자
	public FriendGroupList(Login login,List<Map<String, Object>> List) {
		this.login = login;
		jbtn_add.addActionListener(this);
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		gr.setRows(List.size());
		jp_center.setLayout(gr);
		List<Map<String, Object>> tList = new Vector<>();
		//////////////서버에서 받은 친구 목록 List를 담기
		tList = List;
		/////////////받은 친구 목록으로 for문 돌려서 패널 넣기
		for (int i = 0; i < tList.size(); i++) {
			FriendGroupListpanel f = new FriendGroupListpanel(tList.get(i),this);
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
		if(obj==jbtn_add) {////////////만들기 누르면 서버에 내 아이디와 선택한 상대방 아이디 목록을 list에 담아서 보냄
			String list = "";
			String status = "단톡";//////채팅방 만들때 구분
			for(int i =0;i<friends.size();i++) {/////////아이디 사이에 ,넣기 위해 돌리는 for문
				if(i==friends.size()-1) {		/////////String에 담을때 마지막부분에 , 안넣을라고 만든 if			
					list = list+friends.get(i);
				}else {				///////////String에 담을때 서버에서 자르기 위한 , 넣기 위한 부분
					list = list+friends.get(i)+",";
				}
			}
			try {////////////////서버에 보내기 아이디랑 선택한 상대방 아이디 담은 list보내기
				login.oos.writeObject(Protocol.ROOM_CREATE_GROUP
							+Protocol.seperator+login.mem_id
							+Protocol.seperator+list+ Protocol.seperator + status);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}


}
