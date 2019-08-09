package com.helpme5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.google.gson.Gson;

/*
 * 채팅창 뷰
 */
public class ChatView extends JFrame implements ActionListener {
	//// 선언부
	ChatMemberList cml = null;
	ChatFriendAdd cfa = null;
	Login login = null;
	JPanel jp_north = new JPanel();
	JButton jbtn_friend = new JButton();
	JButton jbtn_add = new JButton();
	JButton jbtn_exit = new JButton();
	JButton jbtn_imo = new JButton();
	// 파일 버튼
	JButton jbtn_file = new JButton();
	JButton jbtn_img = new JButton();
	JButton jbtn_send = new JButton();
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	String img[] = { "user.png", "add-1.png", "exit.png", "star.png", "attachment.png", "picture.png", "forward.png" };
	JButton imgFiles[] = { jbtn_friend, jbtn_add, jbtn_exit, jbtn_imo, jbtn_file, jbtn_img, jbtn_send };
	///////////////////////////이모티콘 넣으려고 선언한거
	StyledDocument sd_center = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_center = new JTextPane(sd_center);
	JScrollPane jsp_center = new JScrollPane(jtp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JPanel jp_south = new JPanel();

	JPanel jp_south_first = new JPanel();
	StyledDocument sd_south = new DefaultStyledDocument(new StyleContext());
	JTextPane jtp_south = new JTextPane(sd_south);

	JScrollPane jsp_south = new JScrollPane(jtp_south, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JPanel jp_south_second = new JPanel();

	ChatLeft cl = null;
	ChatRight cr = null;

	String nickName = null;
	String room_code = null;
	List<String> your_ids = new ArrayList<>();
	// ** 파일 전송을 위한 것들
	OutputStream out = null;
	FileInputStream fin = null;
	Socket mySocket = null;
	String ip = "192.168.0.211";
	int port = 7000;
	FileClientThread fct = null;
	JFileChooser jfc = new JFileChooser();

	//// 생성자
	public ChatView(String room_code, Login login) {
		this.login = login;
		this.room_code = room_code;
		initDisplay();
	}

	//// 엔터 치는 이벤트 처리 메소드
	public void enter(KeyEvent e) {
		if (e.isShiftDown()) {
			if (e.getKeyCode() == 10) {
				try {
					sd_south.insertString(sd_south.getLength(), "\n", null);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getKeyCode() == 10) {
			try {
				String msg = wrapLine();
				if (msg.length() != 0) {
					message_process(msg, null, null, null);
				} else {
					return;
				}
			} catch (Exception ae) {
				ae.printStackTrace();
			}
		}
	}

	//// 화면처리부
	public void initDisplay() {

		// ================= 이벤트 처리=====================//
		// 파일 전송
		jbtn_file.addActionListener(this);
		////////////// 방나가기 버튼 이벤트
		jbtn_exit.addActionListener(this);
		////////////// 친구 추가 버튼 이벤트
		jbtn_add.addActionListener(this);
		////////////// 친구 목록 버튼 이벤트
		jbtn_friend.addActionListener(this);
		////////////// 이모티콘 버튼 이벤트
		jbtn_imo.addActionListener(this);
		////////////// 보내기 버튼 이벤트
		jbtn_send.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ChatView.this.setVisible(false);
			}
		});
		//////////////// 엔터 키 이벤트
		jtp_south.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				enter(e);
			}

			public void keyReleased(KeyEvent e) {

				if (e.isShiftDown()) {
					return;
				} else if (e.getKeyCode() == 10) {
					jtp_south.setText("");
				}
			}
		});

		// 화면 붙히기
		for (int i = 0; i < img.length; i++) {
			ImageIcon img_1 = new ImageIcon(imgPath + img[i]);
			Image originImg = img_1.getImage();
			Image changedImg = originImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			imgFiles[i].setIcon(new ImageIcon(changedImg));
			imgFiles[i].setBorderPainted(false);
			imgFiles[i].setFocusPainted(false);
			imgFiles[i].setContentAreaFilled(false);
			imgFiles[i].setBackground(Color.white);
		}
		jp_north.setBackground(Color.white);
		jp_south_first.setBackground(Color.white);
		jp_south_second.setBackground(Color.white);

		jtp_south.setBorder(BorderFactory.createEmptyBorder());

		// 위쪽패널
		jp_north.setLayout(new GridLayout(1, 3));
		jp_north.add(jbtn_friend);
		jp_north.add(jbtn_add);
		jp_north.add(jbtn_exit);
		jp_north.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// 센터패널
		jtp_center.setDragEnabled(false);
		jtp_center.setEditable(false);
		jtp_center.setBackground(new Color(255, 180, 130));

		// 아래패널
		jp_south.setLayout(new BorderLayout());
		jp_south_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jtp_south.setPreferredSize(new Dimension(260, 50));
		jtp_south.setSize(100, 10);
		jp_south_first.add(jsp_south);
		jp_south_first.add(jbtn_send);
		jp_south_second.add(jbtn_imo);
		jp_south_second.add(jbtn_file);
		jp_south_second.add(jbtn_img);
		jp_south.add("North", jp_south_first);
		jp_south.add("South", jp_south_second);

		// 창이 닫힐 때 자원반납하기
		this.setLayout(new BorderLayout());
		this.add("Center", jsp_center);
		this.add("North", jp_north);
		this.add("South", jp_south);
		this.setSize(370, 600);
		this.setVisible(true);
	}

	// * 개행처리 메소드
	public String wrapLine() {
		// jtp의 Text 값을 가져올 때 필요한 그래픽 객체
		Graphics g = jtp_south.getGraphics();
		// jtp의 글씨를 가져옴
		String getstr = jtp_south.getText();
		// 해당 글씨의 픽셀 값을 가져옴
		int width = g.getFontMetrics().stringWidth(getstr);
		String msg = null;
		if (width < 150) {// 일정 길이 이하일 때는 해당 텍스트의 길이 만큼 메시지 상자를 맞춰줌
			msg = "<html><p style=\"width:" + width + "px\">" + getstr + "</p></html>";
		} else {// 개행처리를 위한 코드
			msg = "<html><p style=\"width:100px\">" + getstr + "</p></html>";
		}
		return msg;
	}

	public void message_process(String msg, String imgChoice,String fileName, String dataSize) {
		DateTimeFormatter dtf_date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dtf_time = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime nowdate = LocalDateTime.now();
		String date = nowdate.format(dtf_date);
		String time = nowdate.format(dtf_time);
		Gson g = new Gson();
		String json = g.toJson(your_ids);
		System.out.println("cvid" + your_ids);
		System.out.println("js" + json);
		// 이모티콘 메시지를 전송
		if ((msg == null || msg.length() == 0) && fileName == null) {
			msg = "이모티콘";
			try {
				login.oos.writeObject(Protocol.MESSAGE 
						+ Protocol.seperator + room_code 
						+ Protocol.seperator + login.mem_id
						+ Protocol.seperator + date 
						+ Protocol.seperator + time 
						+ Protocol.seperator + msg// 이모티콘
						+ Protocol.seperator + imgChoice// 선택한 이모티콘 정보
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 텍스트 메시지를 전송
		else if(msg != null){
			try {
				login.oos.writeObject(Protocol.MESSAGE 
						+ Protocol.seperator + room_code 
						+ Protocol.seperator + login.mem_id 
						+ Protocol.seperator + date 
						+ Protocol.seperator + time 
						+ Protocol.seperator + msg 
						+ Protocol.seperator + "default"// 선택한 이모티콘 정보
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 파일 
		else if(msg == null && fileName != null) {
			msg = "파일";
			try {
			login.oos.writeObject(Protocol.MESSAGE 
					+ Protocol.seperator + room_code 
					+ Protocol.seperator + login.mem_id 
					+ Protocol.seperator + date 
					+ Protocol.seperator + time 
					+ Protocol.seperator + msg 
					+ Protocol.seperator + "default"// 선택한 이모티콘 정보
					+ Protocol.seperator + fileName
					+ Protocol.seperator + dataSize
					);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//* 파일 전송 프로세스
	public void file_process(String filename, String dataSize) {
		DateTimeFormatter dtf_date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dtf_time = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime nowdate = LocalDateTime.now();
		String date = nowdate.format(dtf_date);
		String time = nowdate.format(dtf_time);
		try {
			login.oos.writeObject(Protocol.FILE
					+ Protocol.seperator + room_code
					+ Protocol.seperator + login.mem_id
					+ Protocol.seperator + date
					+ Protocol.seperator + time
					+ Protocol.seperator + filename
					+ Protocol.seperator + dataSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void exit_process() {
		try {
			login.oos.writeObject(Protocol.ROOM_OUT + Protocol.seperator + room_code + Protocol.seperator + login.mem_id);
			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj == jbtn_send) {
			String msg = wrapLine();
			message_process(msg, null, null, null);
		} else if (obj == jbtn_exit) {
			exit_process();
		} else if (obj == jbtn_imo) {
			Imogi imo = new Imogi(this);
		} else if (obj == jbtn_friend) {
			try {
				login.oos.writeObject(Protocol.ROOM_IN_LIST 
						+ Protocol.seperator + room_code 
						+ Protocol.seperator + login.mem_id);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (obj == jbtn_add) {
			try {
				login.oos.writeObject(Protocol.ROOM_ADD_LIST 
						+ Protocol.seperator + room_code 
						+ Protocol.seperator + login.mem_id);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (obj == jbtn_file) {
			int ret = jfc.showSaveDialog(this);
			if(ret == JFileChooser.APPROVE_OPTION) {
				// 전송할 때 열고 받을때도 꼭 열어라 !!!
				try {
					// 파일을 전송 할 소켓 생성
					mySocket = new Socket(ip, port);
					// 파일 전송 부
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
					String dataSize = datas+"kbps";
					// 파일전송
					this.message_process(null, null, filename, dataSize);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ChatView() {
	}

	public static void main(String[] arg0) {
		ChatView c = new ChatView();
		c.initDisplay();
	}

}