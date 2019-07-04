package com.helpme2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
//친애하는 박상범 조원이 고생한 뷰
public class WisperView_1 extends JFrame implements ActionListener{
	///// 전역 변수 선언 부 /////
	JTextField jtf_msg = new JTextField();
	StyledDocument sd_display = 
			new DefaultStyledDocument();
	JTextPane jtp_display = new JTextPane(sd_display);
	JScrollPane jsp_display = new JScrollPane(jtp_display
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수평스크롤X, 수직스크롤O
	
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_exit = new JButton("종료");
	JButton jbtn_icon = new JButton("이모티콘");
	
	TalkClient_1 tc1 = null;
	
	///*** 생성자 ***///
	public WisperView_1() {}
	public WisperView_1(TalkClient_1 tc1) {
		this.tc1 = tc1;
	}
	
	//** 화면 구성부 **//
	public void initDisplay() {
		//이벤트 처리부
		jbtn_exit.addActionListener(this);
		jbtn_icon.addActionListener(this);
		jtf_msg.addActionListener(this);
		//레이아웃 설정
		jp_center.setLayout(new BorderLayout());
		jp_south.setLayout(new GridLayout(1,2));
		jp_south.add(jbtn_exit);
		jp_south.add(jbtn_icon);
		jp_center.add("Center", jsp_display);
		jp_center.add("South",jtf_msg);
		this.add("Center", jp_center);
		this.add("South", jp_south);
		
		this.setSize(500,700);
		this.setVisible(true);
	}
	///*** 이벤트 처리부 ***///
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	///*** 메인메소드 ***///
	public static void main(String args[]) {
		WisperView_1 wv = new WisperView_1();
		wv.initDisplay();
	}
}
