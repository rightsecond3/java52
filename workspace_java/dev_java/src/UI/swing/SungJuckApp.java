package UI.swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class SungJuckApp extends JFrame implements ActionListener {
	///// 선언부
	JPanel jp_north = new JPanel();
	JLabel jl_inwon = new JLabel("인원수", JLabel.RIGHT);
	JLabel jl = new JLabel("명", JLabel.LEFT);
	JTextField jtf_inwon = new JTextField(10);
	JButton jbtn_add = new JButton("추가");
	Object data[][] = new Object[0][7];
	String cols[] = { "이름", "JAVA", "Oracle", "JSP", "총점", "평균", "석차" };
	DefaultTableModel dtm_list = null;
	DefaultTableColumnModel dtcm = null;
	DefaultListSelectionModel dlsm = null;
	TableColumn tc, tc1, tc2, tc3, tc4, tc5, tc6 = null;
	DefaultTableCellRenderer dtcr, dtcr1, dtcr2, dtcr3, dtcr4, dtcr5, dtcr6 = null;
	DefaultCellEditor dce, dce1, dce2, dce3, dce4, dce5, dce6 = null;
	JTextField jtf, jtf1, jtf2, jtf3, jtf4, jtf5, jtf6 = null;
	JTableHeader jth = null;
	int num = 0;

	JTable jt_list = null;
	JScrollPane jsp_list = null;
	Container cont = this.getContentPane();

	/*
	 * 문제 제기 화면을 처리하는 메소드 호출을 생성자에서 할 수도 있고 메인 메소드에서 할 수도 있다. 두가지 경우의 차이점에 대해 생각해
	 * 보세요.
	 */

	// *** 생성자
	public SungJuckApp() {
		// initDisplay();
	}

	// ** 화면처리
	public void initDisplay() {
		jbtn_add.addActionListener(this);
		jp_north.add(jl_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jl);
		jp_north.add(jbtn_add);
		cont.add("North", jp_north);
		// 창이 닫힐 때 자원반납하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(300, 250);
		this.setVisible(true);
	}

	// * 이벤트 처리부
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String inwon = jtf_inwon.getText();
		num = Integer.parseInt(inwon);
		if (obj == jbtn_add) {
			dtm_list = new DefaultTableModel(num, 7);
			dtcm = new DefaultTableColumnModel();
			dlsm = new DefaultListSelectionModel();
			jt_list = new JTable(dtm_list, dtcm, dlsm);
			jsp_list = new JScrollPane(jt_list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			// 이름
			dtcr = new DefaultTableCellRenderer();
			jtf = new JTextField();
			dce = new DefaultCellEditor(jtf);
			tc = new TableColumn();
			tc = new TableColumn(1, 120, dtcr, dce);
			tc.setHeaderValue("이름");
			dtcm.addColumn(tc);
			// JAVA
			dtcr1 = new DefaultTableCellRenderer();
			jtf1 = new JTextField();
			dce = new DefaultCellEditor(jtf1);
			tc1 = new TableColumn();
			tc1 = new TableColumn(1, 120, dtcr, dce);
			tc1.setHeaderValue("JAVA");
			dtcm.addColumn(tc1);
			// Oracle
			dtcr2 = new DefaultTableCellRenderer();
			jtf2 = new JTextField();
			dce = new DefaultCellEditor(jtf2);
			tc2 = new TableColumn();
			tc2 = new TableColumn(1, 120, dtcr, dce);
			tc2.setHeaderValue("Oracle");
			dtcm.addColumn(tc2);
			// JSP
			dtcr3 = new DefaultTableCellRenderer();
			jtf3 = new JTextField();
			dce = new DefaultCellEditor(jtf3);
			tc3 = new TableColumn();
			tc3 = new TableColumn(1, 120, dtcr, dce);
			tc3.setHeaderValue("JSP");
			dtcm.addColumn(tc3);
			// 총점
			dtcr4 = new DefaultTableCellRenderer();
			jtf4 = new JTextField();
			dce = new DefaultCellEditor(jtf4);
			tc4 = new TableColumn();
			tc4 = new TableColumn(1, 120, dtcr, dce);
			tc4.setHeaderValue("총점");
			dtcm.addColumn(tc4);
			// 평균
			dtcr5 = new DefaultTableCellRenderer();
			jtf5 = new JTextField();
			dce = new DefaultCellEditor(jtf5);
			tc5 = new TableColumn();
			tc5 = new TableColumn(1, 120, dtcr, dce);
			tc5.setHeaderValue("평균");
			dtcm.addColumn(tc5);
			// 석차
			dtcr6 = new DefaultTableCellRenderer();
			jtf6 = new JTextField();
			dce = new DefaultCellEditor(jtf6);
			tc6 = new TableColumn();
			tc6 = new TableColumn(1, 120, dtcr, dce);
			tc6.setHeaderValue("석차");
			dtcm.addColumn(tc6);
			cont.add("Center", jsp_list);
			cont.revalidate();
			cont.repaint();
			this.pack();
		}
	}

	// *메인메소드
	public static void main(String[] args) {
		SungJuckApp sja = new SungJuckApp();
		sja.initDisplay();
	}
}
