package com.helpme5;

import java.awt.Font;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * 로그인
 */
public class Login extends JFrame implements ActionListener {
	////선언부
	String imgPath="C:\\workspace_java\\dev_java\\src\\images\\";
	ImageIcon ig = new ImageIcon(imgPath+"main.PNG");
	//폰트 추가하기
	Font font = new Font("휴먼매직체",Font.PLAIN,25);
	//아이디와 패스워드 라벨 추가하기
	JTextField jtf_id = new JTextField("melon");
	JPasswordField jpf_pw = new JPasswordField("3456");
	JButton jbtn_login = new JButton(new ImageIcon(imgPath+"login.png"));
	JButton jbtn_join = new JButton(new ImageIcon(imgPath+"confirm.png"));
	
	String mem_id = null;//전역변수만이 다른 클래스에서 재사용됨.
	String mem_pw = null;
	
	MainView mv = null;
	
	ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
	Socket mySocket = null;
	String ip = "192.168.0.211";
	int port = 5050;
	ClientThread ct = null;
	
	///*** 생성자 ***///
	public Login() {}
	
	//** 내부클래스 추가하기 - JPanel이미지를 입히기 ***///
	class myPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	//** 화면 처리부 **//
	public void initDisplay() {
		//기존 패널을 지우기 - 잔상의 오류 방지
		setContentPane(new myPanel());
		//이벤트 처리부
		jbtn_join.addActionListener(this);
		jbtn_login.addActionListener(this);
		//컴포넌트 붙히기
		this.setLayout(null);
		jtf_id.setBounds(50, 200, 250, 40);
		jpf_pw.setBounds(50, 240, 250, 40);
		jbtn_join.setBounds(180, 300, 120, 40);
		jbtn_join.setBorderPainted(false);
		jbtn_join.setContentAreaFilled(false);
		jbtn_login.setBounds(50, 300, 120, 40);
		jbtn_login.setBorderPainted(false);
		jbtn_login.setContentAreaFilled(false);
		this.add(jbtn_join);
		this.add(jbtn_login);
		this.add(jtf_id);
		this.add(jpf_pw);
		//창이 닫힐 때 자원반납하기
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(366, 600);
		this.setVisible(true);
		this.setLocation(800, 250);
	}
	//** 로그인 처리 메소드
	public void login() {
		//사용자가 입력한 아이디와 비밀번호 가져오기
		mem_id = jtf_id.getText();
		mem_pw = jpf_pw.getText();
		
		if (mem_id==null || mem_id.length()==0) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
			return;
		}
		else if (mem_pw==null || mem_pw.length()==0) {
			JOptionPane.showMessageDialog(this, "비번을 입력하세요.");
			return;
		}
		
		connect_process();
	}
	//** 회원가입 처리 메소드
    public void join() {
		try {
			mySocket = new Socket(ip,port);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			MemberJoin mj = new MemberJoin(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//서버로 접속하는 메소드
	public void connect_process() {
		//통신은 지연이 발생할 수 있으므로 항상 예외처리 할 것.
		try {
			mySocket = new Socket(ip,port);
			oos = new ObjectOutputStream(mySocket.getOutputStream());
			ois = new ObjectInputStream(mySocket.getInputStream());
			oos.writeObject(Protocol.LOGIN
					       +Protocol.seperator+mem_id
					       +Protocol.seperator+mem_pw
					       );
			ct = new ClientThread(this);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//// **** 이벤트 처리부 ****////
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_login) {
			login();
		} else if(obj==jbtn_join) {
			join();
		}
	}
	/// 메인메소드 ///
	public static void main(String[] args) {
		Login login = new Login();
		login.initDisplay();
	}
}
