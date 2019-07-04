package com.helpme2;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class Login_1 extends JFrame implements ActionListener{
	////선언부
	String imgPath="C:\\workspace_java\\dev_java\\src\\images\\";
	ImageIcon ig = new ImageIcon(imgPath+"main.PNG");
	//폰트 추가하기
	Font font = new Font("휴먼매직체",Font.PLAIN,25);
	//아이디와 패스워드 라벨 추가하기
	JTextField jtf_id = new JTextField("test");
	JPasswordField jpf_pw = new JPasswordField("123");
	JButton jbtn_login = new JButton(new ImageIcon(imgPath+"login.png"));
	JButton jbtn_join = new JButton(new ImageIcon(imgPath+"confirm.png"));
	String nickName = null;//전역변수만이 다른 클래스에서 재사용됨.
	TalkClientVer2_1 tc2 = null;
	
	
	///*** 생성자 ***///
	public Login_1() {}
	
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
		String mem_id = jtf_id.getText();
		String mem_pw = jpf_pw.getText();
		if (mem_id==null && mem_id.length()==0) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
			return;
		}
		else if (mem_pw==null && mem_pw.length()==0) {
			JOptionPane.showMessageDialog(this, "비번을 입력하세요.");
			return;
			
		}
		ChatDao_1 cDao = new ChatDao_1();
		nickName = cDao.login(mem_id, mem_pw);
		if ("실패".equals(nickName)) {//실패일 경우
			JOptionPane.showMessageDialog(this, "아이디와 비번을 확인하세요.");
			return;
		}
		else {//성공의 경우
			JOptionPane.showMessageDialog(this, nickName+"님의 접속을 환영합니다.");
			this.setVisible(false);//메모리상에는 상주하고 있음.
			jtf_id.setText("");
			jpf_pw.setText("");
			//TalkClientVer2
			tc2 = new TalkClientVer2_1(this);
		}
	}
	//// **** 이벤트 처리부 ****////
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_login) {
			login();
		} else if(obj==jbtn_join) {
			
		}
	}
	/// 메인메소드 ///
	public static void main(String[] args) {
		Login_1 login = new Login_1();
		login.initDisplay();
	}


}



