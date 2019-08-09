package com.helpme5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileClient extends JFrame {
	OutputStream out = null;
	FileInputStream fin = null;
	Socket mySocket = null;
	String ip = "192.168.0.211";
	int port = 7000;
	FileClientThread fct = null;
	
	JFileChooser jfc = new JFileChooser();
	JButton jbtn_choose = new JButton("선택");
	JButton jbtn_send = new JButton("전송");
	
	public FileClient() {
		// 소켓
		try {
			mySocket = new Socket(ip, port);

			// 파일 받을때 스레드 돌려주면 되는거아님?
			fct = new FileClientThread(this);
			fct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void initDisplay() {
		//이벤트
		jbtn_choose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ret = jfc.showOpenDialog(FileClient.this);
				if(ret == JFileChooser.APPROVE_OPTION) {
					try {
						File myFile = jfc.getSelectedFile();
						String filename = myFile.getAbsolutePath();
						System.out.println(filename);
						out = mySocket.getOutputStream();
						DataOutputStream dout = new DataOutputStream(out);
						fin = new FileInputStream(new File(filename));
						
						byte[] buffer = new byte[1024];
						int len=0;
						int data=0;
						
						while((len = fin.read(buffer))>0) {
							data++;
						}
						
						int datas = data;
						
						fin.close();
						fin = new FileInputStream(filename);
						dout.writeInt(data);
						String name = myFile.getName();
						dout.writeUTF(name);
						
						len = 0;
						
						for(;data>0;data--) {
							len = fin.read(buffer);
							out.write(buffer,0,len);
						}
						System.out.println("약"+datas+"kbyte");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});

		// 화면
		this.setLayout(new GridLayout(1,2));
		this.add(jbtn_choose);
		this.add(jbtn_send);
		this.setVisible(true);
		this.setSize(300, 150);
		this.setTitle("파일전송테스트");
	}
	public static void main(String[] args) {
		FileClient fc = new FileClient();
		fc.initDisplay();
	}
}
