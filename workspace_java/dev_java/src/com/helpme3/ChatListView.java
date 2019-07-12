package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

public class ChatListView extends JPanel {
	///// 선언부
	// * 검색
	JPanel jp_search = new JPanel();
	JButton jbtn_search = new JButton("검색");
	// 텍스트필드의 외부 보더 검정색 제거
	JTextField jtf_search = new JTextField(35) {
		public void setBorder(Border border) {
		}
	};
	// * 채팅목록
	JPanel jp_chat = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_chat) {
		public void setBorder(Border border) {
		}
	};
	ChatGroup cg = null;
	
	// 테스트 완료
	List<Map<String, Object>> list = null;

	/// ** 생성자
	public ChatListView() {
		jp_search.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jp_search.setBackground(Color.GRAY);
		jp_search.add(jtf_search);
		jp_search.add(jbtn_search);

		// * GroupLayout 넣기
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		ChatDao cDao = new ChatDao();
		list = cDao.getChatMap();
		gr.setRows(10);
		jp_chat.setLayout(gr);
		// GroupLayout쪽에 해당하는 이벤트와 라벨을 붙히기 위해 list를 보내줌
		for (int i = 0; i < list.size(); i++) {
			cg = new ChatGroup();
			cg.initDisplay(list.get(i));
			jp_chat.add(cg);
		}

		this.add("North", jp_search);
		this.add("Center", jsp);
	}

}