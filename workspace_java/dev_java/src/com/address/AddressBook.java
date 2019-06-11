package com.address;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AddressBook extends JFrame implements ActionListener{
//	SubBook subBook = new SubBook();
	SubBook subBook = null;
	//싱글톤 선언
	static AddressBook aBook = null;
	JPanel jp_north = new JPanel();
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JButton jbtn_det = new JButton("상세조회");
	//헤더 정보를 담을 객체 추가
	String cols[] = {"아이디", "이름", "주소", "HP"};
	String data[][] = new String[5][4];// 헤더는0 컬럼은 4개
	//데이터를 담을 수 있는 클래스가 필요함.
	//UI 솔루션에서는 DataSet으로 부른다.
	DefaultTableModel dtm_address = new DefaultTableModel(data, cols);//데이터와 헤더정보를 넣어준다
	//주소록을 보여줄 테이블을 만들 것
	JTable jt_address = new JTable(dtm_address);// 화면만 제공함. 그리드만 제공. 데이터는 없다.
	JScrollPane jsp_address = new JScrollPane(jt_address);
	//헤더의 간격을 조정해줄 객체 생성
	JTableHeader jth_address = jt_address.getTableHeader();// new없이 제공되는 api로 객체를 생성함
	
	public void initDisplay() {
		jbtn_ins.addActionListener(this); //this->actionPerformed
		jbtn_upd.addActionListener(this); 
		jbtn_det.addActionListener(this); 
		jp_north.setLayout(new FlowLayout());
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		jp_north.add(jbtn_det);		
		this.add("North", jp_north);
		this.add("Center", jsp_address);// 스크롤페인이 속지역할을 하기때문에
		this.setSize(700, 500);
		this.setVisible(true);
		jth_address.setFont(new Font("맑은고딕",Font.BOLD,18));
		jth_address.setBackground(new Color(22,22,100));
		jth_address.setForeground(Color.white);
		jt_address.setGridColor(Color.blue);
		//헤더들이 이동하지 못하도록 잠금하는 메소드 호출
		jth_address.setReorderingAllowed(false);
		//헤더들의 크기를 조정하지못하도록 잠금하는 메도스 호출
		jth_address.setResizingAllowed(false);
		//헤더의 간격을 조정하는 메소드 호출
		jt_address.getColumnModel().getColumn(0).setPreferredWidth(80);
		jt_address.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt_address.getColumnModel().getColumn(2).setPreferredWidth(390);
		jt_address.getColumnModel().getColumn(3).setPreferredWidth(130);
		//테이블의 화면을 새로 갱신해주는 메소드 호출
		jt_address.repaint();
	}
	///새로고침 처리 메소드 구현///
	public void refreshData() {
		System.out.println("새로고침 처리");
	}
//	public static AddressBook getInstance() {
//		if(aBook==null) {//싱글톤 선언
//			aBook = new AddressBook();
//		}
//		return aBook;
//	}
	public static void main(String[] args) {
		if(aBook==null) {//싱글톤 선언
			aBook = new AddressBook();
		}
		aBook.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String label = ae.getActionCommand();//입력|수정|상세조회의 라벨을 읽어옴
		if("입력".equals(label)) {
//			subBook = null;
//			subBook = new SubBook(aBook);
//			subBook.initDisplay();
//			subBook.setTitle(label);
//			subBook.setVisible(true); - 비효율적 -> 메소드를 이용해서 한번에 처리하자
			subBook = null;
			subBook = new SubBook();
			//입력일 때는 넘어오는 값이 없기 때문에 null값이 맞다
			subBook.set(null, label, this, true);
		}else if("수정".equals(label)) {
			subBook = null;
			subBook = new SubBook();
			subBook.set(new AddressVO(), label, aBook, true);
		}else if("상세조회".equals(label)) {
			subBook = null;
			subBook = new SubBook();
			//문제제기-화면그리는 메소드가 사라졌네
			//DB에서 가져온 값을 1번째 파라미터에 넣어야 하지만 아직 그 단계까지는
			//아니기 때문에 new AddressVO()로 대체함
			subBook.set(new AddressVO(), label, aBook, false);
			
		}
	}
}
