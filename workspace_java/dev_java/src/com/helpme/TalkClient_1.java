package com.helpme;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
//클라이언트 측에서는 Runnable하지 않았다. - 단일스레드이다.
//why? - 경합,선택에 따른 지속적인 서비스


public class TalkClient_1 extends JFrame implements ActionListener{
	///// 전역 변수 선언 부 /////
	JPanel jp_first = new JPanel();
	JTextField jtf_msg = new JTextField();
	/*
	 * JTextPane에 스타일을 적용하기 위해서는 스타일을 지원하는 클래스를 추가 매핑해야함
	 * why - 문자도 그리는 개념으로 이해해야 하므로 글꼴을 변경하거나 글 크기를 변경하려면 필요
	 */
	StyledDocument sd_display = 
			new DefaultStyledDocument();
	JTextPane jtp_display = new JTextPane(sd_display);
	JScrollPane jsp_display = new JScrollPane(jtp_display
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수평스크롤X, 수직스크롤O
	
	JPanel jp_second = new JPanel();
	String cols[] = { "닉네임" };
	String data[][] = new String[0][1];
	DefaultTableModel dtm_name = new DefaultTableModel(data, cols); //json
	JTable jtb_name = new JTable(dtm_name); //datagrid
	JScrollPane jsp_name = new JScrollPane(jtb_name
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JPanel jp_second_south = new JPanel();
	JButton jbtn_whisper = new JButton("일대일 채팅");
	JButton jbtn_change = new JButton("대화명 변경");
	JButton jbtn_exit = new JButton("종료");
	JButton jbtn_icon = new JButton("이모티콘");
	
	String nickName = null;
	String ip = "192.168.0.211";
	int port = 3333;
	//소켓 선언 - (서버 접속 시도 - 객체를 손에 쥐면 oos와 ois생성)
	Socket mySocket = null;
	//말하기 - actionPerformed - 내 안에서 처리하기
	ObjectOutputStream oos = null;
	//듣기 - run() 처리 - 다른 클래스(Thread)에서 처리하기
	ObjectInputStream ois = null;
	//이모티콘 객체 생성 추가
	ImoticonMessage_1 imo = new ImoticonMessage_1(this);
	//Wisper객체 생성
	WisperView_1 wv = null;
	 
	
	///*** 생성자 ***///
	public TalkClient_1() {
		nickName = JOptionPane.showInputDialog("대화명을 입력하세요.");
		initDisplay();
		try {
			//클래스 사이에는 의존관계 존재 - Socket생성 먼저 그 소켓을 사용하여 oos를 생성함.
			mySocket = new Socket(ip, port);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			//서버에 내가 로그인 했음을 알림 - 말하기
			oos.writeObject(Protocol_1.ROOM_IN
					+Protocol_1.seperator+nickName);
			TalkClientThread_1 tct = new TalkClientThread_1(this);
			tct.start();//run메소드 호출 - 콜백함수
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//** 화면 구성부 **//
	public void initDisplay() {
		//이벤트 처리부
		jbtn_exit.addActionListener(this);
		jbtn_icon.addActionListener(this);
		jtf_msg.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		//레이아웃 설정
		jp_first.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(2,2));
		this.setLayout(new GridLayout(1,2));
		//컴포넌트 붙혀주기
		jp_second_south.add(jbtn_icon);
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_exit);
		
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jtf_msg);
		
		jp_second.add("Center",jsp_name);
		jp_second.add("South", jp_second_south);

		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName+"님의 대화창");
		this.setSize(700,1000);
		this.setVisible(true);
	}
	public void exitChat() {
		
	}
	//** 메세지와 이모티콘 메소드 **//
	public void message_process(String msg, String imgChoice) {
		//이모티콘 메시지 전송
		if(imgChoice!=null) {
			msg="이모티콘";
			try {
				oos.writeObject(Protocol_1.MESSAGE
						+Protocol_1.seperator+nickName
						+Protocol_1.seperator+msg
						+Protocol_1.seperator+imgChoice);//선택한 이모티콘 정보 넘김
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//텍스트 메시지 전송
		else {
			try {
				oos.writeObject(Protocol_1.MESSAGE
						+Protocol_1.seperator+nickName
						+Protocol_1.seperator+msg
						+Protocol_1.seperator+"default");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//** 일대일 채팅 메소드 **//
	public void whisper_process(String msg, int index) {
		try {
			oos.writeObject(Protocol_1.WHISPER
					+Protocol_1.seperator+nickName
					+Protocol_1.seperator+msg
					+Protocol_1.seperator+index);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//** 종료 메소드 **//
	public void exit_process() {
		try {
			oos.writeObject(Protocol_1.ROOM_OUT
					+Protocol_1.seperator+nickName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	///*** 메인 메소드 ***///
	public static void main(String[] args) {
		TalkClient_1 tc = new TalkClient_1();
	}
	
	//** 이벤트 처리부 **//
	//말하기 인가? 아님 듣기 인가? - !말하기!
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//텍스트필드
		if(obj==jtf_msg) {
			message_process(msg, null);
			jtf_msg.setText("");
		// 일대일 채팅 버튼
		} else if(obj==jbtn_whisper) {
			int index = jtb_name.getSelectedRow();
			if(index<0) {
				JOptionPane.showMessageDialog(this, "채팅할 상대를 고르세요.");
				return;
			} else {
				wv = new WisperView_1(this);
				whisper_process(msg, index);
			}
		//이모티콘	
		} else if(obj==jbtn_icon) {
			imo.setVisible(true);
		} else if(obj==jbtn_exit) {
			exit_process();
			this.dispose();
		}
	}

}
