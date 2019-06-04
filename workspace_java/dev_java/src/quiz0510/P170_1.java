package quiz0510;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class P170_1 extends JFrame{
	String title;
	JButton jbtn = new JButton("전송");
	
	public P170_1() {
		initDisplay();
	}
	public P170_1(String title) {
		this.title=title;
		//주의 : title을 먼저 초기화하고 화면을 출력해야함.
		initDisplay();
	}
	public void initDisplay() {
		P170_1Event pEvent = new P170_1Event();//this->P170_1
		//P170_1Event pEvent = new P170_1Event(jbtn);
		jbtn.addActionListener(pEvent);
		this.add("North", jbtn);
		this.setTitle(title);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		P170_1 p2 = new P170_1("Hello");
	}
}