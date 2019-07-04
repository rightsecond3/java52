package com.project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.address.AddressBook;
import com.address.AddressVO;

public class SubMem extends JDialog implements ActionListener{
	private JLabel labelMemid;// 아이디 라벨
	private JTextField txtMemid;// 아이디를 입력하는 컴포넌트
	private JLabel labelMemname;// 이름라벨
	private JTextField txtMemname;// 이름을 입력하는 컴포넌트
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
	private JLabel labelMempw;
	private JTextField txtMempw;
	
	JPanel jp_center = new JPanel();
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_cancel = new JButton("취소");
	String title = null;
	Mem dMem = null;
	MemVO mVO = null;
	
	///*** 생성자 ***///
	public SubMem() {
		initDisplay();
	}
	
	public void initDisplay() {
		//이벤트 처리
		jbtn_save.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		//센터 레이아웃 널로 뭉개기
		jp_center.setLayout(null);
		// 라벨에 이름 넣어주기
		labelMemid = new JLabel("아이디");
		labelMemname = new JLabel("이름");
		labelTel = new JLabel("전화번호");
		labelPhonenum= new JLabel("핸드폰번호");
		labelZipcode = new JLabel("도시명");
		labelAddress = new JLabel("주소");
		labelResistdate = new JLabel("등록일");
		labelMempw = new JLabel("비밀번호");
		// 텍스트 필드 정의하기
		txtMemid = new JTextField(20);
		txtMemname = new JTextField(20);
		txtTel = new JTextField(20);
		txtPhonenum = new JTextField(20);
		txtZipcode = new JTextField(20);
		txtAddress = new JTextField(20);
		txtResistdate = new JTextField(20);
		txtMempw = new JTextField(20);

		// 화면 객체 배치하기 시작
		labelMemid.setBounds(20, 20, 150, 20);
		txtMemid.setBounds(120, 20, 150, 20);
		
		labelMemname.setBounds(20, 50, 150, 20);
		txtMemname.setBounds(120, 50, 150, 20);
		
		labelTel.setBounds(20, 80, 150, 20);
		txtTel.setBounds(120, 80, 150, 20);
		
		labelPhonenum.setBounds(20, 110, 150, 20);
		txtPhonenum.setBounds(120, 110, 150, 20);
		
		labelZipcode.setBounds(20, 140, 150, 20);
		txtZipcode.setBounds(120, 140, 150, 20);
		
		labelAddress.setBounds(20, 170, 150, 20);
		txtAddress.setBounds(120, 170, 150, 20);
		
		labelResistdate.setBounds(20, 200, 150, 20);
		txtResistdate.setBounds(120, 200, 150, 20);
		
		labelMempw.setBounds(20, 230, 150, 20);
		txtMempw.setBounds(120, 230, 150, 20);
		
		txtResistdate.setEditable(false);
		// 화면 객체 배치하기  끝
		// 컴포넌트들을 패널에 붙히기
		jp_center.add(labelMemid);
		jp_center.add(txtMemid);
		jp_center.add(labelMemname);
		jp_center.add(txtMemname);
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
		jp_center.add(labelMempw);
		jp_center.add(txtMempw);
		// 컴포넌트들을 패널에 붙히기 끝
		this.setLayout(new BorderLayout());
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);
		this.add("South", jp_south);
		this.add("Center", jp_center);
		this.setSize(300, 380);
		this.setVisible(false);
	}
	////////화면에서 입력받은 값 혹은 화면에 출력한 값 처리 getter/setter ////////
	public String getMemid() {return txtMemid.getText(); }
	public void setMemid(String memid) { txtMemid.setText(memid); }
	public String getMemname() {return txtMemname.getText(); }
	public void setMemname(String memname) { txtMemname.setText(memname); }
	public String getTel() {return txtTel.getText(); }
	public void setTel(String tel) { txtTel.setText(tel); }
	public String getPhonenum() {return txtPhonenum.getText(); }
	public void setPhonenum(String phonenum) { txtPhonenum.setText(phonenum); }
	public String getZipcode() {return txtZipcode.getText(); }
	public void setZipcode(String zipcode) { txtZipcode.setText(zipcode); }
	public String getAddress() {return txtAddress.getText(); }
	public void setAddress(String addr) { txtAddress.setText(addr); }
	public String getResistdate() {return txtResistdate.getText(); }
	public void setResistdate(String resisdate) { txtResistdate.setText(resisdate); }
	public String getMempw() {return txtMempw.getText(); }
	public void setMempw(String pw) { txtMempw.setText(pw); }
	
	/******************************************************************
	 * 부모창에서 결정된 값(입력, mVO)
	 * @param mVO 입력버튼을 부모창에서 눌렀을 땐 null, 수정일 땐 mVO는 db에서 읽어온값을
	 *            담고 있다.
	 * @param title - 부모창에서 선택한 버튼의 라벨담기
	 * @param dMem - 부모창(DVDMem)의 원본 주소번지를 담는 변수
	 * @param isEdit - 자식창(SubMem)에서 입력콤퍼넌트 활성화 시키기 위한 값
	 * true:수정가능 false:수정불가
	 ****************************************************************/
	public void set(MemVO mVO, String title, Mem dMem, boolean isEdit) {
		this.mVO = mVO;
		this.title = title;
		this.dMem = dMem;
		this.setValue();
		this.setTitle(title);
		this.setVisible(true);
		this.setEditable(isEdit);
	    if("수정".equals(title)) {
	          txtMemid.setEditable(false);
	    }
	}
	
	//** 입력받는 컴포넌트의 활성화 혹은 비활성화 처리 **//
	public void setEditable(boolean isEdit) {
		txtMemid.setEditable(isEdit);
		txtMemname.setEditable(isEdit);
		txtTel.setEditable(isEdit);
		txtPhonenum.setEditable(isEdit);
		txtZipcode.setEditable(isEdit);
		txtAddress.setEditable(isEdit);
		txtMempw.setEditable(isEdit);
		txtResistdate.setEditable(false);
	}

	/*******************************************************************
	 * 	이 메소드는 수정 혹은 상세조회 인 경우 select한 결과를 화면에 출력하기 위한 메소드임.
	 *  mVO는 DVDMem에서 set메소드 호출시 첫번째 파라미터로 넘어오는 변수를
	 *  전변으로 초기화 하였으므로 파라미터가 없어도 전변으로 값을 꺼낼 수 있음.
	 *******************************************************************/
		public void setValue() {
			//입력일 때
			 if(mVO==null) {
				 setMemid("");
				 setMemname("");
				 setTel("");
				 setPhonenum("");
				 setZipcode("");
				 setAddress("");
				 setResistdate("");
				 setMempw("");
			 }
			//상세조회나 수정시는 aVO에 있는 값으로 각 콤포넌트(txtId, txtName..)를 초기화한다.
			 else {
				 //JOptionPane.showMessageDialog(dMem, "dVO:"+mVO.getMemid());
				 //setId는 화면에 값을 출력, aVO.getId()-DB에서 가져온 값

				setMemid(mVO.getMemid());
				setMemname(mVO.getMemname());
				setTel(mVO.getTel());
				setPhonenum(mVO.getPhonenum());
				setZipcode(mVO.getZipcode());
				setAddress(mVO.getAddress());
				setResistdate(mVO.getResistdate());
				setMempw(mVO.getMempw());				

				
			 }
		}
	
	public static void main (String[] args) {
		SubMem ss = new SubMem();
		ss.initDisplay();
	}
	
	//** 이벤트 처리 **//
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_save) {
			if(mVO == null) {//입력인경우
				try {
					MemVO mpaVO = new MemVO();
					mpaVO.setCommand("insert");
					mpaVO.setMemid(getMemid());
					mpaVO.setMemname(getMemname());
					mpaVO.setTel(getTel());
					mpaVO.setPhonenum(getPhonenum());
					mpaVO.setZipcode(getZipcode());
					mpaVO.setAddress(getAddress());
					//Resistdate는 오라클에서 sysdate로 처리할꺼기 때문에 지정X
					mpaVO.setMempw(getMempw());
					MemCtrl dCtrl = new MemCtrl();
					MemVO mraVO = dCtrl.send(mpaVO);
					if(mraVO!=null) {
						if(mraVO.getStatus()==1) {
							JOptionPane.showMessageDialog(dMem, "입력성공");
							this.dispose();
							dMem.refreshData();
						} else {
							JOptionPane.showMessageDialog(dMem, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
				}
			} else {//수정인 경우
				try {
					MemVO mpaVO = new MemVO();
					mpaVO.setCommand("update");
					mpaVO.setMemid(mVO.getMemid());
					mpaVO.setMemname(getMemname());
					mpaVO.setTel(getTel());
					mpaVO.setPhonenum(getPhonenum());
					mpaVO.setZipcode(getZipcode());
					mpaVO.setAddress(getAddress());
					mpaVO.setMempw(getMempw());
					MemCtrl dCtrl = new MemCtrl();
					MemVO mraVO = dCtrl.send(mpaVO);
					if(mraVO!=null) {
						if(mraVO.getStatus()==1) {
							JOptionPane.showMessageDialog(dMem, "입력성공");
							this.dispose();
							dMem.refreshData();
						} else {
							JOptionPane.showMessageDialog(dMem, "입력실패");
							return;
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		if(obj==jbtn_cancel) {
			this.dispose();
		}
	}
}
