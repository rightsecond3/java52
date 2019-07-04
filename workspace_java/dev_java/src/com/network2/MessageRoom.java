package com.network2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

import com.network1.Protocol;

public class MessageRoom extends JPanel implements ActionListener{
	/////선언부
	TalkClientVer2 tc2 = null;
	JPanel jp_first    = new JPanel();
	JTextField jtf_msg = new JTextField();
	/*
	 * JTextPane에 스타일을 적용하기 위해서는 스타일을 지원하는 클래스를 추가 매핑해야함
	 * why - 문자도 그리는 개념으로 이해해야 하므로 글꼴을 변경하거나 글 크기를 변경하려면 필요
	 */
	StyledDocument sd_display = 
							new DefaultStyledDocument();
	JTextPane jtp_display     = new JTextPane(sd_display);
	JScrollPane jsp_display   = new JScrollPane(jtp_display
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수평스크롤X, 수직스크롤O
	
	JPanel jp_second = new JPanel();
	String cols[]    = { "닉네임" };
	String data[][]  = new String[0][1];
	DefaultTableModel dtm_name = new DefaultTableModel(data, cols); //json
	JTable jtb_name            = new JTable(dtm_name); //datagrid
	JScrollPane jsp_name       = new JScrollPane(jtb_name
						,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
						,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JPanel jp_second_south = new JPanel();
	JButton jbtn_whisper   = new JButton("일대일 채팅");
	JButton jbtn_change    = new JButton("대화명 변경");
	JButton jbtn_exit      = new JButton("종료");
	JButton jbtn_icon      = new JButton("이모티콘");
	//이모티콘 객체 생성 추가
	ImoticonMessage imo = new ImoticonMessage(this);
	//* 생성자 *//
	public MessageRoom() {
		
	}
	public MessageRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
	}
	//*** 화면 처리부 ***//
	public void initDisplay() {
		//이벤트 처리부
		jbtn_change.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_icon.addActionListener(this);
		jtf_msg.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		//레이아웃 설정
		jp_first.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(2,2));
		this.setLayout(new GridLayout(1,2));
		//컴포넌트 붙혀주기
		jp_second_south.add(jbtn_icon);
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_exit);
		
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jtf_msg);
		
		jp_second.add("Center",jsp_name);
		jp_second.add("South", jp_second_south);

		this.add(jp_first);
		this.add(jp_second);
	}
	//** 메세지 전송
	public void message_process(String msg,String imgChoice) {
		//
		String roomTitle = null;
		for(int i=0;i<tc2.wr.jtb_wait.getRowCount();i++) {
			if(tc2.nickName.equals(tc2.wr.dtm_wait.getValueAt(i, 0))) {
				roomTitle = (String) tc2.wr.dtm_wait.getValueAt(i, 1);
				break;
			}
		}
		//이모티콘 메시지 전송
		if(imgChoice!=null) {
			msg="이모티콘";
			try {
				tc2.oos.writeObject(Protocol.MESSAGE
						+Protocol.seperator+roomTitle
						+Protocol.seperator+tc2.nickName
						+Protocol.seperator+msg
						+Protocol.seperator+imgChoice);//선택한 이모티콘 정보 넘김
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//텍스트 메시지 전송
		else {
			try {
				tc2.oos.writeObject(Protocol.MESSAGE
						+Protocol.seperator+roomTitle
						+Protocol.seperator+tc2.nickName
						+Protocol.seperator+msg
						+Protocol.seperator+"default");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//////** 이벤트 처리부 **//////
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		//메세지 버튼
		if(obj==jtf_msg) {
			message_process(msg, null);
			jtf_msg.setText("");
		//이모티콘 버튼
		} else if(obj==jbtn_icon) {
			imo.setVisible(true);
		}
	}
	//단위테스트 때문 추가 - TalkClientVer2에 붙힘
	public static void main(String[] args) {
		
	}

}
