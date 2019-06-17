package com.address;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AddressBook extends JFrame {
	///*** 선언부 ***///
	SubBook subBook = null;
	//싱글톤 선언
	static AddressBook aBook = null;
	//버튼을 붙여줄 패널 선언
	JPanel jp_north = new JPanel();
	//버튼을 만들어줄 객체 선언
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JButton jbtn_det = new JButton("상세조회");
	//전체조회를 위한 버튼 선언
	JButton jbtn_lis = new JButton("전체조회");
	//헤더 정보를 담을 객체 추가
	String cols[] = {"아이디", "이름", "주소", "HP"};
	//데이터를 담을 2차원 배열 추가
	String data[][] = new String[0][4]; //헤더는 0 컬럼은 4개
	//데이터를 담을 수 있는 클래스 추가
	DefaultTableModel dtm_address = new DefaultTableModel(data, cols);
	//주소록을 보여줄 테이블을 만듬. JTable은 단순히 화면만 제공해주는 것
	//그러므로 JTable에 실제 데이터를 담을 수 있는 DefaultTableModel을 넣어준다
	JTable jt_address = new JTable(dtm_address);
	//스크롤바를 나타내는 객체 생성
	JScrollPane jsp_address = new JScrollPane(jt_address);
	//헤더의 간격을 조정해줄 객체 생성
	JTableHeader jth_address = jt_address.getTableHeader();//new 없이 제공되는 api로 객체를 생성
	
	///** 생성자  **///
	public AddressBook() { //생성자를 호출 할 경우 initDisplay 메소드 실행
		initDisplay();
	}
	
	///*  화면을 구성하는 메소드 설계   *///
	public void initDisplay() {
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
			@Override
			public void windowClosed(WindowEvent e) {

			}
			@Override
			public void windowClosing(WindowEvent e) {
				//finally 예외처리
				//자원 반납(알아서 Terminate 처리가 된다.)
				System.exit(0);// 가상머신과 어플사이에 연결고리 끊김
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//입력, 수정, 상세조회 버튼을 눌렀을 때 이벤트처리를 ActionListener로 보내주는 코드
		//new ActionListener()로 넣을 수 없다. 구현체 클래스가 없기 때문
		//하지만 위와 같은 방법으로해서 메소드를 만들어 주면 가능하다
		jbtn_ins.addActionListener(new ActionListener() {
			// 익명클래스, 하나의 클래스를 생성한 것으로 인정한다.
			@Override
			public void actionPerformed(ActionEvent e) {
				insertActionPerforemed(e);
			}
		}); 
		jbtn_upd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateActionPerforemed(e);
			}
		});
		jbtn_det.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				detailActionPerforemed(e);
			}
		}); 
		//전체조회 버튼 액션리스너
		jbtn_lis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listActionPerforemed(e);
			}
		});
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerforemed(e);
			}
		});
		//패널속지에 버튼을 붙히는 코드 작성
		jp_north.setLayout(new FlowLayout());
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		jp_north.add(jbtn_det);
		jp_north.add(jbtn_lis);
		//JFrame에 패널을 추가해주는 코드 작성
		this.add("North", jp_north); //북쪽에 패널(버튼이 있는)을 추가해줌
		this.add("Center", jsp_address); //스크롤이 붙어있는 데이타 그리드를 추가해줌
		this.setSize(700, 500);
		this.setVisible(true);
		//테이블 헤더의 폰트 및 스타일 지정
		jth_address.setFont(new Font("맑은고딕",Font.BOLD,18));
		jth_address.setBackground(new Color(22,22,100));
		jth_address.setForeground(Color.white);
		jt_address.setGridColor(Color.blue);
		//헤더들이 이동하지 못하도록 잠금하는 메소드 호출
		jth_address.setReorderingAllowed(false);
		//헤더들의 크기를 조정하지못하도록 잠금하는 메소드 호출
		jth_address.setResizingAllowed(false);
		//싱글 선택 가능하도록 하기
		jt_address.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//헤더간의 간격을 조정하는 메소드 호출
		jt_address.getColumnModel().getColumn(0).setPreferredWidth(80);
		jt_address.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt_address.getColumnModel().getColumn(2).setPreferredWidth(390);
		jt_address.getColumnModel().getColumn(3).setPreferredWidth(130);
		//테이블의 화면을 새로 갱신해주는 메소드 호출
		jt_address.repaint();
		refreshData();
	}
	

	//** 전체조회버튼 **//
	protected void listActionPerforemed(ActionEvent e) {
		System.out.println("새로고침 처리");
		while (dtm_address.getRowCount() > 0) {
			dtm_address.removeRow(0); // 데이터의 건수만큼 0번째 로우를 삭제한다
		}
		AddressBookCtrl aCtrl = new AddressBookCtrl();
		List<AddressVO> list = aCtrl.send("select");
			for (int i=0; i<list.size(); i++) {
				AddressVO raVO = list.get(i);
				//Vector를 생성한 이유는 DB에서 꺼낸값을 행단위로 dtm_address에
				//추가할 수 있는 addRow(Vector|Object[])라는 메소드에 파라미터로 넣기 위함이다.
				Vector rowData = new Vector();
				rowData.add(0, raVO.getId());
				rowData.add(1, raVO.getName());
				rowData.add(2, raVO.getAddress());
				rowData.add(3, raVO.getHp());
				dtm_address.addRow(rowData);
		}
	}
	//** 삭제버튼 **//
	protected void deleteActionPerforemed(ActionEvent e) {
		int index = jt_address.getSelectedRow();
		if(index<0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		} else {
			try {
				//paVO에 담을 정보는 command = "delete" 와 id -> u_id
				AddressVO paVO = new AddressVO();
				AddressVO raVO = null;
				String u_id = null;
				//여러건을 다 수집하여 삭제하려면 -> 멀티로우 처리
				for(int i=0; i<dtm_address.getRowCount();i++) {
					//테이블에서 선택한 로우가 있는지 체크하여 있으면 true
					//없으면 false를 반환하는 메소드
					if(jt_address.isRowSelected(i)) {
						//getValueAt(로우인덱스값,컬럼자리값) 파라미터 두개 주면
						//그 위치의 값을  가져오는 메소드임.
						u_id = (String)dtm_address.getValueAt(i, 0);
						AddressBookCtrl aCtrl = new AddressBookCtrl();
						//AddressVO의 command변수에 delete값을 저장하는 메소드 호출
						paVO.setCommand("delete");
						//AddressVO의 id변수에 u_id에 담긴 값을 저장하는 메소드 호출
						paVO.setId(u_id);
						//AddressBookCtrl의 send메소드 호출 시 파라미터로 paVO 넘겨 호출
						raVO = aCtrl.send(paVO);
					}
				}
				//raVO에 status변수에 저장된 값을 반환하는 메소드 호출하여 1과 비교함.
				//1이면 삭제 성공을 0이면 살제 실패를 의미함.
				//이 때 1과 0은 오라클서버에서 반환값으로 줌.
				if(raVO.getStatus()==1) { //삭제 성공
					//삭제 성공시 삭제된 로우를 제외한 나머지 로우를 가져오기 위해 다시 select문을 실행함.
					//데이터 새로고침
					refreshData();
				} else {//raVO에 저장된 값이 0인 경우 삭제가 안된 경우이므로 메세지 처리함.
					JOptionPane.showMessageDialog(this, "삭제 실패");
					//메세지를 내보내고 나면
					//deleteActionPerformed 메소드 탈출시킴. - 다시 이용하도록 유도함.
					return;// deleteActionPerformed 탈출
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	//** 상세조회버튼 **//
	protected void detailActionPerforemed(ActionEvent e) {
		String label = e.getActionCommand();
		// 이벤트 어디다 걸지? - JTable(폼, 이벤트), DefaultTableModel(값을 저장, 값을 입력)
		// index는 0부터 시작
		int index = jt_address.getSelectedRow();
		// 로그를 출력할 때 - 주의사항
		// main를 가진 클래스는 sysout으로 처리하면 됨
		// main이 없는 클래스는 JOptionPane.showMessageDialog();로 처리한다.
		if(index<0) { 
			JOptionPane.showMessageDialog(this, "조회할 데이터를 한 건만 선택하세요.","Error",JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			try {
				// 선택한 후에 상세조회 화면이 열리면 기존에 선택한것 선택해제
				jt_address.clearSelection();
				AddressVO paVO = new AddressVO();
				//선택한 로우의 id를 받아오는 코드
				String u_id = (String)dtm_address.getValueAt(index, 0);
				paVO.setId(u_id);
				paVO.setCommand("detail");
				AddressBookCtrl aCtrl = new AddressBookCtrl();
				AddressVO raVO = aCtrl.send(paVO);
				subBook = null;
				subBook = new SubBook();
				subBook.set(raVO, label, aBook, false);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	//** 수정버튼 **//
	protected void updateActionPerforemed(ActionEvent e) {
		String label = e.getActionCommand();
		subBook = null;
		subBook = new SubBook();
		subBook.set(new AddressVO(), label, aBook, true);
	}

	//** 입력버튼 **//
	protected void insertActionPerforemed(ActionEvent e) {
		String label = e.getActionCommand();
		subBook = null;
		subBook = new SubBook();
		//입력 할때는 백지 상태에 값을 입력하기 때문에 null을 적어준다.
		subBook.set(null, label, this, true);
	}

	///* 새로고침 처리 메소드 설계  *///
	public void refreshData() {
		System.out.println("새로고침 처리");
		//이미 테이블에 있떤 데이터는 삭제한다.
		while (dtm_address.getRowCount() > 0) {
			dtm_address.removeRow(0); // 데이터의 건수만큼 0번째 로우를 삭제한다
		}
		AddressBookCtrl aCtrl = new AddressBookCtrl();
		List<AddressVO> list = aCtrl.send("select");
		if((list==null) || (list.size()==0)) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다");
		} else {
			for (int i=0; i<list.size(); i++) {
				AddressVO raVO = list.get(i);
				//Vector를 생성한 이유는 DB에서 꺼낸값을 행단위로 dtm_address에
				//추가할 수 있는 addRow(Vector|Object[])라는 메소드에 파라미터로 넣기 위함이다.
				Vector rowData = new Vector();
				rowData.add(0, raVO.getId());
				rowData.add(1, raVO.getName());
				rowData.add(2, raVO.getAddress());
				rowData.add(3, raVO.getHp());
				dtm_address.addRow(rowData);
			}
		}
	}
	/// * 싱글톤 선언 *  ///
	public static AddressBook getInstance() {
		if (aBook==null) {
			aBook = new AddressBook();
		}
		return aBook;
	}
}