package com.helpme2;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendGroupLayout extends JPanel {
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	
	JLabel jl1 = new JLabel();
	JLabel jl2 = new JLabel();
	JLabel jl3 = new JLabel();

	public FriendGroupLayout() {
		jp1.add(jl1);
		jp2.add(jl2);
		jp3.add(jl3);
		jp1.setBackground(Color.LIGHT_GRAY);
		jp2.setBackground(Color.WHITE);
		jp3.setBackground(new Color(200, 40, 100));
		
		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		// 수평
		gl.setHorizontalGroup(gl.createSequentialGroup()
						.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(jp2, 158, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(jp3)
						);
		// 수직
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup(Alignment.BASELINE)
						.addComponent(jp1,50,50,GroupLayout.PREFERRED_SIZE)
						.addComponent(jp2,50,50,GroupLayout.PREFERRED_SIZE)
						.addComponent(jp3,50,50,GroupLayout.PREFERRED_SIZE)
						)
				);
	}

}
