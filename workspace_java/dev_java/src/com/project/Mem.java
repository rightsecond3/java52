package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.address.AddressBookCtrl;
import com.address.AddressVO;

//DVD관리
public class Mem extends JPanel {
	JPanel jp_north = new JPanel();
	JPanel jp_north_second = new JPanel();
	JPanel jp_north_first = new JPanel();
	String cols[] = { "아이디", "이름", "집번호", "HP", "Zipcode", "주소", "등록일", "비밀번호" };
	String data[][] = new String[0][];
	DefaultTableModel dtm_dvdList = new DefaultTableModel(data, cols){
		@Override
		public boolean isCellEditable(int row, int cols) {
			return false;
		}
	};
	JLabel jl_title = new JLabel("회원관리");
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JButton jbtn_det = new JButton("상세조회");
	String searchLabel[] = { "아이디", "이름", "등록일" };
	JComboBox jcb_search = new JComboBox(searchLabel);
	JTextField jtf_keyword = new JTextField("", 50);
	// 생성자의 파라미터에 DefaultTableModel주소번지를 넘겨서 화면과 테이블을 동기화
	JTable jt_dvdList = new JTable(dtm_dvdList);
	JTableHeader jth_dvdList = jt_dvdList.getTableHeader();
	JScrollPane jsp_dvdList = new JScrollPane(jt_dvdList);// 최종속지
	Mem dMem = null;
	DVDSup dSup = null;
	SubMem subMem = null;
	String keyword = null;
	String combobox = null;
	String label = null;

	public Mem() {
		initDisplay();
	}

	private void initDisplay() {
		// 액션리스너 구현
		jbtn_sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectActionPerformed(e);
			}
		});
		// 입력
		jbtn_ins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertActionPerformed(e);
			}
		});
		// 삭제
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		jbtn_upd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}

		});
		jbtn_det.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				detailActionPerformed(e);
			}
		});
		jtf_keyword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10) {
					refreshData();
				}
			}
		});
		//테이블 헤더 위치 변경 금지하기
		jt_dvdList.getTableHeader().setReorderingAllowed(false);
		//테이블 컬럼 폭 지정하기
		jt_dvdList.getColumnModel().getColumn(0).setPreferredWidth(80);
		jt_dvdList.getColumnModel().getColumn(1).setPreferredWidth(80);
		jt_dvdList.getColumnModel().getColumn(2).setPreferredWidth(120);
		jt_dvdList.getColumnModel().getColumn(3).setPreferredWidth(120);//
		jt_dvdList.getColumnModel().getColumn(4).setPreferredWidth(80);//
		jt_dvdList.getColumnModel().getColumn(5).setPreferredWidth(150);//
		jt_dvdList.getColumnModel().getColumn(6).setPreferredWidth(100);//
		jt_dvdList.getColumnModel().getColumn(7).setPreferredWidth(80);//
		//테이블 헤더 배경색 변경
		jt_dvdList.getTableHeader().setBackground(new Color(255, 232, 170));
		// 패널 뷰 구현
		jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_second.add(jcb_search);
		jp_north_second.add(jtf_keyword);
		jp_north_second.add(jbtn_sel);		
		jp_north_first.add(jl_title);
		jp_north_first.add(jbtn_det);
		jp_north_first.add(jbtn_ins);
		jp_north_first.add(jbtn_upd);
		jp_north_first.add(jbtn_del);
		jp_north.setLayout(new GridLayout(2, 1));
		jp_north.add(jp_north_second);
		jp_north.add(jp_north_first);
		this.setLayout(new BorderLayout());
		this.add("North", jp_north);
		this.add("Center", jsp_dvdList);
		this.setSize(900, 900);
		this.setVisible(true);
		refreshData();

	}

	protected void detailActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subMem = null;
		subMem = new SubMem();
		MemVO mVO = new MemVO();
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하세요");
			return;
		} else {
			try {
				mVO.setMemid(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString());
				mVO.setMemname(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 1).toString());
				mVO.setTel(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 2).toString());
				mVO.setPhonenum(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 3).toString());
				mVO.setZipcode(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 4).toString());
				mVO.setAddress(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 5).toString());
				mVO.setResistdate(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 6).toString());
				mVO.setMempw(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 7).toString());
				subMem.set(mVO, label, this, false);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	protected void updateActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subMem = null;
		subMem = new SubMem();
		MemVO mVO = new MemVO();
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요");
			return;
		} else {
			try {
				mVO.setMemid(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString());
				mVO.setMemname(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 1).toString());
				mVO.setTel(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 2).toString());
				mVO.setPhonenum(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 3).toString());
				mVO.setZipcode(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 4).toString());
				mVO.setAddress(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 5).toString());
				mVO.setResistdate(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 6).toString());
				mVO.setMempw(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 7).toString());
				subMem.set(mVO, label, this, true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	// ** 삭제버튼 구현 **//
	protected void deleteActionPerformed(ActionEvent e) {
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		} else {
			try {
				MemVO mpaVO = new MemVO();
				MemVO mraVO = null;
				String u_memid = null;
				for (int i = 0; i < dtm_dvdList.getRowCount(); i++) {
					if (jt_dvdList.isRowSelected(i)) {
						u_memid = (String) dtm_dvdList.getValueAt(i, 0);
						MemCtrl mCtrl = new MemCtrl();
						mpaVO.setCommand("delete");
						mpaVO.setMemid(u_memid);
						mraVO = mCtrl.send(mpaVO);
					}
				}
				if (mraVO.getStatus() == 1) {
					refreshData();
				} else {
					JOptionPane.showMessageDialog(this, "삭제 실패");
					return;
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// ** 입력버튼 구현 **//
	protected void insertActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subMem = null;
		subMem = new SubMem();
		subMem.set(null, label, this, true);
	}

	// ** 조회버튼 구현 **//
	protected void selectActionPerformed(ActionEvent e) {
		refreshData();
	}

	/// * 새로고침 처리 메소드 설계 *///
	public void refreshData() {
		this.keyword = jtf_keyword.getText();
		this.combobox = (String) jcb_search.getSelectedItem();
		// 이미 테이블에 있떤 데이터는 삭제한다.
		while (dtm_dvdList.getRowCount() > 0) {
			dtm_dvdList.removeRow(0); // 데이터의 건수만큼 0번째 로우를 삭제한다
		}
		MemCtrl dCtrl = new MemCtrl();
		MemVO mpaVO = new MemVO();
		mpaVO.setKeyword(keyword);
		mpaVO.setCombobox(combobox);
		List<MemVO> list = dCtrl.send("select", mpaVO);
		if ((list == null) || (list.size() == 0)) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다");
		} else {
			for (int i = 0; i < list.size(); i++) {
				MemVO raVO = list.get(i);
				// Vector를 생성한 이유는 DB에서 꺼낸값을 행단위로 dtm_address에
				// 추가할 수 있는 addRow(Vector|Object[])라는 메소드에 파라미터로 넣기 위함이다.
				Vector rowData = new Vector();
				rowData.add(0, raVO.getMemid());
				rowData.add(1, raVO.getMemname());
				rowData.add(2, raVO.getTel());
				rowData.add(3, raVO.getPhonenum());
				rowData.add(4, raVO.getZipcode());
				rowData.add(5, raVO.getAddress());
				rowData.add(6, raVO.getResistdate());
				rowData.add(7, raVO.getMempw());
				dtm_dvdList.addRow(rowData);
			}
		}
	}

//	public static void main(String args[]) {
//		DVDList dl = new DVDList();
//	}
}
