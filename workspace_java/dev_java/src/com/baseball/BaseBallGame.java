package com.baseball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame implements ActionListener{
	//선언부
	//컴터가 채번한 숫자 3개를 담을 배열을 선언하기
	int com[] = new int[3];//현재 3개 방에는 0(Default)이 담겨있다.
	//사용자가 입력한 숫자를 담을 배열도 같이 선언하기
	int my[] = new int[3];
	//jf는 전역 변수 이고 선언 및 초기화 완료
	JFrame    jf           = new JFrame();
	//jp_center속지의 중앙면적 = jta_display
	//jp_center속지의 남쪽면적 = jtf_user
	//jta_display->jp_center속지->JFrame배치
	//Jp_center 속지의 레이아웃을 BdoderLayout설정
	JPanel     jp_center    = new JPanel();
	JTextArea  jta_display  = new JTextArea();  //멀티 로우
	//JScrollBar 위에 JTextArea 얹기
	JScrollPane jsp_display  = new JScrollPane(jta_display
											  ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                                  ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextField jtf_user     = new JTextField(); //한개 로우
	//jp_east속지에 버튼 네개 추가 - new GridLayout(4로우,1컬럼);
	JPanel     jp_east      = new JPanel();
	JButton    jbtn_new     = new JButton("새 게임"); //버튼 추가, 생성자
	JButton    jbtn_dap     = new JButton("정답"); //버튼 추가
	JButton    jbtn_clear   = new JButton("지우기"); //버튼 추가
	JButton    jbtn_exit    = new JButton("나가기"); //버튼 추가
	//새게임을 눌렀을 떄 임의의 숫자를 채번하는 메소드 선언해보자.
	public void ranCom() {
		Random r = new Random();
			com[0] = r.nextInt(10);
		do {
			com[1] = r.nextInt(10);
		}while(com[0]==com[1]); // 조건식이 참이면 반복 수행
		do {
			com[2] = r.nextInt(10);
		}while(com[0]==com[2]||com[1]==com[2]); // 조건식이 거짓일 때 빠져나옴
	}
	//화면처리부
	public void initDisplay() {
		//이벤트 소스와 이벤트처리를 담당하는 클래스를 연결
		jtf_user.addActionListener(this); //this = BaseBallGame -> 외부가 아닌 자기 자신 클래스안에 있다.
		jbtn_new.addActionListener(this); //버튼에 대한 디폴트 정보(좌표, 크기,..)나옴
		jbtn_dap.addActionListener(this); 
		jbtn_clear.addActionListener(this); 
		jbtn_exit.addActionListener(this); 
		//버튼의 배경색과 글자색변경
		jbtn_new.setBackground(new Color(158,9,9));
		jbtn_new.setForeground(new Color(212,212,212));  //setForeground : 폰트 색깔
		jbtn_dap.setBackground(new Color(19,99,57));
		jbtn_dap.setForeground(new Color(212,212,212));
		jbtn_clear.setBackground(new Color(7,84,170));
		jbtn_clear.setForeground(new Color(212,212,212));
		jbtn_exit.setBackground(new Color(54,54,54));
		jbtn_exit.setForeground(new Color(212,212,212));
		jp_center.setBackground(Color.orange);
		jp_east.setBackground(Color.black);
		int width=400;//지역변수 - 메소드 안에 선언했을 때 - 넓이
		int height=500;//지역 변수 - 높이
		String title = "야구숫자게임 - Ver1.0";
		//속지의 레이아웃을 BorderLayout으로 변경, 메세지를 입력할 수 잇는 한줄 짜리 보더를 만듬
		jp_center.setLayout(new BorderLayout());
		//jp_east속지 레이아웃을 GridLayout으로 변경
		jp_east.setLayout(new GridLayout(4,1));
		//jp_center 중앙에 배치함
		jp_center.add("Center",jsp_display);
		jtf_user.setBackground(new Color(255,255,200)); //setBackground 배경 바꿔줌
		jta_display.setBackground(new Color(255,255,255)); //setBackground 배경 바꿔줌
		jp_center.add("South",jtf_user);
		//JFrame 중앙에 jp_center 속지를 붙히고 동쪽에는 jp_east속지 붙이기	
		jf.add("Center",jp_center);
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		jf.add("East",jp_east);
		jf.setTitle(title);
		jf.setSize(width, height);
		jf.setVisible(true);//true : 화면에 띄워줌
	}
	//판정하는 메소드
	/**************************************************************
	 * 
	 * @param user - 사용자가 입력한 숫자를 담을 변수
	 * @return - 사용자가 입력한 숫자와 채번한 숫자를 비교해서 힌트문을 반환
	 *************************************************************/
	public String account(String user) {
		//파라미터로 새로운 숫자를 받아올 떄 마다 볼카운트를 다시 해야 한다.
		//또 사용자가 입력한 값은 사용자가  JTextField에 숫자를 입력한 후 엔터를 쳤을때
		//account("256")을 호출해야 하지 않을까?
		int strike = 0;
		int ball = 0;
		int temp = 0; //문자열 256을 숫자 타입으로 형전환하여 담을 변수 선언
		try {
			temp = Integer.parseInt(user);
		} catch (NumberFormatException e) {
			return "숫자만 입력해라~~~~~~";
		}
		my[0] = temp/100;
		my[1] = (temp%100)/10;
		my[2] = temp%10;
		//사용자가 입력한 숫자가 256문자열로 넘어 오니까... my배열에 다시 담아주어야 한다.
		//insert here - my배열의 초기화진행
		//백의 자리 user/100=2
		//십의 자리 (256%100=)/10=5
		//일의 자리 256%10=6
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				//너가 입력한 숫자가 com안에 있니? 네 - ball
				if(com[i]==my[j]) {
					if(i==j) { //혹시 자리까지 똑같은 거야? 네 strike 아니 ball
						strike++;
					}//////////end of strike
					else {
					ball++;
						}/////end of ball
				}
			}///////////end of inner for
		}///////////////end of outter for
		return "1스 0볼";
	}	
	//메인메소드 - entry point - callback method - 시스템이 알아서 부르는 메소드
	public static void main(String[] args) {
		BaseBallGame bbg = new BaseBallGame();
		bbg.initDisplay();
	}
	//콜벡메소드 - 개발자가 호출하는것이 아니라 시스템에서 자동 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트소스(jtf_user)에 대한 주소번지를 일기
		System.out.println("obj : "+obj);
		// 너 엔터 친거니?
		if(obj==jtf_user) { //래퍼런스 타입의 비교는 값의 비교가 아닌 주소번지의 비교를 말하는것!
			//System.out.println("엔터쳤넹...");
			String userInput = jtf_user.getText();
			jta_display.append(userInput+"\n");
			jtf_user.setText("");
		}
		//새게임 할거니?
		else if(obj==jbtn_new) {
			ranCom();
			jta_display.append(com[0]+""+com[1]+""+com[2]+"\n");
		}
		//너 지우기 버튼 누른거야?
		else if(obj==jbtn_clear) {
			jta_display.setText("");
		}
		
	}
}