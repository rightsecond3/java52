package com.helpme;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TalkServer_1 extends JFrame implements Runnable {
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	
	//동시에 여러 접속자에 대한 소켓 정보를 안정적으로 수집하기 위해 필요.
	ServerSocket server = null;
	//서버소켓에 접속해온 소켓 정보를 일반 소켓이 받음.
	Socket client = null;
	//사용자가 접속을 해오면 접속해 온 사용자를 스레드로 관리함.
	TalkServerThread_1 tst = null;
	List<TalkServerThread_1> chatList = null;
	
	///*** 생성자 ***///
	public TalkServer_1() {}
	//** 화면 처리 부 **//
	public void initDisplay() {
		//윈도우창 닫을 때 사용한 자원 반납
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					if(server!=null) server.close();
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		this.add(jta_log);
		this.setTitle("서버측 로그 출력창");
		this.setSize(600, 500);
		this.setVisible(true);
	}
	@Override
	public void run() {
		/*
		 * Vector안에 있는 스레드는 누구에 대한 정보를 갖고있는가? - 서베에 입장한 사용자에 대한 정보
		 * 이 스레드는 언제 생성하면 되나? - 서버에 입장이 결정되면 즉시
		 * 이 스레드는 언제 chatList에 담으면 되나? - 서버에 사용자에 대한 대화명이 접수 될 때
		 * 스레드의 인스턴스 변수를 활용 하여 서버측의 어떤 변수를 접근해야 하나? - 일반 소켓과 TalkServer의 주소번지
		 * 서버에서 듣기는 어디서 이루어지면 되는가? - run()안에서
		 * 서버에서 말하기는 언제 처리하면 되는가? - run()안에서 듣기가 왼료되고 즉시 내보내야 함.
		 */
		chatList = new Vector<TalkServerThread_1>();
		boolean isStop = false;
		try {
			//서버에서 포트를 결정하고 서버를 열어줌.
			server = new ServerSocket(3333);
			while (!isStop) {
				//사용자 측에서 서버에 ip와 port번호를 가지고 인스턴스화를 하면
				//서버소켓은 사용자에 대한 정보를 가지게 됨.
				//그 정보를 일반소켓에 넘겨서 oos와 ois를 생성하고 사용하게 됨.
				client = server.accept();
				//Cilent 정보 출력하기
				jta_log.append(client.toString()+"\n");
				tst = new TalkServerThread_1(this);
				//사용자의 정보를 관리할 스레드 기동
				tst.start();//TalkServerThread의 스레드호출
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TalkServer_1	ts = new TalkServer_1();
		ts.initDisplay();
		new Thread(ts).start();// 내 안의 run()메소드 호출
	}

}
