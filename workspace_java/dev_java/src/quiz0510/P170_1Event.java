package quiz0510;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P170_1Event implements ActionListener{
	P170_1 ppp = new P170_1();
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//전송
		if("전송".equals(label)) {
//			p170_1.jbtn.setText("보내기");
			ppp.jbtn.setText("보내기");
		}
	}
}