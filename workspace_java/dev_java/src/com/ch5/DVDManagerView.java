package com.ch5;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.DVD.RSOracleServer;

public class DVDManagerView {
	///선언부- 선언부에서 메소드 호출 불가
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
	//////////////////////// 메뉴바 추가하기 끝 ////////////////////////////
	//이 속지에 조회, 입력, 수정, 삭제 버튼 추가하기 - FlowLayout
	JPanel jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JFrame jf_dvd = new JFrame();
	///생성자 - 생성자는 절대로 리턴타입을 가질 수 없다.
	//테이블 헤더에 들어갈 이름들 담기
	String cols[] = {"대여날짜", "이름", "DVD명", "전화번호", "주소", "반납일자"};
	//오라클서버에 조회한 결과를 담을 2차배열 선언
	String data[][] = new String[5][6];
	//실제 데이터를 담을 수 있는 클래스 생성하기
	DefaultTableModel dtm_rent = new DefaultTableModel(data,cols);
	//실제 테이블을 그려줄 클래스 생성(화면, Form, 양식만 제공)
	JTable jt_rent = new JTable(dtm_rent);
	//바닥속지->JTable->DefaltTableModel->cols, data이용
	JScrollPane jsp_rent = new JScrollPane(jt_rent,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			                               JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
/*****************************************************************************************************
 * 학습목표
 * 나는 인스턴스화를 할 때 적절한 생성자를 사용할 수 있다. -파라미터와 타입맞추기
 * 나는 인스턴스 변수를 활용하여 메소드를 호출 할 수 있다.
 * 나는 메소드 호출시 파라미터 혹은 리턴타입을 활용할 수 있다.
 * 
 * 오라클서버에 자바언어를 활용하여 접속하기
 * 사전필요 - SELECT문 작성하고 StringBuilder클래스에 저장
 * SELECT문 요청 
 * 1단계 - 물리적으로 떨어져 있는 오라클 서버에 연결통로 확보(오라클 드라이버클래스도 스캔)
 * 2단계 - 쿼리문을 오라클서버에 전달해줄 클래스가 필요함. PreparedStatment(인터페이스)
 *       만일 WHERE절이 있을 경우 파라미터로 사용자가 입력한 값을 넘김.
 * 3단계 - 오라클서버에게 처리 요청
 *       a) SELECT인 경우 - 커서를 조작해야 함.커서를 이동할 땐 next() 호출-인스턴스화-클래스이름
 *                        ResultSet(오라클의 커서를 이동할때 사용하는 인터페이스)
 *                        Result rs = pstmt.executeQuert():ResultSet
 *       b) INSERT|UPDATE|DELETE - 커서가 필요없음.
 *          int result = pstmt.executUpdate() : int
 *****************************************************************************************************/

	public DVDManagerView() {}
	//DVD목록 조회 구현
	public void getDVDList(String dvd_title) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r_date,memname,mov_title,phonenum,address,returndate");
		sql.append("  FROM rental r, mem m, dvd d, rendetail rd                ");
		sql.append(" WHERE m.memid = r.memid                                   ");
		sql.append("    AND rd.serialnum = d.serialnum                         ");
		sql.append("    AND r.r_num = rd.r_num                                 ");
		sql.append("ORDER BY r_date desc                                       ");
		try {
			Class.forName(RSOracleServer._DRIVER);
			C
		} catch
	} 
	//화면처리구현 메소드
	public void initDisplay() {
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		//버튼의 색바꾸기
		jbtn_sel.setBackground(new Color(132,13,245));
		jbtn_sel.setForeground(new Color(255,255,255));
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
		jf_dvd.add("North",jp_north);
		jf_dvd.add("Center",jsp_rent);
		jf_dvd.setSize(700, 500);
		jf_dvd.setVisible(true);
	}
	///메인메소드
	public static void main(String[] args) {
		DVDManagerView dvd = new DVDManagerView();
		dvd.initDisplay();
	}

}