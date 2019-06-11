package com.address;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

public class SubBook extends JDialog implements ActionListener {
	///////////////////// 입력 화면 추가하기 시작////////////////////
	private JLabel labelId;// 아이디 라벨
	private JTextField txtId;// 아이디를 입력하는 컴포넌트
	private JLabel labelName;// 이름라벨
	private JTextField txtName;// 이름을 입력하는 컴포넌트
	private JLabel labelAddr;
	private JTextField txtAddress;
	private JLabel labelHP;
	private JTextField txtHP;
	private JLabel labelRel;
	private JTextField txtRelationShip;
	private JLabel labelGender;
	private JComboBox comboGender;
	private JLabel labelBirth;
	private JTextField txtBirthDay;
	private JLabel labelComment;
	private JTextArea txtComment;
	private JLabel labelRegDate;
	private JTextField txtRegDate;
	private JScrollPane scrollPane;
	private JScrollPane scrollComment;
	///////////////////// 입력 화면 추가하기 끝 ////////////////////
	Font font = new Font("돋움체", Font.PLAIN, 14);
	JPanel jp_center = new JPanel();//입력에 필요한 화면을 배치(좌표값 배치)
	JPanel jp_south = new JPanel();
	JButton jbtn_save = new JButton("저장");
	JButton jbtn_cancel = new JButton("취소");
	String title = null;
	AddressBook aBook = null;
	JScrollPane jsp_line = new JScrollPane(jp_center);
	AddressVO aVO = null;// set메소드에서 쓸  aVO 변수 선언
	public SubBook() {
		initDisplay();
	}
	/*****************************************************************************
	 * 부모창에서 결정된 값(입력, aVO)
	 * @param aVO - 입력버튼을 부모창에서 눌렀을 땐 null, 수정일 땐 aVO는 DB에서 읽어온 값을
	 *              담고 있다.
	 * @param title - 부모창에서 선택한 버튼의 라벨담기
	 * @param aBook - 부모창(AddressBook)의 원본 주소번지를 담는 변수
	 * @param isEdit - 자식창(SubBook)을 입력컴포넌트(TextField)를 활성화 시키기 위한 값.
	 *                 true : 수정가능 false : 수정불가
	 ********************************************************************************/
	public void set(AddressVO aVO, String title, AddressBook aBook, boolean isEdit) {
		this.aVO=aVO;
		this.title = title;
		this.aBook = aBook;
		this.setTitle(title);
		this.setVisible(true);
		this.setEditable(isEdit);
	}

	public void initDisplay() {
		//jp_center속지에 레이아웃을 초기화하자.
		jp_center.setLayout(null);//FlowLayout
		jp_center.setBackground(new Color(212,140,106));
		jbtn_save.setBackground(new Color(85,28,0));
		jbtn_save.setForeground(Color.white);
		jbtn_cancel.setBackground(new Color(85,28,0));
		jbtn_cancel.setForeground(Color.white);
		////////////// 화면 객체 생성하기 시작/////////////////////
		labelName = new JLabel("이름(필수입력) ");
		labelAddr = new JLabel("주소 ");
		labelHP = new JLabel("HP ");
		labelId = new JLabel("ID ");
		labelGender = new JLabel("성별 ");
		labelBirth = new JLabel("생일(YYYYMMDD) ");
		labelComment = new JLabel("비고 ");
		labelRegDate = new JLabel("수정일 ");

		labelName.setFont(font);
		labelAddr.setFont(font);
		labelHP.setFont(font);
		labelId.setFont(font);
		labelGender.setFont(font);
		labelBirth.setFont(font);
		labelComment.setFont(font);
		labelRegDate.setFont(font);

		// 데이터를 보여줄 텍스트 필드등을 정의합니다.
		txtName = new JTextField(20);
		txtAddress = new JTextField(20);
		txtHP = new JTextField(20);
		txtId = new JTextField(15);
		txtBirthDay = new JTextField(20);
		txtComment = new JTextArea(3, 20);
		scrollComment = new JScrollPane(txtComment);
		txtRegDate = new JTextField(20);

		String[] genderList = { "남자", "여자" };
		comboGender = new JComboBox(genderList);
		////////////// 화면 객체 생성하기 끝 /////////////////////
		////////////// 화면 객체 배치하기 시작 /////////////////////
		labelName.setBounds(20,20, 150,20);
		txtName.setBounds(120,20, 150,20);

		labelAddr.setBounds(20, 45, 150,20);
		txtAddress.setBounds(120,45, 150,20);

		labelHP.setBounds(20,70, 150,20);
		txtHP.setBounds(120,70, 150, 20);

		labelId.setBounds(20,95, 150,20);
		txtId.setBounds(120,95, 120,20);

		labelGender.setBounds(20,120, 150,20);
		comboGender.setBounds(120, 120, 150,20);
  		comboGender.setFont(new java.awt.Font("굴림", 0, 12));

		labelBirth.setBounds(20,145, 150,20);
		txtBirthDay.setBounds(120,145, 150,20);

		labelComment.setBounds(20, 170, 150,20);
		scrollComment.setBounds(120,170, 250,60);

		labelRegDate.setBounds(20, 235, 150,20);
		txtRegDate.setBounds(120,235, 150,20);
		txtRegDate.setEditable(false);

		// 컴포넌트들을 패널에 붙입니다.
		jp_center.add(labelName);
		jp_center.add(txtName);
		jp_center.add(labelAddr);
		jp_center.add(txtAddress);
		jp_center.add(labelHP);
		jp_center.add(txtHP);
		jp_center.add(labelId);
		jp_center.add(txtId);
		jp_center.add(labelGender);
		jp_center.add(comboGender);
		jp_center.add(labelBirth);
		jp_center.add(txtBirthDay);
		jp_center.add(labelComment);
		jp_center.add(scrollComment);
		jp_center.add(labelRegDate);
		jp_center.add(txtRegDate);
		////////////// 화면 객체 배치하기  끝  /////////////////////
		jbtn_save.addActionListener(this);
		jbtn_cancel.addActionListener(this);
		this.setLayout(new BorderLayout());
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_cancel);
		this.add("South", jp_south);
		this.add("Center",jsp_line);
		// 자식창의 제목은 세가지 중 한 가지가 되어야 함.
		// 하나의 화면을 가지고 세가지 기능을 어떻게 처리하지?
		this.setTitle(title);
		this.setSize(400, 400);
		this.setVisible(false);
	}////////////////end of initDisplay
	//입력받는 컴포넌트의 활성화 혹은 비활성화 처리
	public void setEditable(boolean isEdit) {
		txtName.setEditable(isEdit);
		txtAddress.setEditable(isEdit);
		txtHP.setEditable(isEdit);
		txtBirthDay.setEditable(isEdit);
		txtId.setEditable(isEdit);
		txtComment.setEditable(isEdit);
	}
	////////////////// 화면에서 입력받은 값 혹은 화면에 출력한 값 처리 getter/setter ////////////
	/* 각 컬럼의 값들을 설정하거나 읽어오는 메소드 구현하기  */
	public String getName() { return txtName.getText();}
	public void setName(String name) { txtName.setText(name);}
	public String getAddr() { return txtAddress.getText();}
	public void setAddr(String addr) { txtAddress.setText(addr);}
	public String getHP() { return txtHP.getText();}
	public void setHP(String hp) { txtHP.setText(hp);}
	public String getBirth() { return txtBirthDay.getText();}
	public void setBirth(String birth) { txtBirthDay.setText(birth);}
	public String getComment() { return txtComment.getText();}
	public void setComment(String comment) { txtComment.setText(comment);}
	public String getID() { return txtId.getText();}
	public void setID(String id) { txtId.setText(id);}
	public String getGender() {
		if(comboGender.getSelectedItem().equals("남자")) return "1";
		else return "0";
	}
	public void setGender(String gender) {
		if(gender.equals("1")) comboGender.setSelectedItem("남자");
		else comboGender.setSelectedItem("여자");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		if ("저장".equals(label)) {
			// dispose는 창만 닫게 해줄 뿐 메모리에 대해서까지 영향력이 없다.
			if (aVO != null) {// 수정인 경우  : 기존 데이터가 있고 난후 실행된 경우
				try {
					AddressVO paVO = new AddressVO();
					paVO.setCommand("update");
					paVO.setId(aVO.getId());// PK는 수정 불가하므로 aVO의 값을 getter로 가져옴
					paVO.setName(getName());
					paVO.setAddress(getAddr());
					paVO.setHp(getHP());
					paVO.setBirthday(getBirth());
					paVO.setComments(getComment());
					paVO.setGender(getGender());
					AddressBookCtrl aCtrl = new AddressBookCtrl();
					aCtrl.send(paVO);			
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			else {// 입력인경우 : 기존 데이터(SELECT)가 없는경우
				try {
					AddressVO paVO = new AddressVO();
					paVO.setCommand("insert");
					//다이얼로그창으로 부터 입력된 값을 읽어서 paVO에 담기
					// 입력은 입력 받아서 paVO에 넣고 오라클 DB에 넣어주는 거기 때문에 aVO의 getID가 아닌 해당 클래스의 getid로 넣는다
					paVO.setId(getID()); 
					paVO.setName(getName());
					paVO.setHp(getHP());
					paVO.setAddress(getAddr());
					paVO.setGender(getGender());
					paVO.setBirthday(getBirth());
					paVO.setComments(getComment());
					//이 다음 컨트롤러 쪽으로 연결시켜 넘겨주면 된다.
					//컨트롤 계층에 데이터 입력을 의뢰하고 입력이 성공되면 
					//자식창은 닫고 부모창은 refresh(새로고침) 처리한다.
					AddressBookCtrl aCtrl = new AddressBookCtrl();
					AddressVO raVO = aCtrl.send(paVO);
					if(raVO!=null) {
						if(raVO.getStatus()==1) { //입력성공(Status가 1인경우)
							//(부모클래스, "입력할텍스트")
							JOptionPane.showMessageDialog(aBook, "입력성공");
							this.dispose();
							aBook.refreshData();
						}else {
							JOptionPane.showMessageDialog(aBook, "입력실패");							
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		//취소버튼을 눌렀을때 창이 꺼지게해주는 코드 작성
		if ("취소".equals(label)) {
			this.dispose();
		}

	}
	/*
	 * public static void main(String args[]) { SubBook sBook = new SubBook();
	 * sBook.initDisplay(); }
	 */
}