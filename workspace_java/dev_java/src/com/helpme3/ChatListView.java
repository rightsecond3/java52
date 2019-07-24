package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * 채팅목록에 붙히는 뷰(검색)
 */
public class ChatListView extends JPanel {
	/// 선언부
	// * 검색
	JPanel jp_search = new JPanel();
	JButton jbtn_search = new JButton() {
		@Override
		public void setBorder(Border border) {
		}
	};
	// 텍스트필드의 외부 보더 검정색 제거
	JTextField jtf_search = new JTextField(40) {
		public void setBorder(Border border) {
		}
	};
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	ImageIcon img = new ImageIcon(imgPath + "search.png");
	Image originImg = img.getImage();
	Image changedImg = originImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	// * 채팅목록
	JPanel jp_chat = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_chat) {
		public void setBorder(Border border) {
		}
	};
	ChatListGroup cg = null;
	// 테스트 완료
	List<Map<String, Object>> list = null;
	Map<String, Object> map = null;

	/// ** 생성자
	public ChatListView() {
		jtf_search.setBackground(new Color(220, 220, 220));
		jp_search.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jbtn_search.setIcon(new ImageIcon(changedImg));
		jbtn_search.setBorderPainted(false);
		jbtn_search.setFocusPainted(false);
		jbtn_search.setContentAreaFilled(false);
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
			cg = new ChatListGroup();
			cg.initDisplay(list.get(i));
			jp_chat.add(cg);
		}

		this.add("North", jp_search);
		this.add("Center", jsp);
	}

}