package com.helpme5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * 채팅목록에 붙히는 뷰(검색)
 */
public class ChatListView extends JPanel implements ActionListener {
	/// 선언부
	Login login = null;
	String login_id = null;
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
	public ChatListView(List<Map<String, Object>> list, String mem_id, Login login) {
		this.login = login;
		this.login_id = mem_id;
		jbtn_search.addActionListener(this); // 이벤트 처리
		jtf_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					ChatListView.this.roomSearch();
				}
			}
		});
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
		gr.setRows(10);
		jp_chat.setLayout(gr);
		List<Map<String,Object>> tList = new Vector<>();
		tList = list;
		System.out.println("chat"+list.size());
		// GroupLayout쪽에 해당하는 이벤트와 라벨을 붙히기 위해 list를 보내줌
		for (int i = 0; i < tList.size(); i++) {
			cg = new ChatListGroup(mem_id,login);
			cg.initDisplay(tList.get(i));
			jp_chat.add(cg);
		}

		this.add("North", jp_search);
		this.add("Center", jsp);
	}
	// 키워드 입력했을 때 이벤트 처리
	public void roomSearch() {
		String keyword = jtf_search.getText();
		try {
			login.oos.writeObject(
					Protocol.ROOM_SEARCH 
					+ Protocol.seperator + login_id 
					+ Protocol.seperator + keyword);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jbtn_search) {
			this.roomSearch();
		}
	}
	
}