package com.helpme5;

import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatMemberListPanel extends JPanel {
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JLabel jl1 = new JLabel();//사진
	JLabel jl2 = new JLabel();//닉네임
	String imgPath = "C:\\workspace_java\\dev_java\\src\\images\\";
	ChatMemberList cml = null;
	Map<String, Object> map = null;
	////////////생성자
	public ChatMemberListPanel(Map<String, Object> map, ChatMemberList cml) {
		this.map = map;
		this.cml = cml;
		//////////////////////////////////////////////// 프로필
		ImageIcon img = new ImageIcon(imgPath + "default" + ".png");
		Image originImg = img.getImage();
		Image changedImg = originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		jl1.setIcon(new ImageIcon(changedImg));
		////////////////////////////////////////////////// 닉네임
		jl2.setText(map.get("fri_fnick").toString());
		////////////////////////////////////////////////// 라디오 버튼 액션
		
		jp1.add(jl1);
		jp2.add(jl2);
		jp2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		GroupLayout gl = new GroupLayout(this);
		this.setLayout(gl);
		
						
		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
				.addComponent(jp2));
		// 수평
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jp1, 50, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(jp2)));
	}
	
	
}
