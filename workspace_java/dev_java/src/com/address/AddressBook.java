package com.address;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		this.setSize(600, 500);
		this.setVisible(true);
	}
	//새로고침 처리 메소드 구현
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
			subBook = null;
			subBook = new SubBook();
			subBook.set(label, this, true);
//			subBook = null;
//			subBook = new SubBook(aBook);
//			subBook.initDisplay();
//			subBook.setTitle(label);
//			subBook.setVisible(true); - 비효율적 -> 메소드를 이용해서 한번에 처리하자
		}else if("수정".equals(label)) {
			subBook = null;
			subBook = new SubBook();
			subBook.set(label, aBook, true);
		}else if("상세조회".equals(label)) {
			subBook = null;
			subBook = new SubBook();
			//문제제기-화면그리는 메소드가 사라졌네
			subBook.set(label, aBook, false);
			
		}
	}
}