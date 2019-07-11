package com.helpme3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ChatListView extends JPanel {
	///선언부
	//* 검색
	JPanel jp_search = new JPanel();
	JButton jbtn_search = new JButton("검색");
	//텍스트필드의 외부 보더 검정색 제거
	JTextField jtf_search = new JTextField(35) {
		public void setBorder(Border border) {}
	};
	//* 채팅목록
	JPanel jp_chat = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_chat) {
		public void setBorder(Border border) {}
	};
	ChatGroup cg = null;
	JPopupMenu jpm = new JPopupMenu();
	JMenuItem jmi_change = new JMenuItem("채팅방명 변경");
	JMenuItem jmi_exit = new JMenuItem("나가기");
	//테스트
	List<Map<String, Object>> list = null;
	Map<String, Object> map = null;
	List<JPanel> cList = null;
	//
	public ChatListView() {
		jp_search.setBackground(Color.GRAY);
		jp_search.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_search.add(jtf_search);
		jp_search.add(jbtn_search);
		//Popup 추가
		jpm.add(jmi_change);
		jpm.add(jmi_exit);
		//* GroupLayout 넣기
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		ChatDao cDao = new ChatDao();
		list = cDao.getChatMap();
		gr.setRows(10);
		jp_chat.setLayout(gr);
		//List<> member = A

		cList = new Vector<>();
		for (int i=0;i<list.size();i++) {
			cg = new ChatGroup();
			//cg = new ChatGroup(A[i]);
			map = list.get(i);
			cg.jl_img.setText(map.get("clist_img").toString());
			cg.jl_msg.setText(map.get("clog_contents").toString());
			cg.jl_name.setText(map.get("clist_name").toString());
			cg.jl_time.setText(map.get("clog_time").toString());
			jp_chat.add(cg);
			cList.add(cg.jp_second);
		}
		for(JPanel jp : cList) {
			jp.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					super.mousePressed(e);
					if(e.isMetaDown()) {
						jpm.show(jp, e.getX(), e.getY());
						jmi_change.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								String msg = JOptionPane.showInputDialog("변경할 채팅방 명을 입력하세요.");
								//////////////clist_code를 넘겨 줘야한다.
							}
						});
					}
				}
			});
		}
		this.add("North", jp_search);
		this.add("Center", jsp);
	}

}