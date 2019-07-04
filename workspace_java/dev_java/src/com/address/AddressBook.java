package com.address;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.network.ClientThread;
import com.network.TimeClientVer2;

public class AddressBook extends JFrame {
	//TimeServer에서 읽어들인 시간 정보 출력하기 추가
	JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
	SubBook subBook = null;
	static AddressBook aBook = null;
	JPanel jp_north = new JPanel();
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	JButton jbtn_det = new JButton("상세조회");
	//헤더 정보를 담을 객체 추가
	String cols[] = {"아이디","이름","주소","HP"};
	String data[][] = new String[0][4];
	//데이터를 담을 수 있는 클래스가 필요함
	//DataSet
	DefaultTableModel dtm_address = new DefaultTableModel(data,cols);
	JTable jt_address = new JTable(dtm_address);//화면만 제공함. 그리드만 제공. 데이터는 없다.
	JScrollPane jsp_address = new JScrollPane(jt_address);
	JTableHeader jth_address = jt_address.getTableHeader();
	public void initDisplay() {
		//TimeClientVer2 인스턴스화 하기
		TimeClientVer2 tc = new TimeClientVer2(jlb_time);
		ClientThread ct = new ClientThread(tc);
		ct.start();
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
			@Override
			public void windowClosed(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
				//System.out.println("11");
				//가상머신과 어플사이에 연결고리 끊김
				//finally 예외
				System.exit(0);
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
		jbtn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jbtn_ins.setBackground(new Color(255,219,170));
		jbtn_ins.setForeground(Color.black);
		jbtn_upd.setBackground(new Color(255,219,170));
		jbtn_upd.setForeground(Color.black);
		jbtn_del.setBackground(new Color(255,219,170));
		jbtn_del.setForeground(Color.black);
		jbtn_det.setBackground(new Color(255,219,170));
		jbtn_det.setForeground(Color.black);
		
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		jp_north.add(jbtn_det);
		this.add("South",jlb_time);
		this.add("North",jp_north);
		this.add("Center",jsp_address);
		this.setTitle("MVC패턴을 적용한 주소록 1.0");
		this.setSize(700, 500);
		this.setVisible(true);
		jth_address.setFont(new Font("맑은고딕",Font.BOLD,18));
		jth_address.setBackground(new Color(22,22,100));
		jth_address.setForeground(Color.white);
		//테이블 헤더 정렬 변경 불가
		jth_address.setReorderingAllowed(false);
		//테이블 헤더 크기 변경 불가
		jth_address.setResizingAllowed(false);
		//싱글 선택 가능하도록 하기
		jt_address.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt_address.setGridColor(Color.blue);
		jt_address.getColumnModel().getColumn(0).setPreferredWidth(80);
		jt_address.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt_address.getColumnModel().getColumn(2).setPreferredWidth(390);
		jt_address.getColumnModel().getColumn(3).setPreferredWidth(130);
		jt_address.repaint();
		refreshData();
	}
	protected void deleteActionPerformed(ActionEvent e) {
		//System.out.println("삭제");
		//사용자가 선택한 로우의 값을 담기
		int index = jt_address.getSelectedRow();
		if(index<0) {
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.");
			return;
		}else {
			try {
				//paVO에 담을 정보는  command=delete and id=u_id
				AddressVO paVO = new AddressVO();
				AddressVO raVO = null;
				//String u_id = (String)dtm_address.getValueAt(index, 0);
				//사용자가 선택한 아이디를 담을 변수
				String u_id = null;
				//dtm_address.getRowCount() - DefaultTableModel에 담긴
				//로우의 갯수를 계산해줌.
				for(int i=0;i<dtm_address.getRowCount();i++) {
					//테이블에서 선택한 로우가 있는지 체크하여 있으면 true 없으면 false를
					//반환하는 메소드
					if(jt_address.isRowSelected(i)) {
						//getValueAt(로우인덱스값,컬럼자리값) 파라미터 두 개 주면
						//그 위치의 값을 가져오는 메소드임.
						u_id = (String)dtm_address.getValueAt(i, 0);
						AddressBookCtrl aCtrl = new AddressBookCtrl();
						//AddressVO의 command변수에 delete값 저장하는 메소드 호출
						paVO.setCommand("delete");
						//AddressVO의 id변수에 u_id에 담긴 값을 저장하는 메소드 호출
						paVO.setId(u_id);
						//AddressBookCtrl의 send메소드 호출시 파라미터로 paVO넘겨서 호출하기
						raVO = aCtrl.send(paVO);
					}
				}	
				//raVO에 status변수에 저장된 값을 반환하는 메소드 호출하여 1과 비교함.
				//1이면 삭제 성공을 0이면 삭제 실패를 의미함.
				//이 때 1과 0은 오라클서버에서 반환값으로 줌.
				if(raVO.getStatus()==1) {//삭제 성공
					//삭제성공시 삭제된 로우를 제외한 나머지 로우를 가져오기 위해 다시 select문을 실행함.
					refreshData();
				}else{//raVO에 저장된 값이 0인 경우 삭제가 안된 경우이므로 메세지 처리함.
					JOptionPane.showMessageDialog(this, "삭제가 안되었습니다.");
					//메세지를 내보내고 나면 
					//deleteActionPerformed 메소드  탈출시킴.- 다시 이용하도록 유도함.
					return;
				}
			} catch (Exception e2) {
				System.out.println(e2.toString());
				System.out.println(e2.getMessage());
				e2.printStackTrace();
			}/////////end of try..catch
		}/////////////end of if
	}/////////////////end of deleteActionPerformed///////////////
	protected void detailActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		//이벤트 어디다 걸지?  - JTable(폼,이벤트), DefaultTableModel(값을 저장,값을입력)
		int index = jt_address.getSelectedRow();
		//로그를 출력할 때 - 주의사항
		//main를 가진 클래스는 sysout
		//main가 없는 클래스는 JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
		//System.out.println("index:"+index);
		if(index<0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 한 건만 선택하세요.","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		else {
			try {
				jt_address.clearSelection();
				AddressVO paVO = new AddressVO();
				String u_id = (String)dtm_address.getValueAt(index, 0);
				paVO.setId(u_id);
				paVO.setCommand("detail");
				AddressBookCtrl aCtrl = new AddressBookCtrl();
				AddressVO raVO = aCtrl.send(paVO);
				//선택한 후에 상세조회 화면이 열리면 기존에 선택한 로우는 clear처리
				subBook = null;
				subBook = new SubBook();
				//문제제기-어!!! 화면그리는 메소드가 사라졌네?
				subBook.set(raVO,label,aBook,false);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	protected void updateActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//버튼을 라벨을 가져옴
		subBook = null;
		subBook = new SubBook();
		subBook.set(new AddressVO(),label,aBook,false);
	}
	protected void insertActionPerformed(ActionEvent e) {
		String label = e.getActionCommand();
		subBook = null;
		subBook = new SubBook();
		subBook.set(null,label,aBook,true);		
	}
	//새로고침 처리 메소드 구현
	public void refreshData() {
		System.out.println("새로고침 처리");
		//이미 테이블에 있던 데이터는 삭제한다.
		while(dtm_address.getRowCount() > 0) {
			dtm_address.removeRow(0);
		}
		AddressBookCtrl aCtrl = new AddressBookCtrl();
//		List<AddressVO> list = aCtrl.send("select");
		List<Map<String,Object>> list = aCtrl.send("select");
		//Iterator는 읽기 쓰기 목적이 아닌 꺼내는데 유용한 메소드 제공
		Iterator<Map<String,Object>> it = list.iterator();
		Object keys[] = null;
		if((list==null)||(list.size()==0)) {
			JOptionPane.showMessageDialog(this, "데이터가 없습니다.");
		}
		else {
			
			/*
			 * for(int i=0;i<list.size();i++) { AddressVO raVO = list.get(i); //Vector를 생성한
			 * 이유는 DB에서 꺼낸값을 행단위로 dtm_address에 //추가할 수 있는 addRow(Vecotr|Object[])라는 메소드에
			 * 파라미터로 넣기 위함이다. Vector rowData = new Vector(); rowData.add(0, raVO.getId());
			 * rowData.add(1, raVO.getName()); rowData.add(2, raVO.getAddress());
			 * rowData.add(3, raVO.getHp()); dtm_address.addRow(rowData); }
			 */
			while(it.hasNext()) {
				Map<String,Object> data = it.next();
				keys = data.keySet().toArray();
				Vector rowData = new Vector();
				rowData.add(data.get(keys[0]));
				rowData.add(data.get(keys[1]));
				rowData.add(data.get(keys[2]));
				rowData.add(data.get(keys[3]));
				dtm_address.addRow(rowData);
			}
		}
	}
	public static void main(String[] args) {
		if(aBook==null) {
			aBook = new AddressBook();
		}
		aBook.initDisplay();
	}


}
