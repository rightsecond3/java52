package com.DVD;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class DVD extends JFrame implements ActionListener{
	// 선언부 //
	JPanel jp_north = new JPanel();
	JPanel jp_center = new JPanel();
	JButton jbtn_member = new JButton("회원관리");
	JButton jbtn_dvd = new JButton("DVD목록");
	// 테이블에 들어갈 객체들 선언
	String cols[] = {"ID","이름","HP"};
	String data[][] = new String[3][3];
	DefaultTableModel dtm_member = new DefaultTableModel(data,cols);
	//생성자의 파라미터에 DefaultTableModel주소번지를 넘겨서 화면과 테이블을 동기화
	JTable			  jt_member  = new JTable(dtm_member);
	JTableHeader  	  jth_member = jt_member.getTableHeader();
	JScrollPane       jsp_member = new JScrollPane(jt_member);// 최종속지
	
	///*** 생성자 ***//
	public DVD() {
		
	}
	
	//** 화면 처리부 **//
	private void initDisplay() {
		//밑의 액션 코드가 없으면 이벤트 감지가 일어나지 않는다.
		jbtn_member.addActionListener(this);
		jbtn_dvd.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_member);
		jp_north.add(jbtn_dvd);
		jp_center.setLayout(new BorderLayout());// 동서남북으로 배치할 수 있는 레이아웃
		jp_center.add(jsp_member);// Panel에 
		this.add("North", jp_north);
		this.add("Center", jp_center);
		this.setSize(700, 500);
		this.setVisible(true);
	}
	
	// *메인메소드* //
	public static void main(String[] args) {
		DVD dvd = new DVD();
		dvd.initDisplay();
	}
	
	//** 이벤트처리-ActionListener **//
	@Override
	public void actionPerformed(ActionEvent e) {
		//JPanel 밑에 JFrame 밑에 Container가 있다. 포개져있는 형태 상상
		Object obj = e.getSource();// 주소번지를 가져오는 메소드
		if(obj==jbtn_dvd) {// dvd목록으로 바뀐다.
			//JFrame 아래 컨터에너가 존재한다.
			//갱신처리를 위해서는 remove()사용해야한다.
			//이러한 이유로 컨테이너를 생성했다.
			Container cont = this.getContentPane();// Container객체 생성 -> remove 메소드사용가능
			if(jp_center!=null) {
				//remove() 호출할 때 파라미터로 기존 속지(jp_center)를 제거한다.
				cont.remove(jp_center);// jp_center속지를 지워줘라
			}
			//새로 들어와야 될 속지를 인스턴스화
			JPanel jp_dvdM = new DVDManager();
			//중앙에 배치
			this.add("Center", jp_dvdM);
			//기존에 구성된 화면을 갱신(새로고침처리)
			cont.revalidate();
		} else if(obj==jbtn_member){
			Container cont = this.getContentPane();
			if(jp_center!=null) {
				cont.remove(jp_center);
			}
			this.add("Center",jp_center);
			cont.revalidate();
		}
	}
}










