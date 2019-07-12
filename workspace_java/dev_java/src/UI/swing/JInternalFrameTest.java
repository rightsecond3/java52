package UI.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class InnerFrame extends JInternalFrame{
	String data[][] = {
			            {"1_1","1_2","1_3"}
			           ,{"2_1","2_2","2_3"}
			           ,{"3_1","3_2","3_3"}
	                  };
	String cols[] = {"1번","2번","3번"};
	DefaultTableModel dtm = new DefaultTableModel(data,cols);
	JTable jt = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jt);
	InnerFrame(String title,boolean a,boolean b,boolean c,boolean d){
		super(title,a,b,c,d);
		this.setTitle(title);
		this.setSize(300, 200);
		this.setVisible(true);
		this.add(jsp);
	}
}
public class JInternalFrameTest extends JFrame implements ActionListener{
    JRootPane jrp = this.getRootPane();//JMenuBar
    Container cont = this.getContentPane();//swing component붙임
    JDesktopPane jdp = new JDesktopPane();
    JPanel jp_south = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton jbtn_new = new JButton("새창");
    JButton jbtn_excel = new JButton("엑셀");
    int excel = 0;
    int n = 0;
    public void initDisplay() {
    	jbtn_new.addActionListener(this);
    	jbtn_excel.addActionListener(this);
    	jp_south.add(jbtn_new);
    	jp_south.add(jbtn_excel);
    	cont.add("South",jp_south);
    	cont.add("Center",jdp);//센터에 들어올 내부 프레임 InnerFrame
    	this.setSize(700, 400);
    	this.setVisible(true);
    }
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JInternalFrameTest jif = new JInternalFrameTest();
		jif.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==jbtn_new) {
			InnerFrame inn = new InnerFrame("새창"+ ++n,true ,true ,true ,true);
			jdp.add(inn);
		}
		else if(obj==jbtn_excel) {
			ExcelFrame inn = new ExcelFrame("Exel "+ ++excel,true,true,true,true);
			jdp.add(inn);
		}
	}

}