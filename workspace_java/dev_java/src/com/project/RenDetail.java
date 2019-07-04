package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class RenDetail extends JFrame {
	JPanel jp_north = new JPanel();
	JPanel jp_north_second = new JPanel();
	JPanel jp_north_first = new JPanel();
	String cols[] = { "대여상세번호", "시리얼번호", "DVD명", "대여료" };
	String data[][] = new String[0][];
	DefaultTableModel dtm_dvdList = new DefaultTableModel(data, cols){
		@Override
		public boolean isCellEditable(int row, int cols) {
			return false;
		}
	};
	JButton jbtn_det = new JButton("상세조회");
	JButton jbtn_sel = new JButton("검색");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	String searchLabel[] = { "대여상세번호", "시리얼번호", "DVD명" };
	JComboBox jcb_search = new JComboBox(searchLabel);
	JTextField jtf_keyword = new JTextField("", 20);
	JTable jt_dvdList = new JTable(dtm_dvdList);
	JTableHeader jth_dvdList = jt_dvdList.getTableHeader();
	JScrollPane jsp_dvdList = new JScrollPane(jt_dvdList);// 최종속지
	String keyword = null;
	String label = null;
	String combobox = null;
	String u_rnum = null;
	SubRenDetial subDetail = null;
	RenDetailVO rdVO = null;

	public RenDetail() {
	}

	public RenDetail(String u_rnum) {
		this.u_rnum = u_rnum;
		initDisplay();
	}

	private void initDisplay() {
		// 이벤트 처리부
		jbtn_sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshData();
			}
		});
		jbtn_ins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertActionPerformed(e);
			}
		});
		jbtn_upd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
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
		jt_dvdList.getColumnModel().getColumn(0).setPreferredWidth(100);
		jt_dvdList.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt_dvdList.getColumnModel().getColumn(2).setPreferredWidth(200);
		jt_dvdList.getColumnModel().getColumn(3).setPreferredWidth(100);//
		//테이블 헤더 배경색 변경
		jt_dvdList.getTableHeader().setBackground(new Color(255, 232, 170));
		// 화면 입히기
		jp_north_second.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_first.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north_second.add(jcb_search);
		jp_north_second.add(jtf_keyword);
		jp_north_second.add(jbtn_sel);
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
		this.setTitle(u_rnum + "_대여상세");
		this.setSize(500, 500);
		this.setVisible(true);
		refreshData();
	}
	// ** 상세조회버튼 구현 **//
	protected void detailActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subDetail = null;
		subDetail = new SubRenDetial();
		RenDetailVO rdVO = new RenDetailVO();
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		} else {
			try {
				rdVO.setR_num(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString().substring(0, 7));
				rdVO.setR_detailnum(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString().substring(8));
				rdVO.setSerialnum(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 1).toString());
				subDetail.set(rdVO, label, this, false, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	// ** 삭제버튼 구현 **//
	protected void deleteActionPerformed(ActionEvent e) {
		int index = jt_dvdList.getSelectedRow();	
		if(index<0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		} else {
			try {
				RenDetailVO rdpaVO = new RenDetailVO();
				RenDetailVO rdraVO = null;
				String u_rnum = null;
				String u_rdnum = null;
				for (int i = 0; i < dtm_dvdList.getRowCount(); i++) {
					if (jt_dvdList.isRowSelected(i)) {
						u_rnum = (String) dtm_dvdList.getValueAt(i, 0);
						u_rdnum = (String) dtm_dvdList.getValueAt(i, 0);
						u_rnum = u_rnum.substring(0, 7);
						u_rdnum = u_rdnum.substring(8);
						RenDetailCtrl rdCtrl = new RenDetailCtrl();
						rdpaVO.setCommand("delete");
						rdpaVO.setR_num(u_rnum);
						rdpaVO.setR_detailnum(u_rdnum);
						rdraVO = rdCtrl.send(rdpaVO);
					}
				}
				if (rdraVO.getStatus() == 1 ) {
					refreshData();
				} else {
					JOptionPane.showMessageDialog(this, "삭제 실패");
					return;
				}
			} catch(Exception e2) {
				
			}
		}
		
	}
	protected void updateActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subDetail = null;
		subDetail = new SubRenDetial();
		RenDetailVO rdVO = new RenDetailVO();
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요.");
			return;
		} else {
			try {
				rdVO.setR_num(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString().substring(0, 7));
				rdVO.setR_detailnum(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString().substring(8));
				rdVO.setSerialnum(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 1).toString());
				subDetail.set(rdVO, label, this, true, null);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	protected void insertActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subDetail = null;
		subDetail = new SubRenDetial();
		subDetail.set(null, label, this, true, u_rnum);
	}

	public void refreshData() {
		this.keyword = jtf_keyword.getText();
		this.combobox = (String) jcb_search.getSelectedItem();
		while (dtm_dvdList.getRowCount() > 0) {
			dtm_dvdList.removeRow(0);
		}
		RenDetailCtrl rdCtrl = new RenDetailCtrl();
		RenDetailVO paVO = new RenDetailVO();
		paVO.setU_rnum(u_rnum);
		paVO.setKeyword(keyword);
		paVO.setCombobox(combobox);
		List<Map<String, Object>> list = rdCtrl.send("select", paVO);
		Iterator<Map<String, Object>> it = list.iterator();
		Object keys[] = null;
		if ((list == null) || (list.size() == 0)) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
		} else {
			while (it.hasNext()) {
				Map<String, Object> data = it.next();
				keys = data.keySet().toArray();
				Vector rowData = new Vector();
				rowData.add(data.get(keys[0]));//
				rowData.add(data.get(keys[1]));//
				rowData.add(data.get(keys[2]));//
				rowData.add(data.get(keys[3]));//
				dtm_dvdList.addRow(rowData);
			}
		}
	}
//	public static void main(String[] args) {
//		RenDetail rd = new RenDetail();
//		rd.initDisplay();
//
//	}

}
