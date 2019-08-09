package com.helpme5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class SettingImg extends JDialog implements ActionListener {
	JComboBox jcb = null;
	String[] img = {"default","memo","hana1","kid","hana2","hana3","haka","dohun"};
	JButton jbtn = new JButton("변경");
	Login login = null;
	
	public SettingImg(Login login) {
		this.login = login;
		jcb = new JComboBox(img);
		jbtn.addActionListener(this);
		this.setTitle("프로필 사진 변경");
		this.add("North",jcb);
		this.add("Center",jbtn);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jbtn)) {
			String changeimg = (String) jcb.getSelectedItem();
			try {				
				login.oos.writeObject(Protocol.SETTING_IMG+Protocol.seperator+login.mem_id+Protocol.seperator+changeimg);
				this.dispose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
