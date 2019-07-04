package com.helpme2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ImoticonMessage_1 extends JDialog implements ActionListener{
	TalkClient_1 tc = null;
	JPanel jp_imo = new JPanel();
	JButton jbtn_imo0 = new JButton();
	JButton jbtn_imo1 = new JButton();
	JButton jbtn_imo2 = new JButton();
	JButton jbtn_imo3 = new JButton();
	JButton jbtn_imo4 = new JButton();
	String imgFiles[] = {
							"lion11.png","lion22.png"
							,"lion33.png","lion44.png","lion55.png"
						};
	JButton imgButton[] = {
							jbtn_imo0,jbtn_imo1
							,jbtn_imo2,jbtn_imo3,jbtn_imo4
							};
	ImageIcon img[] = new ImageIcon[5];
	//이미지 정보를 담을 변수
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	//이미지 정보 담을 변수
	String imgChoice = "default";
	
	///*** 생성자 ***///
	public ImoticonMessage_1() {}
	public ImoticonMessage_1(TalkClient_1 tc) {
		this.tc = tc;
		initDisplay();
	}
	//** 화면 처리부 **//
	public void initDisplay() {
		jbtn_imo0.addActionListener(this);
		jbtn_imo1.addActionListener(this);
		jbtn_imo2.addActionListener(this);
		jbtn_imo3.addActionListener(this);
		jbtn_imo4.addActionListener(this);
		this.setLayout(null);
		this.setBounds(new Rectangle(3,3,482,142));
		jp_imo.setBackground(Color.white);
		jp_imo.setBorder(BorderFactory.createEtchedBorder());
		jp_imo.setBounds(new Rectangle(6,6,480,140));
		jp_imo.setLayout(new GridLayout(1,5));
		for (int i = 0; i < img.length; i++) {
			img[i] = new ImageIcon(imgPath+imgFiles[i]);
			imgButton[i].setIcon(img[i]);
			imgButton[i].setBorderPainted(false);
			imgButton[i].setFocusPainted(false);
			imgButton[i].setContentAreaFilled(false);
		}
		jp_imo.add(jbtn_imo0);
		jp_imo.add(jbtn_imo1);
		jp_imo.add(jbtn_imo2);
		jp_imo.add(jbtn_imo3);
		jp_imo.add(jbtn_imo4);
		this.getContentPane().setBackground(new Color(125,144,177));
		this.getContentPane().add(jp_imo);
		this.setLocation(50, 50); //창의 오픈 위치 조절
		this.setResizable(false); //창크기조절불가
		this.setSize(510, 205);
		this.setVisible(false);
	}

	// 이벤트 처리부 //
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_imo0) {
			imgChoice = "lion11.png";
			tc.message_process(null, imgChoice);
			this.setVisible(false);
			imgChoice = "default";
		}
		else if(obj==jbtn_imo1) {
			imgChoice = "lion22.png";
			tc.message_process(null, imgChoice);
			this.setVisible(false);
			imgChoice = "default";
		}
		else if(obj==jbtn_imo2) {
			imgChoice = "lion33.png";
			tc.message_process(null, imgChoice);
			this.setVisible(false);
			imgChoice = "default";
		}
		else if(obj==jbtn_imo3) {
			imgChoice = "lion44.png";
			tc.message_process(null, imgChoice);
			this.setVisible(false);
			imgChoice = "default";
		}
		else if(obj==jbtn_imo4) {
			imgChoice = "lion55.png";
			tc.message_process(null, imgChoice);
			this.setVisible(false);
			imgChoice = "default";
		}
	}
	// 메인 메소드 //
	public static void main(String[] args) {
		ImoticonMessage_1 im = new ImoticonMessage_1();
	}
}
