package com.project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubRent extends JDialog implements ActionListener {
	private JLabel labelR_num;// 대여번호 라벨
	private JTextField txtR_num;// 대여번호를 입력하는 컴포넌트
	private JLabel labelR_date;// 대여일라벨
	private JTextField txtR_date;// 대여일을 입력하는 컴포넌트
	private JLabel labelReturndate;
	private JTextField txtReturndate;
	private JLabel labelLatefee;
	private JTextField txtLatefee;
	private JLabel labelDuedate;
	private JTextField txtDuedate;
	private JLabel labelMemid;
	private JTextField txtMemid;
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_cancel = new JButton("취소");
	String title = null;
	Rent rent = null;
	RentVO rVO = null;

	/// *** 생성자 ***///
	public SubRent() {
		initDisplay();
	}

	// ** 화면구성부 **//
	public void initDisplay() {
		// 이벤트 처리
		jbtn_save.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		// 센터 레이아웃 널로 뭉개기
		jp_center.setLayout(null);
		// 라벨에 이름 넣어주기
		labelR_num = new JLabel("대여번호");
		labelR_date = new JLabel("대여일자");
		labelReturndate = new JLabel("반납일자");
		labelLatefee = new JLabel("연체료");
		labelDuedate = new JLabel("반납예정일자");
		labelMemid = new JLabel("회원아이디");
		// 텍스트 필드 정의하기
		txtR_num = new JTextField(20);
		txtR_date = new JTextField(20);
		txtReturndate = new JTextField(20);
		txtLatefee = new JTextField(20);
		txtDuedate = new JTextField(20);
		txtMemid = new JTextField(20);

		// 화면 객체 배치하기 시작
		labelR_num.setBounds(20, 20, 150, 20);
		txtR_num.setBounds(120, 20, 150, 20);

		labelR_date.setBounds(20, 50, 150, 20);
		txtR_date.setBounds(120, 50, 150, 20);

		labelReturndate.setBounds(20, 80, 150, 20);
		txtReturndate.setBounds(120, 80, 150, 20);

		labelDuedate.setBounds(20, 110, 150, 20);
		txtDuedate.setBounds(120, 110, 150, 20);

		labelLatefee.setBounds(20, 140, 150, 20);
		txtLatefee.setBounds(120, 140, 150, 20);

		labelMemid.setBounds(20, 170, 150, 20);
		txtMemid.setBounds(120, 170, 150, 20);

		// 화면 객체 배치하기 끝
		// 컴포넌트들을 패널에 붙히기

		jp_center.add(labelR_num);
		jp_center.add(txtR_num);
		jp_center.add(labelR_date);
		jp_center.add(txtR_date);
		jp_center.add(labelReturndate);
		jp_center.add(txtReturndate);
		jp_center.add(labelLatefee);
		jp_center.add(txtLatefee);
		jp_center.add(labelDuedate);
		jp_center.add(txtDuedate);
		jp_center.add(labelMemid);
		jp_center.add(txtMemid);

		// 컴포넌트들을 패널에 붙히기 끝
		this.setLayout(new BorderLayout());
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);
		this.add("South", jp_south);
		this.add("Center", jp_center);
		this.setSize(300, 300);
		this.setVisible(false);
	}

	public String getR_num() {	return txtR_num.getText();	}
	public String getR_date() {	return txtR_date.getText(); }
	public String getReturndate() {	return txtReturndate.getText();	}
	// 화면에서 받을 때는 String이기 떄문에 int로 바꿔주는 메소드활용
	public int getLatefee() {	return Integer.parseInt(txtLatefee.getText());	}
	public String getDuedate() {	return txtDuedate.getText();	}
	public String getMemid() {	return txtMemid.getText();	}
	
	public void setR_num(String rnum) {	txtR_num.setText(rnum);	}
	public void setR_date(String rdate) {	txtR_date.setText(rdate);	}
	public void setReturndate(String returndate) {	txtReturndate.setText(returndate);	}
	// int로 받은 변수를 String으로 넣어줌
	public void setLatefee(int latefee) {	txtLatefee.setText(String.valueOf(latefee)); }
	public void setDuedate(String duedate) {	txtDuedate.setText(duedate);	}
	public void setMemid(String memid) {	txtMemid.setText(memid);	}
	
	public void set(RentVO rVO, String title, Rent rent, boolean isEdit) {
		this.rVO = rVO;
		this.title = title;
		this.rent = rent;
		this.setValue();
		this.setTitle(title);
		this.setVisible(true);
		this.setEditable(isEdit);
		// 수정
		if ("수정".equals(title)) {
			txtR_num.setEditable(false);
			txtMemid.setEditable(false);
		}
	}

	public void setEditable(boolean isEdit) {
		txtMemid.setEditable(isEdit);
		txtR_num.setEditable(isEdit);
		txtReturndate.setEditable(isEdit);
		txtLatefee.setEditable(isEdit);
		txtDuedate.setEditable(isEdit);
		txtR_date.setEditable(false);
	}

	public void setValue() {
		// 입력일 때
		if (rVO == null) {
			setMemid("");
			setR_num("");
			setReturndate("");
			setLatefee(0);
			setDuedate("");
			setR_date("");
		}
		// 상세조회나 수정시는 aVO에 있는 값으로 각 콤포넌트(txtId, txtName..)를 초기화한다.
		else {
			// JOptionPane.showMessageDialog(mView, "dVO:"+mVO.getMemid());
			// setId는 화면에 값을 출력, aVO.getId()-DB에서 가져온 값
			setMemid(rVO.getMemid());
			setR_num(rVO.getR_num());
			setReturndate(rVO.getReturndate());
			setLatefee(rVO.getLatefee());
			setDuedate(rVO.getDuedate());
			setR_date(rVO.getR_date());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_save) {
			if (rVO == null) {// 입력인경우
				try {
					RentVO rpaVO = new RentVO();
					rpaVO.setCommand("insert");
					rpaVO.setR_num(getR_num());
					rpaVO.setReturndate(getReturndate());
					rpaVO.setLatefee(getLatefee());
					rpaVO.setDuedate(getDuedate());
					rpaVO.setMemid(getMemid());
					RentCtrl rCtrl = new RentCtrl();
					RentVO rraVO = rCtrl.send(rpaVO);
					if (rraVO != null) {
						if (rraVO.getStatus() == 1) {
							JOptionPane.showMessageDialog(rent, "입력성공");
							this.dispose();
							rent.refreshData();
						} else {
							JOptionPane.showMessageDialog(rent, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} else {// 수정인 경우
				try {
					RentVO rpaVO = new RentVO();
					rpaVO.setCommand("update");
					rpaVO.setR_num(rVO.getR_num());
					rpaVO.setReturndate(getReturndate());
					rpaVO.setLatefee(getLatefee());
					rpaVO.setDuedate(getDuedate());
					rpaVO.setMemid(getMemid());
					RentCtrl rCtrl = new RentCtrl();
					RentVO rraVO = rCtrl.send(rpaVO);
					if (rraVO != null) {
						if (rraVO.getStatus() == 1) {
							JOptionPane.showMessageDialog(rent, "입력성공");
							this.dispose();
							rent.refreshData();
						} else {
							JOptionPane.showMessageDialog(rent, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		} else if(obj==jbtn_cancel) {
			this.dispose();
		}
	}

}
