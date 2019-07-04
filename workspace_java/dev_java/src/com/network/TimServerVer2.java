package com.network;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimServerVer2 extends JFrame implements Runnable {
	ServerSocket sSocket = null;// 동시에 여러사람 정보를 가질 수 있다.
	// 한번에 한사람의 정보만 가지고 있다.(여러 클라이언트를 받아줘야한다-경합 : Thread의 필요성 대두)
	Socket socket = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	List<ServerThread> threadList = null;
	ServerThread sThread = null;

	// ** 화면부 **//
	public void initDisplay() {
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		this.setTitle("서버측 로그 출력화면");
		this.add("Center", jsp_log);
		this.setSize(500, 300);
		this.setVisible(true);
	}

	//접속 순서를 정해주는 스레드
	@Override
	public void run() {
		//접속한 클라이언트의 정보를 담을 Vector추가(멀티스레드안전)
		threadList = new Vector<ServerThread>();
		try {
			sSocket = new ServerSocket(5000);
			while (true) {
				jta_log.append("접속을 기다립니다....\n");
				socket = sSocket.accept();
				System.out.println
				("접속한 클라이언트측 정보출력하기==>"+socket.getInetAddress());
				jta_log.append(socket+"에 연결되었습니다."+"\n");
				sThread = new ServerThread(this);
				sThread.start();
			}//////////end of outter while
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		TimServerVer2 ts2 = new TimServerVer2();
		ts2.initDisplay();
		Thread th = new Thread(ts2);
		th.start();//run메소드가 호출된다.
	}

}
