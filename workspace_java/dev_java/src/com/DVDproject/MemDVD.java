package com.DVDproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemDVD extends JDialog implements ActionListener {
	///////////////////// 입력 화면 추가하기 시작////////////////////
	private JLabel labelId;// 아이디 라벨
	private JTextField txtId;// 아이디를 입력하는 컴포넌트
	private JLabel labelName;// 이름라벨
	private JTextField txtName;// 이름을 입력하는 컴포넌트
	private JLabel labelTel;
	private JTextField txtTel;
	private JLabel labelPhonenum;
	private JTextField txtPhonenum;
	private JLabel labelZipcode;
	private JTextField txtZipcode;
	private JLabel labelAddress;
	private JTextField txtAddress;
	private JLabel labelResistdate;
	private JTextField txtResistdate;
	private JLabel labelPw;
	private JTextField txtPw;
	///////////////////// 입력 화면 추가하기 끝 ////////////////////
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_cancel = new JButton("취소");
	// set 메소드에서 쓸 변수 초기화
	DVDVO dVO = null;
	String title = null;
	DVDRent dRent = null;

	//** 뷰를 구현할 메소드 **//
	public void initDisplay() {
		// jp_center속지에 레이아웃을 초기화
		jp_center.setLayout(null);
		jp_center.setBackground(new Color(212,140,106));
		jbtn_save.setBackground(new Color(85,28,0));
		jbtn_save.setForeground(Color.white);
		jbtn_cancel.setBackground(new Color(85,28,0));
		jbtn_cancel.setForeground(Color.white);
		// 화면 객체 생성하기
		labelId = new JLabel("아이디(필수입력)");
		labelPw = new JLabel("비밀번호");
		labelName = new JLabel("이름");
		labelTel = new JLabel("전화번호");
		labelPhonenum = new JLabel("휴대폰");
		labelZipcode = new JLabel("Zipcode");
		labelAddress = new JLabel("주소");
		labelResistdate = new JLabel("등록일");
		// 데이터를 보여줄 텍스트 필드 정의
		txtId = new JTextField(20);
		txtPw = new JTextField(20);
		txtName = new JTextField(20);
		txtTel = new JTextField(20);
		txtPhonenum = new JTextField(20);
		txtZipcode = new JTextField(20);
		txtAddress = new JTextField(20);
		txtResistdate = new JTextField(20);
		// 화면 객체 배치
		labelId.setBounds(20, 20, 150, 20);
		txtId.setBounds(120,20,150,20);
		labelPw.setBounds(20, 45, 150, 20);
		txtPw.setBounds(120,45,150,20);
		labelName.setBounds(20, 70, 150, 20);
		txtName.setBounds(120,70,150,20);
		labelTel.setBounds(20, 95, 150, 20);
		txtTel.setBounds(120,95,150,20);
		labelPhonenum.setBounds(20, 120, 150, 20);
		txtPhonenum.setBounds(120,120,150,20);
		labelZipcode.setBounds(20, 145, 150, 20);
		txtZipcode.setBounds(120,145,150,20);
		labelAddress.setBounds(20, 170, 150, 20);
		txtAddress.setBounds(120,170,150,20);
		labelResistdate.setBounds(20, 195, 150, 20);
		txtResistdate.setBounds(120,195,150,20);
		//등록일은 sysdate로 받을것 -> 입력불가
		txtResistdate.setEditable(false);
		// 컴포넌트들을 패널에 붙힘
		jp_center.add(labelId);
		jp_center.add(txtId);
		jp_center.add(labelPw);
		jp_center.add(txtPw);
		jp_center.add(labelName);
		jp_center.add(txtName);
		jp_center.add(labelTel);
		jp_center.add(txtTel);
		jp_center.add(labelPhonenum);
		jp_center.add(txtPhonenum);
		jp_center.add(labelZipcode);
		jp_center.add(txtZipcode);
		jp_center.add(labelAddress);
		jp_center.add(txtAddress);
		jp_center.add(labelResistdate);
		jp_center.add(txtResistdate);
		// 이벤트 처리
		jbtn_save.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		// 버튼 배치하기
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);
		this.add("South", jp_south);
		this.add("Center", jp_center);
		this.setSize(400, 400);
		this.setVisible(false);
	}
	
	/*****************************************************************************
	 * 부모창에서 결정된 값(입력, aVO)
	 * @param dVO - 입력버튼을 부모창에서 눌렀을 땐 null, 수정일 땐 aVO는 DB에서 읽어온 값을
	 *              담고 있다.
	 * @param title - 부모창에서 선택한 버튼의 라벨담기
	 * @param dRent - 부모창(AddressBook)의 원본 주소번지를 담는 변수
	 * @param isEdit - 자식창(SubBook)을 입력컴포넌트(TextField)를 활성화 시키기 위한 값.
	 *                 true : 수정가능 false : 수정불가
	 ********************************************************************************/
	public void set(DVDVO dVO, String title, DVDRent dRent, boolean isEdit) {
		this.dVO=dVO;
		this.title = title;
		this.dRent = dRent;
		//this.setValue();
		this.setTitle(title);
		this.setVisible(true);
		//this.setEditable(isEdit);
	}
	
	private void setValue() {
		// 입력일 때(dVO에 값이 없다)
		if (dVO==null) {
			setId("");
			setPw("");
			setName("");
			setAddress("");
			setPhonenum("");
			setZipcode("");
			
		}
		//수정시나 
		else {
			setId(dVO.getMemid());
			setPw(dVO.getMempw());
			setName(dVO.getMemname());
			setAddress(dVO.getAddress());
			setPhonenum(dVO.getPhonenum());
			setResistdate(dVO.getResistdate());
			setZipcode(dVO.getZipcode());
		}
	}

	/***********************************************
	 * 입력받는 컴포넌트의 활성화 혹은 비활성화 처리
	 * @param isEdit - 입력, 수정에 따라 텍스트 필드의
	 *                 활성화|비활성화 처리를 하기위한 변수
	 ***********************************************/
	private void setEditable(boolean isEdit) {
		System.out.println(isEdit);
		txtId.setEditable(isEdit);
		txtPw.setEditable(isEdit);
		txtName.setEditable(isEdit);
		txtAddress.setEditable(isEdit);
		txtPhonenum.setEditable(isEdit);
		txtZipcode.setEditable(isEdit);
	}
	//// memDVD의 화면에서 입력받은 값 혹은 화면에 출력한 값 처리 getter/setter ////
	/* 각 컬럼의 값들을 설정하거나 읽어오는 메소드 구현하기 */
	public String getId() { return txtId.getText();}
	public void setId(String id) { txtId.setText(id);}
	public String getPw() { return txtPw.getText();}
	public void setPw(String pw) { txtPw.setText(pw);}
	public String getName() { return txtName.getText();}
	public void setName(String name) { txtName.setText(name);}
	public String getAddress() { return txtAddress.getText();}
	public void setAddress(String address) { txtAddress.setText(address); }
	public String getPhonenum() { return txtPhonenum.getText();}
	public void setPhonenum(String phonenum) { txtPhonenum.setText(phonenum);}
	public String getResistdate() { return txtResistdate.getText(); }
	public void setResistdate(String resistdate) { txtResistdate.setText(resistdate); }
	public String getZipcode() { return txtZipcode.getText(); }
	public void setZipcode(String zipcode) { txtZipcode.setText(zipcode); }
	
	

	//** 메인 메소드 **//
	public static void main(String args[]) {
		MemDVD md = new MemDVD();
		md.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_cancel) {
			this.dispose();
		}
	}
}
