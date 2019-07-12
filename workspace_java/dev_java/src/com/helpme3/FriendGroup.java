package com.helpme3;


import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FriendGroup extends JPanel {

	public FriendGroup() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		JLabel jl1 = new JLabel();
		JLabel jl2 = new JLabel();
		JLabel jl3 = new JLabel();

		jl1.setText("1");
		jl2.setText("2");
		jl3.setText("3");

		jp1.add(jl1);
		jp2.add(jl2);
		jp3.add(jl3);

		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);

		// 수직
		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
				.addComponent(jp2, 158, 158, GroupLayout.PREFERRED_SIZE).addComponent(jp3));
		// 수평
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(jp2, 50, 50, GroupLayout.PREFERRED_SIZE).addComponent(jp3)));

	}

	public static void main(String[] args) {
		FriendGroup f = new FriendGroup();
	}

}
