package com.basic;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

public class FileFramTest extends JFrame {

	public void init() {
		JLabel jl = new JLabel("너 뭐임?");
		String fileName = "text.txt";
		jl.setIcon(new ImageIcon("C:\\workspace_java\\dev_java\\src\\images\\download.png"));
		jl.setText("<html><br><br><br><br>"+fileName+"<br>다운로드</html>");
		this.add(jl);
		this.setVisible(true);
		this.setSize(300, 300);
	}
	public static void main(String[] args) {
		FileFramTest f = new FileFramTest();
		f.init();
	}

}
