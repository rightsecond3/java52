package com.helpme4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * 친구목록 전체 뷰
 */
public class FriendView extends JPanel implements ActionListener {
	/////////////// 생성부
	/////////////////// 위쪽 검색창///////////////////////////
	FriendGroupList fgl = null;
	Login login = null;
	JPanel jp_search = new JPanel();
	AddFriend af = new AddFriend(login);
	JButton jbtn_search = new JButton() {
		@Override
		public void setBorder(Border border) {
		}
	};
	JButton jbtn_friend = new JButton() {
		@Override
		public void setBorder(Border border) {
		}
	};
	JButton jbtn_Group = new JButton() {
		@Override
		public void setBorder(Border border) {
		}
	};
	JTextField jtf_search = new JTextField(35) {
		@Override
		public void setBorder(Border border) {
		}
	};
	////////////////버튼 이미지 for문으로 돌리기 위해 배열에 담기
	JButton imgFiles[] = { jbtn_search, jbtn_Group, jbtn_friend };
	String img_1[] = { "search.png", "users-1.png", "plus.png" };
	Shape s = null;
	FriendGroup frl = null;
	///////////////////// 검색창 이미지 경로 파일이름 크기조절
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";

	/////////////// 중간 친구 목록/////////////////////////////////
	JPanel jp_center = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center) {
		@Override
		public void setBorder(Border border) {
		}
	};
	//////////////////////////////////////////////////////
	public FriendView(List<Map<String, Object>> List, String mem_id, Login login) {
		////////////// 검색창 색조절///////////////////////
		this.login = login;
		jbtn_friend.addActionListener(this);
		jbtn_Group.addActionListener(this);
		jtf_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					FriendView.this.friendSearch();
				}
			}
		});
		jp_search.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jtf_search.setBackground(new Color(220, 220, 220));
		//////////////////버튼에 이미지 사이즈 조절하고 다양한 셋팅을 통일하기 위한 for문
		for (int i = 0; i < img_1.length; i++) {
			ImageIcon img = new ImageIcon(imgPath + img_1[i]);
			Image originImg = img.getImage();
			Image changedImg = originImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			imgFiles[i].setIcon(new ImageIcon(changedImg));
			imgFiles[i].setBorderPainted(false);
			imgFiles[i].setFocusPainted(false);
			imgFiles[i].setContentAreaFilled(false);
		}
		jp_search.add(jtf_search);
		jp_search.add(jbtn_Group);
		jp_search.add(jbtn_friend);
		jp_search.add(jbtn_search);
		jbtn_search.addActionListener(this);
		///////////// groupLayout 넣기///////////////////
		this.setLayout(new BorderLayout());
		GridLayout gr = new GridLayout();
		gr.setRows(10);
		jp_center.setLayout(gr);
		List<Map<String, Object>> tList = new Vector<>();
		tList = List;
		for (int i = 0; i < tList.size(); i++) {
			frl = new FriendGroup(mem_id, login);
			frl.initDisplay(tList.get(i));
			jp_center.add(frl);
		}
		this.add("North", jp_search);
		this.add("Center", jsp);
	}

	public void addFriend() {
		af = new AddFriend(login);
		af.setVisible(true);
	}
	// 내 아이디랑 내가 검색한 닉네임 일부분을 보내기
	public void friendSearch() {
		//검색창에서 텍스트 뽑기
		String your_nick = jtf_search.getText();
		try {
			login.oos.writeObject(Protocol.FRIEND_SEARCH 
							+ Protocol.seperator + login.mem_id 
							+ Protocol.seperator + your_nick);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_friend) {/////////////친구 추가 하기 위해 친구 검색하는 다이얼로그 띄우기
			addFriend();
		} else if (obj.equals(jbtn_search)) {////////검색버튼
			this.friendSearch();
		} else if (obj.equals(jbtn_Group)) {///////////단톡방 만들기 위해 친구 목록 다이얼로그 띄우기위해 서버에 요청하기
			try {
				login.oos.writeObject(
						Protocol.FRIEND_LIST_GROUP + Protocol.seperator + login.mem_id);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}