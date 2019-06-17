package DVDproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.address.AddressBookCtrl;
import com.address.AddressVO;

public class DVDRent implements MouseListener, KeyListener{
	///선언부- 선언부에서 메소드 호출 불가
	int count = 0;
	private static DVDRent dRent = null;
	//////////////////////// 메뉴바 추가하기 시작 ///////////////////////////
	JMenuBar jmb_dvd = new JMenuBar();
	JMenu    jm_member = new JMenu("회원관리");
	JMenuItem jmi_msig = new JMenuItem("회원가입");
	JMenuItem jmi_mupd = new JMenuItem("회원정보수정");
	JMenuItem jmi_mdel = new JMenuItem("회원탈퇴");
	JMenu    jm_rent = new JMenu("대여관리");
	JMenuItem jmi_rsig = new JMenuItem("대여등록");
	JMenuItem jmi_rupd = new JMenuItem("대여수정");
	JMenuItem jmi_rdel = new JMenuItem("대여삭제");
	JMenu    jm_dvd = new JMenu("DVD관리");
	JMenuItem jmi_dsig = new JMenuItem("DVD등록");
	JMenuItem jmi_dupd = new JMenuItem("DVD수정");
	JMenuItem jmi_ddel = new JMenuItem("DVD삭제");
	JMenu    jm_point = new JMenu("POINT관리");
	JMenuItem jmi_pupd = new JMenuItem("POINT 수정");
	JMenu    jm_sales = new JMenu("매출관리");
	JMenuItem jmi_sday = new JMenuItem("일별매출");
	JMenuItem jmi_smon = new JMenuItem("월별매출");
	JMenuItem jmi_syear = new JMenuItem("연도별매출");
	//////////////////////// 메뉴바 추가하기 끝 ///////////////////////////
	//////////////////////// 검색기 추가 시작 ///////////////////////////
	String searchLabel[] = {"DVD명","이름","대여날짜"};
	JComboBox jcb_search = new JComboBox(searchLabel);
	JTextField jtf_keyword = new JTextField("검색할 키워드를 입력하세요.",50);
	//////////////////////// 검색기 추가 끝  ///////////////////////////
	//이 속지에 조회, 입력, 수정, 삭제 버튼 추가하기 - FlowLayout
	JPanel jp_north = new JPanel(); //GridLayout써서 두개 영역쪼갬.
	JPanel jp_north_second = new JPanel();//검색기추가
	JPanel jp_north_first = new JPanel();//기존 버튼 4개 이관
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JFrame jf_dvd = new JFrame();
	///생성자 - 생성자는 절대로 리턴타입을 가질 수 없다.
	//테이블 헤더에 들어갈 이름들 담기
	String cols[] = {"대여날짜", "이름", "DVD명", "전화번호", "주소", "반납일자"};
	//오라클서버에 조회한 결과를 담을 2차배열 선언
	String data[][] = new String[0][6];
	//실제 데이터를 담을 수 있는 클래스 생성하기
	DefaultTableModel dtm_rent = new DefaultTableModel(data,cols);
	//실제 테이블을 그려줄 클래스 생성(화면, Form, 양식만 제공)
	JTable jt_rent = new JTable(dtm_rent);
	//바닥속지->JTable->DefaltTableModel->cols, data이용
	JScrollPane jsp_rent = new JScrollPane(jt_rent,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                               JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	///*** 생성자 ***///
	public DVDRent() {
		jbtn_sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectActionPerformed(e);
			}
		});
		jtf_keyword.addMouseListener(this);
//		jtf_keyword.addActionListener(this);
		jtf_keyword.addKeyListener(this);
		jp_north.setLayout(new GridLayout(2,1)); //로우가 2개 컬럼이 1개
		jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_second.add(jcb_search);
		jp_north_second.add(jtf_keyword);
		jp_north_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_first.add(jbtn_sel);
		jp_north_first.add(jbtn_ins);
		jp_north_first.add(jbtn_upd);
		jp_north_first.add(jbtn_del);
		//버튼의 색바꾸기
//		jbtn_sel.setBackground(new Color(123,131,245));
//		jbtn_sel.setForeground(new Color(255,255,255));
		//테이블 헤더 위치 변경 금지하기
		jt_rent.getTableHeader().setReorderingAllowed(false);
		//테이블 컬럼 폭 지정하기
		jt_rent.getColumnModel().getColumn(0).setPreferredWidth(70);
		jt_rent.getColumnModel().getColumn(1).setPreferredWidth(120);
		//테이블 헤더 배경색 변경
		jt_rent.getTableHeader().setBackground(new Color(130,160,160));
		//테이블 헤더 글자색 변경
		jt_rent.getTableHeader().setForeground(Color.white);
		jf_dvd.setTitle("DVD대여관리시스템 Ver1.0");
		jm_member.add(jmi_msig);
		jm_member.add(jmi_mupd);
		jm_member.add(jmi_mdel);
		jmb_dvd.add(jm_member);
		
		jm_rent.add(jmi_rsig);
		jm_rent.add(jmi_rupd);
		jm_rent.add(jmi_rdel);
		jmb_dvd.add(jm_rent);
		
		jm_dvd.add(jmi_dsig);
		jm_dvd.add(jmi_dupd);
		jm_dvd.add(jmi_ddel);
		jmb_dvd.add(jm_dvd);
		
		jm_point.add(jmi_pupd);
		jmb_dvd.add(jm_point);
		
		jm_sales.add(jmi_sday);
		jm_sales.add(jmi_smon);
		jm_sales.add(jmi_syear);
		jmb_dvd.add(jm_sales);
		
		jf_dvd.setJMenuBar(jmb_dvd); //jmb_dvd의 주소번지가 전달됨
		jp_north.add(jp_north_second);
		jp_north.add(jp_north_first);
		jf_dvd.add("North",jp_north);
		jf_dvd.add("Center",jsp_rent);
		jf_dvd.setSize(700, 500);
		jf_dvd.setVisible(true);
	}
	
	//** 조회버튼 이벤트 **//
	protected void selectActionPerformed(ActionEvent e) {
		String keyword = jtf_keyword.getText();
		String combobox = (String)jcb_search.getSelectedItem();
		DVDVO paVO = new DVDVO();
		paVO.setCommand("select");
		paVO.setKeyword(keyword);
		paVO.setCombobox(combobox);
		refreshData(paVO);                                                                                           
	}

	/// * 싱글톤 선언 * ///
	public static DVDRent getInstance() {
		if (dRent==null) {
			dRent = new DVDRent();
		}
		return dRent;
	}
	
	//** 새로고침 메소드 생성 **//
	public void refreshData(DVDVO paVO) {
		System.out.println("새로고침 처리");
		while (dtm_rent.getRowCount() > 0) {
			dtm_rent.removeRow(0); // 데이터의 건수만큼 0번째 로우를 삭제한다
		}
		DVDCtrl aCtrl = new DVDCtrl();
		List<DVDVO> list = aCtrl.sendList(paVO);
			for (int i=0; i<list.size(); i++) {
				DVDVO raVO = list.get(i);
				//Vector를 생성한 이유는 DB에서 꺼낸값을 행단위로 dtm_address에
				//추가할 수 있는 addRow(Vector|Object[])라는 메소드에 파라미터로 넣기 위함이다.
				Vector rowData = new Vector();
				rowData.add(0, raVO.getR_date());
				rowData.add(1, raVO.getMemname());
				rowData.add(2, raVO.getMov_title());
				rowData.add(3, raVO.getPhonenum());
				rowData.add(4, raVO.getAddress());
				rowData.add(5, raVO.getReturndate());
				dtm_rent.addRow(rowData);
		}
	}

	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			System.out.println("엔터키입력");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(count==0) {
			jtf_keyword.setText("");//해결 마우스가 눌릴때마다 텍스트가 초기화됨
		}
		count++;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
