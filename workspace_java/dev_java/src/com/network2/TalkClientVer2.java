package com.network2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
/*
 * 현재 화면 처리 안되어 있으므로 로그인 성공되어도 화면 출력안됨..
 * 그러나 다이얼로그 화면은 확인 가능함.
 */
public class TalkClientVer2 extends JFrame {
	/////선언부
	Login login = null;
	JTabbedPane tp = new JTabbedPane();
	WaitRoom wr = new WaitRoom(this);
	MessageRoom mr = new MessageRoom(this);
	Socket mySocket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	int port = 3333;
	String ip = "192.168.0.211";
	String nickName = null;
	
	//* 생성자 *//
	public TalkClientVer2() {}
	//생성자를 통해서 앞 화면에서 처리된 결과인 nickName을 사용하려면 원본의 주소번지가 필요함.
	public TalkClientVer2(Login login) {
		this.login = login;
		this.nickName = login.nickName;//오라클 서버에서 가져온 정보(로그인)
		initDisplay();
		connect_process();//통신을 위한 작업-통신은 항상 지연이 발생할 수 있으므로 화면 다음으로 처리
	}
	
	//*** 화면 처리부 ***//
	public void initDisplay() {
		this.getContentPane().setLayout(null);
		tp.addTab("대기실", wr);
		tp.addTab("단톡방", mr);
		tp.setBounds(5, 4, 627, 530);
		this.getContentPane().add(tp, null);
		this.setSize(655, 585);
		this.setVisible(true);
	}
	
	//** 
	public void connect_process() {
		this.setTitle(nickName+"님의 대화창");
		try {
			mySocket = new Socket(ip,port);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			oos.writeObject(Protocol.WAIT
					+Protocol.seperator+nickName
					+Protocol.seperator+"대기"
					);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
