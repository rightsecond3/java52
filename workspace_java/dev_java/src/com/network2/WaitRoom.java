package com.network2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class WaitRoom extends JPanel implements ActionListener {
	/////선언부
	TalkClientVer2 tc2 = null;
	JPanel jp_first        = new JPanel();
	JPanel jp_second       = new JPanel();
	JPanel jp_second_south = new JPanel();
	
	String cols1[]   = {"대화명", "위치"};
	String data1[][] = new String[0][2];
	//양식은 못 갖고 데이터만 가짐
	DefaultTableModel dtm_wait = new DefaultTableModel(data1, cols1);
	//이벤트는 화면에서 일어나므로 테이블에서 처리
	JTable jtb_wait            = new JTable(dtm_wait);
	JScrollPane jsp_wait       = new JScrollPane(jtb_wait
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	String cols2[]   = {"단톡명", "현재원"};
	String data2[][] = new String[0][2];
	DefaultTableModel dtm_room = new DefaultTableModel(data2, cols2);
	JTable jtb_room            = new JTable(dtm_room);
	JScrollPane jsp_room       = new JScrollPane(jtb_room
							,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
							,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JButton jbtn_create = new JButton("단톡생성");
	JButton jbtn_in     = new JButton("입장");
	JButton jbtn_blank  = new JButton("미정");
	JButton jbtn_exit   = new JButton("종료");
	JTableHeader jth_wait = jtb_wait.getTableHeader();
	JTableHeader jth_room = jtb_room.getTableHeader();
	//대화명 정보 담기
	String nickName = null;
	//단톡명 담기
	String roomTitle = null;
	//현재원 담기
	int currentNum = 0;
	
	//* 생성자 *//
	public WaitRoom() {
	}
	public WaitRoom(TalkClientVer2 tc2) {
		this.tc2 = tc2;
		initDisplay();
	}
	//*** 화면 처리부 ***//
	public void initDisplay() {
		//이벤트 처리부
		jbtn_blank.addActionListener(this);
		jbtn_create.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_in.addActionListener(this);
		//컴포넌트 처리부
		this.setLayout(new GridLayout(1,2));
		jp_first.setLayout(new BorderLayout());
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(2,2,2,2));
		
		jp_first.add("Center", jsp_wait);
		
		jp_second_south.add(jbtn_create);
		jp_second_south.add(jbtn_in);
		jp_second_south.add(jbtn_blank);
		jp_second_south.add(jbtn_exit);
		
		jp_second.add("Center", jsp_room);
		jp_second.add("South", jp_second_south);
		
		this.add(jp_first);
		this.add(jp_second);
	}
	//** 입장버튼 이벤트 처리
	public void intro_process() {
		//테이블에서 선택한 로우 값 담기
		int index = jtb_room.getSelectedRow();
		if(index<0) {
			JOptionPane.showMessageDialog(tc2, "입장할 방을 선택하세요");
			return; //intro_process 탈출
		} else {
			try {
				//방목록에서 선택한 로우 찾기
				for(int i=0;i<dtm_room.getRowCount();i++) {
					//선택한 로우의 index로 확인
					if(jtb_room.isRowSelected(i)) {
						String roomTitle = (String) dtm_room.getValueAt(i, 0);
						tc2.oos.writeObject(Protocol.ROOM_IN
								+Protocol.seperator+roomTitle
								+Protocol.seperator+tc2.nickName);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//선택한 로우 정보 삭제
		jtb_room.clearSelection();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		// 단톡방 생성 버튼 이벤트 처리
		if (obj==jbtn_create) {
			roomTitle = JOptionPane.showInputDialog("단톡명을 입력하세요.");
			if (roomTitle!=null) {
				try {
					tc2.oos.writeObject(Protocol.ROOM_CREATE
							+Protocol.seperator+roomTitle
							+Protocol.seperator+0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}////////end of if(jbtn_create)
		else if(obj==jbtn_in) {
			intro_process();
		}////////end of if(jbtn_in)
	}
	
}