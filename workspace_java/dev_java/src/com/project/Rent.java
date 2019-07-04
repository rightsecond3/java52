package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//DVD관리
public class Rent extends JPanel {
	JPanel jp_north = new JPanel();
	JPanel jp_north_second = new JPanel();
	JPanel jp_north_first = new JPanel();
	String cols[] = {"대여번호","회원번호","이름","전화번호","대여일"
			,"반납일","반납예정일","연체료"};
	String data[][] = new String[0][];
	DefaultTableModel dtm_dvdList = new DefaultTableModel(data,cols) {
		@Override
		public boolean isCellEditable(int row, int cols) {
			return false;
		}
	};
	JLabel jl_title = new JLabel("대여관리");
	JButton jbtn_det = new JButton("상세조회");
	JButton jbtn_sel = new JButton("검색");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	String searchLabel[] = {"대여번호","이름","대여일"};
	JComboBox jcb_search = new JComboBox(searchLabel);
	JTextField jtf_keyword = new JTextField("",50);
	//생성자의 파라미터에 DefaultTableModel주소번지를 넘겨서 화면과 테이블을 동기화
	JTable			  jt_dvdList  = new JTable(dtm_dvdList);
	JTableHeader  	  jth_dvdList = jt_dvdList.getTableHeader();
	JScrollPane       jsp_dvdList = new JScrollPane(jt_dvdList);// 최종속지
	String keyword = null;
	String label = null;
	String combobox = null;
	RentVO rVO = null;
	SubRent subRent=null;
	
	public Rent() {
		initDisplay();
	}
	
	///* 새로고침 처리 메소드 설계 *///
	public void refreshData() {
		this.keyword = jtf_keyword.getText();
		this.combobox = (String) jcb_search.getSelectedItem();
		while (dtm_dvdList.getRowCount()>0) {
			dtm_dvdList.removeRow(0);
		}
		RentCtrl rCtrl = new RentCtrl();
		RentVO paVO = new RentVO();
		paVO.setKeyword(keyword);
		paVO.setCombobox(combobox);
		List<Map<String,Object>> list = rCtrl.send("select", paVO);
		Iterator<Map<String,Object>> it = list.iterator();
		Object keys[] = null;
		if((list==null)||(list.size()==0)) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
		} else {
			while(it.hasNext()) {
				Map<String, Object> data = it.next();
				keys = data.keySet().toArray();
				Vector rowData = new Vector();
				rowData.add(data.get(keys[5]));//대여번호
				rowData.add(data.get(keys[7]));//회원번호
				rowData.add(data.get(keys[0]));//이름
				rowData.add(data.get(keys[6]));//전화번호
				rowData.add(data.get(keys[3]));//대여일
				rowData.add(data.get(keys[1]));//반납일
				rowData.add(data.get(keys[2]));//반납예정일
				rowData.add(data.get(keys[4]));//연체료
				
				dtm_dvdList.addRow(rowData);
			}
		}
	}
	//** 화면 처리부 **//
	private void initDisplay() {
		//이벤트 처리
		jbtn_sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshData();
			}
		});
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
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
		//Table 마우스 클릭
		jt_dvdList.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					RenDetail rd = null;
					String u_rnum=(String)dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0);
					System.out.println(u_rnum);
					rd = new RenDetail(u_rnum);
				}
			}
		});
		//테이블 헤더 위치 변경 금지하기
		jt_dvdList.getTableHeader().setReorderingAllowed(false);
		//테이블 컬럼 폭 지정하기
		jt_dvdList.getColumnModel().getColumn(0).setPreferredWidth(70);
		jt_dvdList.getColumnModel().getColumn(1).setPreferredWidth(120);
		//테이블 헤더 배경색 변경
		jt_dvdList.getTableHeader().setBackground(new Color(255, 232, 170));
		// 화면에 컴포넌트 붙히기
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
		jp_north.setLayout(new GridLayout(2,1));
		jp_north.add(jp_north_second);
		jp_north.add(jp_north_first);
		this.setLayout(new BorderLayout());
		this.add("North", jp_north);
		this.add("Center", jsp_dvdList);
		this.setSize(900,900);
		this.setVisible(true);
		refreshData();
	}
	//** 상세조회 버튼 **//
	protected void detailActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subRent = null;
		subRent = new SubRent();
		RentVO rVO = new RentVO();
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하세요");
			return;
		} else {
			try {
				rVO.setR_num(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString());
				rVO.setR_date(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 4).toString());
				rVO.setReturndate(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 5).toString());
				rVO.setDuedate(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 6).toString());
				rVO.setLatefee(Integer.parseInt(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 7).toString()));
				rVO.setMemid(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 1).toString());
				subRent.set(rVO, label, this, false);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	//** 수정 버튼 **//
	protected void updateActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subRent = null;
		subRent = new SubRent();
		RentVO rVO = new RentVO();
		int index = jt_dvdList.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요");
			return;
		} else {
			try {
				rVO.setR_num(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 0).toString());
				rVO.setR_date(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 4).toString());
				rVO.setReturndate(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 5).toString());
				rVO.setDuedate(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 6).toString());
				rVO.setLatefee(Integer.parseInt(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 7).toString()));
				rVO.setMemid(dtm_dvdList.getValueAt(jt_dvdList.getSelectedRow(), 1).toString());
				subRent.set(rVO, label, this, true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	//** 입력 버튼 이벤트 처리 **//
	protected void insertActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subRent = null;
		subRent = new SubRent();
		subRent.set(null, label, this, true);
		
	}

	//** 삭제버튼 구현 **//
	protected void deleteActionPerformed(ActionEvent e) {
		int index = jt_dvdList.getSelectedRow();
		if(index<0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		} else {
			try {
				RentVO paVO = new RentVO();
				RentVO raVO = null;
				String u_rnum = null;
				for (int i = 0; i < dtm_dvdList.getRowCount(); i++) {
					if (jt_dvdList.isRowSelected(i)) {
						u_rnum = (String) dtm_dvdList.getValueAt(i, 1);
						RentCtrl rCtrl = new RentCtrl();
						paVO.setCommand("delete");
						paVO.setR_num(u_rnum);
						raVO = rCtrl.send(paVO);
					}
				}
				if (raVO.getStatus()==1) {
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
}
