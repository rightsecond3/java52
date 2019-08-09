package com.helpme5;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
////////////////////친구 추가하기 위해 띄우는 다이얼로그 여긴 이름만 입력해서 존재여부  중복 확인후 추가함
public class AddFriend extends JDialog implements ActionListener {
	/////////////////생성자
	JPanel jp_center = new JPanel();
	Login login = null;
	JTextField jtf_search = new JTextField(20) {//////////검색창
		@Override
		public void setBorder(Border border) {
		}
	};
	JButton jbtn_search = new JButton() {//////////버튼
		@Override
		public void setBorder(Border border) {
		}
	};
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
/////////////생성자
	public AddFriend(Login login) {
		this.login = login;
		initDisplay();
	}
////////////창
	public void initDisplay() {
		jbtn_search.addActionListener(this);
		ImageIcon img = new ImageIcon(imgPath + "search.png");
		Image originImg = img.getImage();
		Image changedImg = originImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		jbtn_search.setIcon(new ImageIcon(changedImg));
		jbtn_search.setBorderPainted(false);
		jbtn_search.setFocusPainted(false);
		jbtn_search.setContentAreaFilled(false);
		jp_center.setBackground(new Color(220, 220, 220));
		jp_center.add(jtf_search);
		jp_center.add(jbtn_search);
		this.add(jp_center);
		this.pack();
		this.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_search) {/////////////버튼 누르면 내 아이디랑 검색한 아이디를 서버에 보냄
			String friend_id = jtf_search.getText();
			String mem_id = login.mem_id;
			try {
				login.oos
						.writeObject(Protocol.FRIEND_ADD + Protocol.seperator + mem_id + Protocol.seperator + friend_id);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
