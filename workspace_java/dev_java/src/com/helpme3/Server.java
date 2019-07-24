package com.helpme3;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server extends JFrame implements Runnable {
	ServerSocket sSocket = null;
	Socket cSocket = null;
	ServerThread st = null;
	// 전체 사용자 스레드
	List<ServerThread> globalList = new Vector<ServerThread>();
	// 전체 방 리스트 넣어주는거
	List<VOChatList> chatList = new Vector<VOChatList>();
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	boolean isStop = false;

	// *** 생성자
	public Server() {
	}

	// ** 화면 처리부
	public void initDisplay() {
		jta_log.setEditable(false);
		jta_log.getCaret().setSelectionVisible(true);
		jta_log.setCaretColor(Color.white);
		jta_log.getCaret().setBlinkRate(300);
		jta_log.getCaret().setVisible(true);
		jta_log.setForeground(Color.white);
		jta_log.setBackground(Color.black);
		// 창 닫힐 때 자원 반납
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				try {
					DaoServer sDao = new DaoServer();
					sDao.serverClosing();
					isStop = true;
					if(sSocket!=null) sSocket.close();
					System.exit(0);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		this.add(jsp_log);
		this.setTitle("서버 측 로그 출력창");
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void run() {
		CtrlServer sCtrl = new CtrlServer();
		chatList = sCtrl.send("getclist"); //List<VO> 
		for(int i=0;i<chatList.size();i++) {
			VOChatList vo = chatList.get(i);
			System.out.println(i+"번째 "+vo.getClist_code()+"\n");
		}
		try {
			sSocket = new ServerSocket(5050);
			jta_log.append("Microsoft Windows [Version 10.0.17763.615]"+"\n");
			jta_log.append("(c) 2018 Microsoft Corporation. All rights reserved."+"\n");
	        jta_log.append("\n");
	        jta_log.append("C:\\Server>"+ "\n");
	        jta_log.setCaretPosition(jta_log.getDocument().getLength());
			while (!isStop) {
				cSocket = sSocket.accept();
				jta_log.append(cSocket.toString() + "\n");
				st = new ServerThread(this);
				st.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//*메인 메소드
	public static void main(String[] args) {
		Server server = new Server();
		server.initDisplay();
		new Thread(server).start();//내 안의 run 메소드 호출
	}
}
