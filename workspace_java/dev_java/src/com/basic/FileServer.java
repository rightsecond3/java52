package com.basic;

import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileServer extends JFrame implements Runnable {
	ServerSocket sSocket = null;
	Socket cSocket = null;
	FileServerThread fst = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);
	boolean isStop = false;
	
	public void initDisplay() {
		jta_log.setEditable(false);
		jta_log.getCaret().setSelectionVisible(true);
		jta_log.setCaretColor(Color.white);
		jta_log.getCaret().setBlinkRate(300);
		jta_log.getCaret().setVisible(true);
		jta_log.setForeground(Color.white);
		jta_log.setBackground(Color.black);
		jta_log.append("Microsoft Windows [Version 10.0.17763.615]"+"\n");
		jta_log.append("(c) 2018 Microsoft Corporation. All rights reserved."+"\n");
        jta_log.append("\n");
        jta_log.append("C:\\Server>"+ "\n");
		this.add(jsp_log);
		this.setTitle("서버 측 로그 출력창");
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void run() {
		try {
			sSocket = new ServerSocket(7000);
			jta_log.setCaretPosition(jta_log.getDocument().getLength());
			while (!isStop) {
				cSocket = sSocket.accept();
				jta_log.append(cSocket.toString() + "\n");
				fst = new FileServerThread(this);
				fst.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		FileServer fs = new FileServer();
		fs.initDisplay();
		new Thread(fs).start();
	}
}
